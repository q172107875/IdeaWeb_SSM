package com.heitian.ssm.service.impl;

import com.heitian.ssm.pojo.TUser;
import com.heitian.ssm.pojo.TUserExample;

import java.util.List;

/**
 * Created by qibo on 2017/6/24.
 */
public interface ITUserService {

    List<TUser> selectExample(TUserExample tUserExample);
    /**
     * 根据id查找角色名称
     * @param id
     * @return
     */
    TUser selectTUserId(long id);
    /**
     * 根据name查找角色名称
     * @param name
     * @return
     */
    boolean selectTUserName(String name);
    /**
     * 根据Phone查找角色名称
     * @param phone
     * @return
     */
    boolean selectTUserPhone(String phone);
    /**
     * 根据Phone查找角色名称
     * @param email
     * @return
     */
    boolean selectTUserEmail(String email);
    /**
     * 根据Phone查找角色名称
     * @param tUser
     * @return
     */
    int insertTUser(TUser tUser);

}
