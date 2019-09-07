package com.xjtu.qiuzhao.daili.dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther coraljiao
 * @date 2019/9/6 15:07
 * @description
 */
public class LogHandler implements InvocationHandler {
    private Object target;

    public LogHandler(Object object){
        super();
        this.target =  object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //增强处理
        Object o = method.invoke(target,args);
        //增强处理
        return o;
    }
}
