package com.lgxtvt.common.template;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

/**
 * 自定义首字母大写指令
 * @author LGX_TvT
 * @date 2018-09-06 1:07
 */
public class UpperInitials implements TemplateDirectiveModel {
    private static final String PARAM_NAME_COUNT = "value";

    /**
     * 自定义首字母大写指令
     * @param env 用于设置环境
     * @param params 用于获取参数
     * @param loopVars
     * @param body 用于操作标签body，如<xxx>标签body</xxx>
     */
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String  upperStr = "";
        if (loopVars.length != 0) {
            throw new TemplateModelException("This directive doesn't allow loop variables.");
        }
        if (params.isEmpty()){
            throw new TemplateModelException("params(Value) is Empty");
        }
        //获取参数
        Iterator paramIter = params.entrySet().iterator();
        //遍历Map集合
        while (paramIter.hasNext()) {
            Map.Entry ent = (Map.Entry) paramIter.next();
            //获取Key与Value
            String paramName = (String) ent.getKey();
            TemplateModel paramValue = (TemplateModel) ent.getValue();
            if (PARAM_NAME_COUNT.equals(paramName)){
                //判断value是不是字符串
                if (paramValue instanceof TemplateScalarModel){
                    String value = ((TemplateScalarModel) paramValue).getAsString();
                    if (!"".equals(value)){
                        //首字母转换为大写
                        upperStr = value.substring(0, 1).toUpperCase() + value.substring(1);
                    }
                }else{
                    throw new TemplateModelException("Type error.This is not TemplateScalarModel(String)");
                }
            }
            //通过env获取输出流输出
            Writer out = env.getOut();
            out.write(upperStr);
            out.flush();
        }
    }
}
