package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;

import java.util.List;

public interface IUserService {

    public UserInfo login(String usernam, String password) throws MyException;

    public List<UserInfo> selectAdmin();

    public int addUserInfo(UserInfo userInfo);

    public int deleteUserInfo(int id);

    public int updateUserInfo(UserInfo userInfo);

    public UserInfo findById(Integer id);



}
