package com.lgxtvt.common.utils;

/**
 * @author LGX_TvT
 * @date 2018-09-06 9:19
 */
public class PathUtil {

    public static String pathFormate(String path){
        if(path != null && path != ""){
            path = path.replace(".","/");
            return path;
        }
        return "";
    }
}
