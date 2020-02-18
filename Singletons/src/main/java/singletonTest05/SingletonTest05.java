package singletonTest05;

public class SingletonTest05 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);  //true
        System.out.println(instance.hashCode() == instance1.hashCode());    //true
    }
}

/**
 * 懒汉式3(线程安全，同步代码块)  不能使用
 * 1、这种写法，本意是想对第四种实现方式做改进，因为前面的同步方法效率太低，改为同步产生实例化的代码块
 * 2、但是这种同步并不能起到线程同步的作用。跟第三种实现方式遇到的情形一致，
 * 假如一个线程进入了 if 判断语句块，还未来及的往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例
 *
 * 结论：在实际开发中，不能使用这种方式
 */
class Singleton {
    private  Singleton() {}

    private static Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}