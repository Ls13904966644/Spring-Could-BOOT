package cn.tedu.sp01.service;

import cn.tedu.sp01.pojo.User;

public interface UserService {

    //查询用户
    User getUser(Integer id);


    //增加用户积分
    //
    void  addScore(Integer id, Integer score);
}
