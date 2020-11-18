package com.nb.nbbase2.aspect;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nb.nbbase2.beans.Result;
import com.nb.nbbase2.constant.SysConstant;
import com.nb.nbbase2.service.SysDictService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字典aop类
 * create by lihaoyang on 2020/10/28
 */
@Slf4j
@Aspect  //标识该类是一个切面
@Component
public class DictAspect {

    @Autowired
    private SysDictService sysDictService;

    @Autowired
    private ObjectMapper objectMapper;

    //切入点
    @Pointcut("execution(public * com.nb.nbbase2.*.*Controller.*(..))")
    public void dictPointCut() {

    }


    @Around("dictPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Object result = point.proceed();
        long start=System.currentTimeMillis();
        //解析字典
        this.parseDictText(result);
        long end=System.currentTimeMillis();
        log.debug("AOP解析字典耗时{}ms",(end-start));

        return result;
    }

    /**
     * 解析字典
     * @param result
     */
    private void parseDictText(Object result) {

        //如果control返回的是Result对象
        if(result instanceof Result){
            //如果是分页， TODO:是不是也可以处理不分页的list??或者单个对象？道理一样，这里就不写了
            if(((Result) result).getResult() instanceof IPage){
                //存放字典转换加工处理后的结果列表
                List<JSONObject> items = new ArrayList<>();
                IPage iPage = (IPage) ((Result) result).getResult();
                //遍历分页列表，
                for(Object record : iPage.getRecords()){
                    //解决@JsonFormat注解解析不了的问题，这个我没实验，先这样吧！
                    //一行数据的json：如{"sex":1,"id":9,"userType":3,"email":"ttrrr@qq.com","username":"admin后台","status":0}
                    String json = null;
                    try {
                        json = objectMapper.writeValueAsString(record);
                    } catch (JsonProcessingException e) {
                        log.error("翻译字典json解析失败:"+e.getMessage(),e);
                    }
                    //存放加工处理后的一行数据，准备往里头加字段text用
                    JSONObject itemObj = JSONObject.parseObject(json);
                    System.err.println("对象==========> "+itemObj.toJSONString());
                    //反射获取到所有属性
                    for(Field field : getAllFields(record)){
                        Dict dict = field.getAnnotation(Dict.class);
                        if(dict != null){
                            //获取实体类成员变量上的@Dict注解的dictCode值 比如@Dict(dictCode = "sex")
                            String dictCode = dict.dictCode();
                            //获取属性的值，比如sex=1
                            String filedValue =  String.valueOf(itemObj.get(field.getName()));
                            //翻译字典，加_text
                            String itemText = convertDictValue2Text(dictCode,filedValue);
                            itemObj.put(field.getName()+ SysConstant.DICT_LABEL_SUFFIX,itemText);

                            //date类型默认转换string格式化日期
                            //if (field.getType().getName().equals("java.util.Date")&&field.getAnnotation(JsonFormat.class)==null&&item.get(field.getName())!=null){
                            //    SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            //    item.put(field.getName(), aDate.format(new Date((Long) item.get(field.getName()))));
                            //}
                        }
                    }
                    items.add(itemObj);
                }
                //////set给分页////
                iPage.setRecords(items);
            }
        }
    }


    /**
     * 根据字典code和字典值，转换为字典text文本
     * @param dictCode 字典表code 比如sex
     * @param dictValue 字典项value 比如男=1
     * @return
     */
    private String convertDictValue2Text(String dictCode,String dictValue){
        if(StringUtils.isEmpty(dictValue)){
            return null;
        }
        StringBuilder dictText = new StringBuilder();
        //可能一个字段存多个字典值,比如：允许性别字段(1,2)男女都允许,逗号分隔的，这里需要分隔一下，循环处理。
        //如果没有一个字典存多个字典的需求，直接用一次查询翻译就好了？？
        String[] dictValueArr = dictValue.split(",");
        if(ArrayUtils.isNotEmpty(dictValueArr)){
            for(String dictVal : dictValueArr){
                String text = null;

                if(dictVal.trim().length() != 0){
                    text = sysDictService.findTextByCodeAndDictItemValue(dictCode,dictVal);
                }
                if(text != null){
                    if(!"".equals(dictText.toString())){
                        dictText.append(",");
                    }
                    dictText.append(text);
                }
            }
        }
        return dictText.toString();
    }


    /**
     * 获取类的所有属性，包括父类
     *
     * @param object
     * @return
     */
    public static Field[] getAllFields(Object object) {
        Class<?> clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            //对于继承的对象，父类的属性也得获取一下
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }


}
