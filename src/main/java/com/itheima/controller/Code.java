package com.itheima.controller;

/**
 * @ClassName Code.java
 * @Author xazhao
 * @Create 2022.06.25
 * @Description TODO
 */
public class Code {

    // 成功
    public static final Integer ADD_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer SELECT_OK = 20041;

    // 失败
    public static final Integer ADD_ERROR = 20010;
    public static final Integer DELETE_ERROR = 20020;
    public static final Integer UPDATE_ERROR = 20030;
    public static final Integer SELECT_ERROR = 20040;

    // 异常
    public static final Integer SYSTEM_ERROR = 50001;
    public static final Integer SYSTEM_TIMEOUT_ERROR = 50002;
    public static final Integer SYSTEM_UNKNOW_ERROR = 50003;

    public static final Integer BUSINESS_ERROR = 60002;
}
