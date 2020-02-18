package singletonTest01;

/*介绍：所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，
对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法（静态方法）*/

/**
 * 1) 单例模式保证了系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使 用单例模式可以提高系统性能
 * 2) 当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new
 * 3) 单例模式使用的场景:需要频繁的进行创建和销毁的对象、创建对象时耗时过多或耗费资源过多(即:重量级
 *  对象)，但又经常用到的对象、工具类对象、频繁访问数据库或文件的对象(比如数据源、session 工厂等)
 *
 * 单例模式八种方式：
 * 1、饿汉式（静态常量）
 * 2、饿汉式（静态代码块）
c
 */
public class SingletonTest01 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);  //true
        System.out.println(instance.hashCode() == instance1.hashCode());    //true
    }
}

/**
 * 饿汉式（静态常量）
 * 1) 构造器私有化 (防止 new )
 * 2) 类的内部创建对象
 * 3) 向外暴露一个静态的公共方法。getInstance
 */
class Singleton {
    private Singleton() {
    }

    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * 优缺点说明:
 * 1) 优点:这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 * <p>
 * 2) 缺点:在类装载的时候就完成实例化，没有达到LazyLoading的效果。
 * 如果从始至终从未使用过这个实例，则会造成内存的浪费
 * <p>
 * 3) 这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载时就实例化，
 * 在单例模式中大 多数都是调用 getInstance 方法，但是导致类装载的原因有很多种，
 * 因此不能确定有其他的方式(或者其他的静 态方法)导致类装载，这时候初始化 instance 就没有达到 lazy loading 的效果
 * <p>
 * 4) 结论:这种单例模式可用，可能造成内存浪费
 */
