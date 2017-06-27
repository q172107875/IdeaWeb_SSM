package com.heitian.ssm.service;

import com.heitian.ssm.dao.TUserMapper;
import com.heitian.ssm.pojo.TUser;
import com.heitian.ssm.pojo.TUserExample;
import com.heitian.ssm.service.impl.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qibo on 2017/6/24.
 */
@Service("ITUserService")
public class TUserService implements ITUserService {

    @Autowired
    private TUserMapper tUserMapper;
    public List<TUser> selectExample(TUserExample tUserExample) {
        return tUserMapper.selectByExample(tUserExample);
    }

    public TUser selectTUserId(long id) {
        return tUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean selectTUserName(String name) {
        System.out.printf("Name="+name.toString());
        TUser tUser = tUserMapper.findUserByUserName(name);
        if (tUser==null){
            return true;
        }
        System.out.printf("NAME="+tUser.toString());
        return false;
    }

    @Override
    public boolean selectTUserPhone(String phone) {
        TUser tUser = tUserMapper.findUserByUserPhone(phone);
        if (tUser==null){
            return true;
        }
        System.out.printf("Phone="+tUser.toString());
        return false;
    }

    @Override
    public boolean selectTUserEmail(String email) {
        TUser tUser = tUserMapper.findUserByUserEmail(email);
        if (tUser==null){
            return true;
        }
        System.out.printf("Email="+tUser.toString());
        return false;
    }

    @Override
    public int insertTUser(TUser tUser) {
        return tUserMapper.insert(tUser);
    }
}
