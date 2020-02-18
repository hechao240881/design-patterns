package singletonTest03;

public class SingletonTest03 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);  //true
        System.out.println(instance.hashCode() == instance1.hashCode());    //true
    }
}

/**
 * 懒汉式1（线程不安全）
 */
class Singleton{
    private static Singleton singleton;

    private Singleton(){}

    //当调用 getInstance 才能创建单例对象，饿汉式
    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
/**
 * 优缺点说明:
 * 1) 起到了LazyLoading的效果，但是只能在单线程下使用。
 *
 * 2) 如果在多线程下，一个线程进入了if(singleton==null)判断语句块，还未来得及往下执行，另一个线程也通过
 * 了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式
 *
 * 3) 结论:在实际开发中，不要使用这种方式.
 */