package com.lgxtvt.modules.app.entity;

/**
 * @author LGX_TvT
 * @date 2018-09-06 0:19
 */
public class ClassEntity {

    private String className;

    private String classType;

    private Integer getterKey;

    private Integer setterKey;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Integer getGetterKey() {
        return getterKey;
    }

    public void setGetterKey(Integer getterKey) {
        this.getterKey = getterKey;
    }

    public Integer getSetterKey() {
        return setterKey;
    }

    public void setSetterKey(Integer setterKey) {
        this.setterKey = setterKey;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "className='" + className + '\'' +
                ", classType='" + classType + '\'' +
                ", getterKey=" + getterKey +
                ", setterKey=" + setterKey +
                '}';
    }
}
