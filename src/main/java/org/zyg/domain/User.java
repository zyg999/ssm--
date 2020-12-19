package org.zyg.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {
    @NotNull(message = "用户名不允许为空")
    @Pattern(regexp = "[\\w\\u4e00-\\u9fa5]+", message = "用户名不能含有特殊字符")
    private String userName;
    @NotNull(message = "密码不允许为空")
    @Length(min = 8, max = 12, message = "密码必须在8~12位")
    private String userPass;
    public User() {

    }

    public User(@NotNull(message = "用户名不允许为空") @Pattern(regexp = "\\w+", message = "用户名不能含有特殊字符") String userName, @NotNull(message = "密码不允许为空") @Length(min = 8, max = 12, message = "密码必须在8~12位") String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", pass='" + userPass + '\'' +
                '}';
    }
}
