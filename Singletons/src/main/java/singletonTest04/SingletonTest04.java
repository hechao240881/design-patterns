package singletonTest04;

public class SingletonTest04 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);  //true
        System.out.println(instance.hashCode() == instance1.hashCode());    //true
    }
}

/**
 * 懒汉式2(线程安全，同步方法)
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题 //即懒汉式
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
/**
 * 优缺点说明:
 * 1) 解决了线程安全问题
 * 2) 效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。而其实这个方法只执行
 * 一次实例化代码就够了，后面的想获得该类实例，直接 return 就行了。方法进行同步效率太低
 * <p>
 * 3) 结论:在实际开发中，不推荐使用这种方式
 */