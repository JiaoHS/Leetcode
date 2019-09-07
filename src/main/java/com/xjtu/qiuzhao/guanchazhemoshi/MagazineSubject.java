package com.xjtu.qiuzhao.guanchazhemoshi;


import java.util.ArrayList;
import java.util.List;

/**
 * @auther coraljiao
 * @date 2019/9/6 15:51
 * @description
 */
public class MagazineSubject implements Subject {
    //存放订阅者
    private List<java.util.Observer> observers = new ArrayList<java.util.Observer>();

    //期刊版本
    private int version;


    //该杂志发行了新版本
    public void publish() {
        //新版本
        this.version++;
        //信息更新完毕，通知所有观察者
        notifyObserver();
    }

    @Override
    public void addObserver(java.util.Observer obj) {
        observers.add(obj);
    }

    @Override
    public void deleteObserver(java.util.Observer obj) {
        int i = observers.indexOf(obj);
        if(i>=0){
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<observers.size();i++){
            Observer o=(Observer)observers.get(i);
            o.update(version);
        }
    }

}
