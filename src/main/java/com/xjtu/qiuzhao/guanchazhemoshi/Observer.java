package com.xjtu.qiuzhao.guanchazhemoshi;

/**
 * @auther coraljiao
 * @date 2019/9/6 15:51
 * @description
 */
public interface Observer {
    //当主题状态改变时,更新通知
    public void update(int version);
}
