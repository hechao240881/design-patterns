package singletonTest08;

public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);  //true
        System.out.println(instance.hashCode());    //1802598046
        System.out.println(instance2.hashCode());   //1802598046
        instance.sayOK();   //ok~
    }
}

/**
 * 枚举
 * 优缺点说明:
 * 1) 这借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建 新的对象。
 * 2) 这种方式是EffectiveJava作者JoshBloch提倡的方式
 * 3) 结论:推荐使用
 */
enum Singleton {
    INSTANCE; //属性

    public void sayOK() {
        System.out.println("ok~");
    }

}