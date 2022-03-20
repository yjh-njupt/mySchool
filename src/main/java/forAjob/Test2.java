package forAjob;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * 重写Class newInstance方法
 * */
public final class Test2<T> implements java.io.Serializable,
        GenericDeclaration,
        Type,
        AnnotatedElement {


    private volatile transient Constructor<T>  cachedConstructor;
    private volatile transient Class<T> newInstanceCallerCache;

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
