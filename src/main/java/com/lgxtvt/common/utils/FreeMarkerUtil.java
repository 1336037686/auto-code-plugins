package com.lgxtvt.common.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;

/**
 * FreeMarker模板工具
 * @author LGX_TvT
 * @date 2018-09-06 0:41
 */

public class FreeMarkerUtil {

    /**
     * 生成页面
     * @param ftlPath ftl模板路径
     * @param ftlName ftl文件名称
     * @param dataModel 数据模型
     * @param path 生成路径
     */
    public static void generatePojoPage(String ftlPath,String ftlName,Map<String, Object> dataModel,String path){
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            cfg.setDirectoryForTemplateLoading(new File(ftlPath));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template temp = cfg.getTemplate(ftlName);
            Writer out = new FileWriter(path);
            temp.process(dataModel, out);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
