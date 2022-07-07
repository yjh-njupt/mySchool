package annotation.reflect;

import annotation.Activity;
import annotation.InjectView;

import java.lang.reflect.Field;
public class InjectUtils {
    private static void injectView(Activity activity) throws IllegalAccessException {
        Class<? extends Activity> aClass = activity.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        //类型：int,变量名：id,是否被注释@InjectView修饰：true,
        //类型：class java.lang.String,变量名：name,是否被注释@InjectView修饰：true,
        for (Field field:
             declaredFields) {
            StringBuffer sbf = new StringBuffer();
            sbf.append("类型：");
            sbf.append(field.getType());
            sbf.append(",");
            sbf.append("变量名：");
            sbf.append(field.getName());
            sbf.append(",");
            sbf.append("是否" +
                    "被注释@InjectView修饰：");
            sbf.append(field.isAnnotationPresent(InjectView.class));
            sbf.append(",");
            System.out.println(sbf.toString());

            if (field.isAnnotationPresent(InjectView.class)) {
                InjectView injectView = field.getAnnotation(InjectView.class);
                int value = injectView.value();
                System.out.println(value);
            }

        }
    }

    public static void main(String[] args)  throws IllegalAccessException{
        injectView(new Activity());
    }
}
