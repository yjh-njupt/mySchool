import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;

/**
 * @author ：yjh
 * @date ：Created in 2021/2/14 18:36
 * @description :
 * @version: v 1.0
 */

public class JVM {
    @Test
    public void demo(){
        //创建一个类的实例，然后获取代表它信息的Class
        UnName unName = new UnName();
        Class c = UnName.class;
        System.out.println(c);
        //Class类获得了打印,Class拥有私有的构造器，所以只能由虚拟机来创建Class的对象
    }

    //上面的方法，还有另一种方法获得Class,通过继承自Object的静态方法getClass()方法
    @Test
    public void demo1(){
        UnName unName = new UnName();
        Class<? extends UnName> aClass = unName.getClass();
        System.out.println(aClass.toString());
    }

    @Test
    public void demo2(){
        Class a = UnName.class;
        ClassLoader classLoader = a.getClassLoader();
        String s = classLoader.toString();
        System.out.println("the UnName's classloadername is =" + s);//sun.misc.lancher$classloader@18b4aac2

        AnnotatedType[] annotatedInterfaces = a.getAnnotatedInterfaces();

        for (AnnotatedType ai:annotatedInterfaces
             ) {
            Type type = ai.getType();
            String typeName = type.getTypeName();
            System.out.println(typeName); //nothing happend,我以为会出现奇迹
        }
    }


    @Test
    public void demo3(){
        UnName unName = new UnName();
        ClassLoader classLoader = unName.getClass().getClassLoader();
        String s = classLoader.toString();
        System.out.println("the UnName's classloadername is =" + s);//sun.misc.lancher$classloader@18b4aac2

        String s1 = unName.toString();
        System.out.println("s1的默认tostring方式是：" + s1);
    }


    //虚拟机提供了几种常见的类加载器这似乎和Lancher有关
    @Test
    public void demo4(){
        
    }

}
