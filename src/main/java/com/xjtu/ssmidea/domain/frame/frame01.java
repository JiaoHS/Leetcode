package com.xjtu.ssmidea.domain.frame;

import java.awt.*;

public class frame01 {
    public static void main(String[] args){
        Frame  f = new Frame("my window");
        f.setLayout(new FlowLayout());//设置布局管理器
         f.setSize(500,400);//设置窗体大小
         f.setLocation(300,200);//设置窗体出现在屏幕的位置
         f.setIconImage(Toolkit.getDefaultToolkit().createImage("qq.png"));
         f.setVisible(true);
    }
}
