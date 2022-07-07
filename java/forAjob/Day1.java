package forAjob;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Day1 {
    /**
     * 运算符 & && 使用方式的差别
     * */
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


    /**
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

    /**
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
        /** 先看 Object :
            equals(obj)
        *     return  this==obj
        *   native int hashcode()
        *  再看java.lang.String
        *   equals(obj)
        *
        *   模仿String写了一个Test却无法像使用String一样使用他
        * */

    }

    /**
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
     *  {@link demo7(String s)}
     */
    @Test
    public void demo6() {
        System.out.println("**********new**************");
        //new
        Object o = new Object();
        System.out.println(o.hashCode());

        //Class newInstance()
        System.out.println("**********Class newInstance()*************");
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

        // clone()
        System.out.println("*********clone()**************");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hashCode", map.hashCode());
        System.out.println("source==="+map.get("hashCode"));
        Map<String,Object> clone = (HashMap<String, Object>)(((HashMap<String, Object>) map).clone());
        System.out.println("clone===" + clone.get("hashCode"));
        System.out.println("*********constructor()**************");

        //  Constructor.newInstance
        try {
            Constructor<forAjob.Test> constructor = forAjob.Test.class.getConstructor();
            forAjob.Test test = constructor.newInstance();
            System.out.println(test.hashCode());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("**************Serializable************************");
        // JDK序列化 实现Serializable 然后使用流进行操作\
        try {


            demo11();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("D:\\cache\\idea\\mySchool\\src\\main\\java\\forAjob\\33.xlsx done");


    }


    public void demo11() throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\forAjob\\33.xlsx");
        ObjectOutputStream obos = new ObjectOutputStream(fos);
        People people = new People("teacher",5,"white","you");
        System.out.println(people.toString());
        obos.writeObject(people);
        fos.flush();
        fos.close();
        // 参考 demo10（） 这里由于对people static 进行赋值。导致后续People 共享static属性
        FileInputStream fis = new FileInputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\forAjob\\33.xlsx");
        ObjectInputStream ois = new ObjectInputStream(fis);
        People p1 = (People)ois.readObject();
        System.out.println(p1.toString());
        ois.close();

        People p2 = new People();
        System.out.println(p2.toString());

        // NotSerializableException
        /*FileOutputStream outputStream = new FileOutputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\forAjob\\2");
        ObjectOutputStream outputStream1 = new ObjectOutputStream(outputStream);
        People1 people1 = new People1("teacher",5,"white","you");
        System.out.println(people1.toString());
        outputStream1.writeObject(people1);
        outputStream.flush();
        outputStream.close();
        // 参考 demo10（） 这里由于对people static 进行赋值。导致后续People 共享static属性
        FileInputStream fileInputStream = new FileInputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\forAjob\\2");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        People1 people2 = (People1) inputStream.readObject();
        System.out.println(people2.toString());
        inputStream.close();

        People people3 = new People();
        System.out.println(people3.toString());*/
    }

    /**
     *abstract
     */

    public abstract class AbstarctClass{
        AbstarctClass() {

        }

        private void demo() {

        }

        public abstract void demo1();

        //public static abstract void demo2();  abstarct不接受static
        // 见AbstarctClass_B
    }

    /**
     * demo6() 调用
     * @param s
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
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


    /**
     *
     interface
     */
    public interface InnerInterface{

        //private static String str = "";  interface不接受private，package,protected
        /*
        interface不让用构造器
        InnerInterface(){

        }
        */


        public void demo(); // 没有方法体的都是abstract

        //public static void demo1(); 换句话说，static不接受abstract，interface不接受方法体，

    }

    /**
     * 集合
     *  Collection
     *      list
     *          ArrayList
     *          Vector
     *              Stack
     *      Set
     *          HashSet
     *          SortedSet
     *              TreeSet
     *  Map
     *      HashMap
     *      SortedMap
     *          TreeMap
     *      HashTable
     *  Queue
     *      Deque
     *          LinkedList
     *  数组
     */
    public void demo8() {

    }

    /**
     * String StringBuffer StringBuilder 区别
     */
    @Test
    public void demo9() {
        /****** String属性****/
        //private final char value[];
        // private int hash;
        // 线程安全

        /*****StringBuffer abstractStringBuilder  *******/
        // private transient char[] toStringCache;
        // static final long serialVersionUID = 3388685877147921107L;
        // char[] value;
        // int count;
        // 线程安全
        // 不生成新对象

        /*******StringBuilder   abstractStringBuilder********/
        // static final long serialVersionUID = 4383685877147921099L;
        // char[] value;
        // int count;
        // 线程不安全
        // 性能略高一点，每次指向新的String
    }

    /**
     *  结合demo6() 启动两个不同的虚拟机。操作同一个序列化文件。*/
    @Test
    public void demo10() {
        try {
            FileInputStream fis3 = new FileInputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\forAjob\\33.xlsx");
            ObjectInputStream ois3 = new ObjectInputStream(fis3);
            People p3 = (People)ois3.readObject();
            System.out.println(p3.toString());
            ois3.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Ojbect 对象的方法
     * <code>private static native void registerNatives();</code>
     * <code>private final native Class<T> getClass();</code>
     * <code>public native int hashCode()</>
     * <code>public boolean equals(Object obj)</>
     * <code>protected native Object clone() </>
     * <code>public String toString()</>
     * <code>public final native void notify();</>
     * <code>public final native void notifyAll();</code>
     * <code>public final native void wait(long timeout)</code>
     * <code>public final void wait(long timeout, int nanos)</code>
     * <code>public final void wait()</code>
     * <code>protected void finalize()</code>
     * @param args
     */
    public static void main(String[] args) {


    }





}
