package com.lgxtvt.modules.app.controller;

import com.lgxtvt.common.template.UpperInitials;
import com.lgxtvt.common.utils.FreeMarkerUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
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

    @RequestMapping("/getAttr")
    public void getAttr(@RequestBody Map dataMap){
        String path = (String)dataMap.get("basePath") + (String)dataMap.get("className") + ".java";
        dataMap.put("nowDateTime",new Date());
        dataMap.put("UpperInitials",new UpperInitials());

        try {
            File file = ResourceUtils.getFile("classpath:ftl");
            String absolutePath = file.getAbsolutePath();
            System.out.println(absolutePath);
            FreeMarkerUtils.generatePojoPage(absolutePath,"pojoTemplate.ftl", dataMap, path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(dataMap);
    }
}
