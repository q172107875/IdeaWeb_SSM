package com.heitian.ssm.service;

import com.heitian.ssm.dao.TUserMapper;
import com.heitian.ssm.pojo.TUser;
import com.heitian.ssm.pojo.TUserExample;
import com.heitian.ssm.service.impl.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    public TUser selectTUserName(String name) {
        return tUserMapper.findUserByUsername(name);
    }

    @Override
    public Set<String> findRoles(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }
}
