package com.lgxtvt.modules.app.controller;

import com.lgxtvt.common.template.UpperInitials;
import com.lgxtvt.common.utils.FreeMarkerUtil;
import com.lgxtvt.common.utils.PathUtil;
import com.lgxtvt.modules.app.entity.Message;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * 代码生成控制类
 * @author LGX_TvT
 * @date 2018-09-06 0:10
 */

@RestController
@RequestMapping("/codegenerate")
public class CodeGenerateController {

    /**
     * {
     *      basePath:'xxxxxxx'
     *      packagePosition:'com.fjut',
     *      className:"HelloWorld",
     *      mainKey:1,
     *      toStringKey:1,
     *      attributes:[
     *          {classType:'String',getterKey:1,setterKey:1},
     *          {classType:'Integer',getterKey:0,setterKey:0}
     *      ]
     * }
     */

    @RequestMapping("/generatePojoCode")
    public Message generatePojoCode(@RequestBody Map dataMap){
        dataMap.put("nowDateTime",new Date());
        dataMap.put("UpperInitials",new UpperInitials());
        try {
            //生成路径
            String path = (String) dataMap.get("basePath") + PathUtil.pathFormate((String) dataMap.get("packagePosition") + "/");
            File basePath = new File(path);
            if(!basePath.exists()){
                basePath.mkdirs();
            }
            path = path + (String)dataMap.get("className") + ".java";
            //解决了打成jar包后访问不到ftl模板的问题
            FreeMarkerUtil.generatePojoPage("/ftl","pojoTemplate.ftl", dataMap, path);
            return new Message("生成成功",true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("生成失败",false);
        }
    }
}
