package com.heitian.ssm.controller;

import com.heitian.ssm.pojo.TUser;
import com.heitian.ssm.service.impl.ITUserService;
import com.heitian.ssm.shiro.MD5Util;
import com.heitian.ssm.utils.CommonUtil;
import com.heitian.ssm.utils.IPUtils;
import com.heitian.ssm.utils.StringUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private ITUserService itUserService;

    @RequestMapping(value="/showUser",method={RequestMethod.POST})
    @ResponseBody
    public JSONObject showUser(@RequestBody TUser tUser, HttpServletRequest request, Model model){
        log.info("\n用户IP="+IPUtils.getRemoteAddr(request));
        if (tUser.getId()!=null){
            log.info(tUser.getId()+"");
            return CommonUtil.parseJson("0","有了",itUserService.selectTUserId(tUser.getId()));
        } else if (itUserService.selectTUserName(tUser.getUserName())) {
            return CommonUtil.parseJson("0", "没有", tUser);
        } else {
            return CommonUtil.parseJson("0", "有了", tUser);
        }
    }
    @RequestMapping(value="/show",method={RequestMethod.POST})
    @ResponseBody
    public JSONObject show(@RequestBody TUser tUser, HttpServletRequest request, Model model){
        log.info("\n用户IP="+IPUtils.getRemoteAddr(request));
        if (tUser.getId()!=null){
            log.info(tUser.getId()+"");
            return CommonUtil.parseJson("0","有了",itUserService.selectTUserId(tUser.getId()));
        } else if (itUserService.selectTUserName(tUser.getUserName())) {
            return CommonUtil.parseJson("0", "没有", tUser);
        } else {
            return CommonUtil.parseJson("0", "有了", tUser);
        }

    }
    @RequestMapping(value="/userRegister",method={RequestMethod.POST})
    @ResponseBody
    public JSONObject userRegister(@RequestBody TUser tUser, HttpServletRequest request, Model model){
        log.info("\n用户IP="+IPUtils.getRemoteAddr(request));
        if (itUserService.selectTUserName(tUser.getUserName())) {
            log.info(tUser.getUserName() + "");
            if (itUserService.selectTUserPhone(tUser.getUserPhone())) {
                log.info(tUser.getUserPhone() + "");
                if (itUserService.selectTUserEmail(tUser.getUserEmail())) {
                    log.info(tUser.getUserEmail() + "");
                    if (StringUtil.isNotEmpty(tUser.getUserPwd())) {
                        log.info(tUser.getUserPwd() + "");
                        tUser.setCreateTime(new Date());
                        tUser.setModifyTime(new Date());
                        tUser.setPwdSalt(CommonUtil.getCode(6,4));
                        tUser.setUserPwd(MD5Util.md5(tUser.getUserPwd(),tUser.getPwdSalt()));
                        if (itUserService.insertTUser(tUser) > 0) {
                            return CommonUtil.parseJson("0", "注册成功", tUser);
                        } else {
                            return CommonUtil.parseJson("1","注册失败",tUser);
                        }
                    } else {
                        return CommonUtil.parseJson("1","密码不能为空",tUser);
                    }
                } else {
                    return CommonUtil.parseJson("1","该邮箱已注册",tUser);
                }
            } else {
                return CommonUtil.parseJson("1","该手机号已注册",tUser);
            }
        } else {
            return CommonUtil.parseJson("1","该用户已注册",tUser);
        }

    }
//    @RequestMapping("/id")
//    @ResponseBody
//    public List<TUser> selectUserById(@RequestParam(value = "id",required = false,defaultValue = "1") long id, Model model) {
//        TUser user = userService.getUserById((long)id);
//        List<TUser> users = new ArrayList<TUser>();
//        users.add(user);
//        model.addAttribute("userList", users);
//        return users;
//    }
//    @RequestMapping(value = "/showUserId")
//    @ResponseBody
//    public TUser showUserId(@RequestParam Long id){
//        TUser user = userService.getUserById((long)id);
//
//        return user;
//    }
}
