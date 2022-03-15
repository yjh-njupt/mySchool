package forAjob;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * 重写Class newInstance方法
 * */
public final class Test2<T> implements java.io.Serializable,
        GenericDeclaration,
        Type,
        AnnotatedElement {



    public TypeVariable<?>[] getTypeParameters() {
        return new TypeVariable[0];
    }

    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        return null;
    }

    public Annotation[] getAnnotations() {
        return new Annotation[0];
    }

    public Annotation[] getDeclaredAnnotations() {
        return new Annotation[0];
    }
}
