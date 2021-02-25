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
        AnnotatedType[] annotatedInterfaces = a.getAnnotatedInterfaces();
        for (AnnotatedType ai:annotatedInterfaces
             ) {
            Type type = ai.getType();
            String typeName = type.getTypeName();
            System.out.println(typeName);
        }

    }

}
