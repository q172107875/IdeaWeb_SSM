package com.heitian.ssm.utils;

import org.apache.log4j.Logger;

/**
 * Created by 17210 on 2017/6/25.
 */
public class GsonUtls<T>  {
    private static Logger log = Logger.getLogger(GsonUtls.class);
    public static void main(String[] args) {
        log.info(CommonUtil.getCode(6,1));
        log.info(CommonUtil.getCode(6,2));
        log.info(CommonUtil.getCode(6,3));
        log.info(CommonUtil.getCode(6,4));
        log.info(CommonUtil.getCode(6,5));
    }
}
