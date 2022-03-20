package forAjob;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Day1 {
    // 运算符 & && 使用方式的差别
    @Test
    public void demo() {
        System.out.println("true&false=" + (true&false));
        System.out.println("false&true=" + (false&true));
        System.out.println("true&true=" + (true&true));
        System.out.println("false&false="  + (false&false));

        /* 输出：
        * true&false=false
          false&true=false
          true&true=true
          false&false=false*/
        System.out.println("true&&true=" + (true&&true));
        System.out.println("false&&true=" + (false&&true));
        System.out.println("true&&false=" + (true&&false));
        System.out.println("false&&false=" + (false&&false));
        /* 输出：
        * true&&true=true
          false&&true=false
          true&&false=false
          false&&false=false*/
    }


    /*
    * 构造器是否可以被继承，重写。
    *  答案是不能。
    * */
    @Test
    public void demo1() {
        /*
        * 构造器涉及java类加载过程：
        *
        * */
    }

    /*
      String不可继承
    * public final class String
            implements java.io.Serializable, Comparable<String>, CharSequence
    */
    @Test
    public void demo2() {
        String s = new String("l");
    }

    /**
    * hashcode
    * equals重写*/
    @Test
    public void demo3() {
        /* 先看 Object :
            equals(obj)
        *     return  this==obj
        *   native int hashcode()
        *  再看java.lang.String
        *   equals(obj)
        *
        *   模仿String写了一个Test却无法像使用String一样使用他
        * */

    }

    /*
    * char 字符集 UniCode字符集 16比特*/
    @Test
    public void demo4() {
        char s = '风';
        System.out.println(s);
    }

    /**
     * Integer -128~127 不会创建新的对象 直接引用常量池的值
     */
    @Test
    public void demo5() {
        Integer a = 127;
        Integer b = 127;
        /*
        * 这个equals hashcode已被重写*/
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());

        Integer a1 = 257;
        Integer b1 = 257;
        System.out.println(a1.hashCode() == b1.hashCode());
        System.out.println(a1.equals(b1));

        System.out.println(a == b);
        System.out.println(a1 == b1);
    }


    /**
     * 创建对象的几种方式。
     *  关键字new                          使用构造器
     *  Test2 newInstance()                调用构造器
     *  Constructor newInstance()           调用构造器
     *  clone                               不调用构造器
     *  反序列化                            不调用构造器
     */
    @Test
    public void demo6() {
        //new
        Object o = new Object();
        System.out.println(o.hashCode());
        System.out.println("***********************");
        //Class newInstance()
        try {
            demo7("forAjob.Test");
            demo7("forAjob.Test2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {

    }

    private void demo7(String s) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class aClass = Class.forName(s);
        System.out.println(aClass.hashCode());
        Object o1 = aClass.newInstance();
        System.out.println(o1.hashCode());
        //注意o1的hashCode输出是0，调用我的默认参数,o1内存实际的内容是Test,o1竟然没寻错类型，或许吧，就不是根据类型寻的，
        Constructor constructor = aClass.getConstructor();
        Object o2 = constructor.newInstance();
        System.out.println(o2.hashCode());
    }

}
