package org.zyg.dao;


import org.apache.ibatis.annotations.Param;
import org.zyg.domain.User;

public interface UserMapper {
    User queryUser(@Param("name") String userName, @Param("pass") String userPass);
    Integer addUser(User user);
}
