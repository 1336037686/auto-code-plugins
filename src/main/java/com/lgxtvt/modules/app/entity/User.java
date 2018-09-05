package com.lgxtvt.modules.app.entity;

/**
 * 用户实体类
 * @author LGX_TvT
 * @date 2018-09-05 17:46
 */
public class User {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
