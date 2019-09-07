package com.xjtu.qiuzhao.daili.cglibdongtaidaili;

import com.xjtu.qiuzhao.daili.dongtaidaili.Car;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @auther coraljiao
 * @date 2019/9/6 15:15
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //设置父类，被代理类（这里是Car.class）
        enhancer.setSuperclass(Car.class);
        //设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                //增强处理...
                Object o= proxy.invokeSuper(obj, args);//代理类调用父类的方法
                //增强处理...
                return o;
            }
        });
        //创建代理类并使用回调（用父类Car去引用）
        Car car = (Car) enhancer.create();
        //执行目标方法
        System.out.println(car.move());
    }
}
