package DesignMode;

import org.apache.commons.logging.Log;
import org.junit.Test;

public class DesignMode {
    public static void main(String[] args) {
        // 第一天 单例模式 简单工厂模式
        //

    }
}

// 单例模式
// 预加载 懒加载
// 破坏单例模式的方式：克隆，序列化
class A{
    private static volatile A a;
    private A(){

    }
       // 双重锁校验
    public static A getA() {
        if (a == null) {
        synchronized (A.class) {
            if (a == null) {
                a = new A();
            }
        }}
        return a;
    }
}

//简单工厂/静态工厂  simple static method
// 三个角色 factory product concreteProduct
// concreteProduct  抽象产品，面向调用者
interface Login {
    public boolean vertify(String name, String passwd);
}
// 具体product,由工行进行选择
class DemainLogin implements Login{

    @Override
    public boolean vertify(String name, String passwd) {
        /*
         *业务逻辑
         */
        return false;
    }
}
// 具体产品，由工厂负责逻辑进行选择
class PasswdLogin implements Login{

    @Override
    public boolean vertify(String name, String passwd) {
        /*
        * 业务逻辑
        * */
        return false;
    }
}
// product 工厂有静态方法
class LoginManager{
    public static Login factory(String type){
        if (type.equals("passwd")) {
            return new PasswdLogin();
        } else if (type.equals("passcode")) {
            return new DemainLogin();
        }else {
            throw new RuntimeException("运行异常");
        }
    }
}

//简单工厂的时序图
// 1.先调用工厂的静态方法 2.传入产品参数，获取具体产品 3.返回产品的抽象对象
// 具体例子 java.test.DateFormat  getDateInstance()及其重载方法。

/** https://www.jianshu.com/p/ec1731231399  第三天待续 */