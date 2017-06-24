package com.heitian.ssm.service.impl;

import com.heitian.ssm.pojo.TUser;
import com.heitian.ssm.pojo.TUserExample;

import java.util.List;
import java.util.Set;

/**
 * Created by qibo on 2017/6/24.
 */
public interface ITUserService {

    List<TUser> selectExample(TUserExample tUserExample);

    TUser selectTUserId(long id);

    TUser selectTUserName(String name);

    /**
     * 根据账号查找角色名称
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) ;

    /**
     * 根据账号查找权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) ;
}
