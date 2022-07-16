package com.itheima.controller;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName ProjectExceptionAdvice.java
 * @Author xazhao
 * @Create 2022.06.25
 * @Description TODO
 */
//@RestControllerAdvice用于标识当前类为REST风格对应的异常处理器
@RestControllerAdvice // 声明当前类是一个异常处理器类
public class ProjectExceptionAdvice {

    //@ExceptionHandler用于设置当前处理器类对应的异常类型
    @ExceptionHandler(SystemException.class)
    public R doSystemException(SystemException exception) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new R(exception.getCode(), null, exception.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public R doBusinessException(BusinessException exception) {
        return new R(exception.getCode(), null, exception.getMessage());
    }

    //除了自定义的异常处理器，保留对Exception类型的异常处理，用于处理非预期的异常
    @ExceptionHandler(Exception.class) // 当前方法可以处理那些异常
    public R doException() {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        R r = new R(Code.SYSTEM_UNKNOW_ERROR, null, "服务器异常错误, 请稍后重试");
        return r;
    }
}
