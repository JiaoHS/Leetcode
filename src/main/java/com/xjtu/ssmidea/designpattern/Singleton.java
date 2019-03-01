package com.xjtu.ssmidea.designpattern;

/**
 * @auther coraljiao
 * @date 2019/3/1 12:48
 * @description
 */
public class Singleton {
    public static void main(String[] args) {

    }

}

//饿汉式1-2
//优点：可用，类加载的时候完成初始化，避免了多线程引发的同步问题
//缺点：没有达到LazyLoading的效果，假如从未使用过会造成资源的浪费
class Singleton1 {
    //静态常量
    private final static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {
    }

    public Singleton1 getInstance() {
        return singleton1;
    }
}

class Singleton2 {
    //静态常量
    private final static Singleton2 singleton1;

    static {
        singleton1 = new Singleton2();
    }

    private Singleton2() {
    }

    public Singleton2 getInstance() {
        return singleton1;
    }
}

//懒汉式,这种写法达到了LazyLoading的效果，单线程下是可以的，但是当多线程的时候，一个线程进行if (singleton3 == null)判断的时候，还没执行完
// ，另一个线程判断if (singleton3 == null)，就会造成产生多个实例
class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {
    }

    public Singleton3 getInstance() {
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}

//懒汉式的优化1：这种方式解决了线程安全的问题，对getSingleton4进行了代码同步
//但是效率太低了，每个线程想获得类的实例的时候，执行getSingleton4都要进行同步，其实呢这个方式只执行一次就行了，再想获得实例直接return就行了
class Singleton4 {
    private static Singleton4 singleton4;

    private Singleton4() {
    }

    public static synchronized Singleton4 getSingleton4() {
        if (singleton4 == null) {
            singleton4 = new Singleton4();
        }
        return singleton4;
    }
}

//懒汉式的优化2:放弃了同步方法，改为同步产生实例的代码块，
// 单线程下是可以的，但是当多线程的时候，一个线程进行if (singleton3 == null)判断的时候，还没执行完,另一个线程判断if (singleton3 == null)
// ，就会造成产生多个实例
class Singleton5 {
    private static Singleton5 singleton5;

    private Singleton5() {
    }

    public static Singleton5 getIntance() {
        if (singleton5 == null) {
            synchronized (Singleton5.class) {
                singleton5 = new Singleton5();
            }
        }
        return singleton5;
    }
}

//懒汉式的优化3：双重检查
//我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了，
//实例化只执行了一次，后面再调用的时候判断 if (singleton6 == null) 直接return实例
class Singleton6 {
    private static volatile Singleton6 singleton6;//1、内存可见性 2、防止指令重排

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (singleton6 == null) {
            synchronized (Singleton6.class) {
                if (singleton6 == null) {
                    singleton6 = new Singleton6();
                }
            }
        }
        return singleton6;
    }
}

//静态内部类,与饿汉式都是采用类加载的机制保证初始化实例的时候只有一个线程，饿汉式是只要类被加载的时候就产生实例没有LazyLoading的效果
//静态内部类在类加载的时候并没有立即实例化，而是在调用getIntance()的方法的时候才会加载类SingletonInstance并完成初始化
//类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的
class Singleton7 {
    public Singleton7() {
    }

    private static class SingletonInstance {
        private static final Singleton7 singleton7 = new Singleton7();
    }

    public static Singleton7 getIntance() {
        return SingletonInstance.singleton7;
    }
}

//枚举,借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。可能是因为枚举在JDK1.5中才添加，
// 所以在实际项目开发中，很少见人这么写过。
enum Singleton8 {
    INSTANCE;

    public void whateverMethod() {
    }
}
//你的第5个方法 是DCL 双重检查，并且他的问题不是跟第三种相同的，而是他是由于实例化对象时内存对象会进行重排序，就有可能会导致多线程的时候执行到if判断的时候还没被初始化。而你的第6个方法就是对DCL方法的改进，volatile 关键字就指定了禁止重排序