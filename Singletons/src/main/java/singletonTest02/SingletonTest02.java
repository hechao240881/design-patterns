package singletonTest02;

public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);  //true
        System.out.println(instance.hashCode() == instance1.hashCode());    //true
    }
}

/**
 * 饿汉式（静态代码块）
 * 1) 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，
 * 也是在类装载的时候，就执 行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
 * <p>
 * 2) 结论:这种单例模式可用，但是可能造成内存浪费
 */
class Singleton {
    //1. 构造器私有化, 外部能 new
    private Singleton() {
    }

    //2.本类内部创建对象实例
    private static Singleton instance;

    static {
        //3.在静态代码块中，创建单例对象
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }

}
