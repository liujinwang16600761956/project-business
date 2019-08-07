package com.neuedu.service.impl;

import com.neuedu.dao.UserInfoMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(String username, String password) throws MyException {


        //step1: 参数非空判断
        if(username==null||username.equals("") ){//用户名为空

            throw  new MyException("用户名不能为空","error");

        }
        if(password==null||password.equals("") ){//密码为空

            throw  new MyException("密码不能为空");

        }

        //setp2:判断用户名是否存在


        int result= userInfoMapper.isexistsusername(username);
        if(result==0){//用户名不存在

            throw new MyException("用户名不存在");
        }

        //step3:根据用户名和密码查询

        UserInfo userInfo=userInfoMapper.findUserByUsernameAndPassword(username, password);
        if(userInfo==null){//密码错误
            throw new MyException("密码错误");
        }

        if(userInfo.getRole()!=0){
            throw new MyException("没有权限");
        }

        return userInfo;


    }

    @Override
    public List<UserInfo> selectAdmin() {

        List<UserInfo> userInfos=userInfoMapper.selectAdmin();


        return userInfos;
    }


}
