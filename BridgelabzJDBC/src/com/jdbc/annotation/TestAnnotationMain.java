package com.jdbc.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

//@Target(ElementType.TYPE)
//@interface Info {
//	Author[] author();
//	double version() default 1.0;
//}
//
//@interface Author {
//	String fn();
//	String ln() default "";
//}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Timestamp {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface PostConstruct {
}

class ObjectFactory {
    public static Object create(Class myClass) throws Exception {
        Object object = myClass.newInstance();
        Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Timestamp) {
                    Date now = new Date();
                    boolean accessible = field.isAccessible();
                    field.setAccessible(true);
                    field.set(object, now);
                    field.setAccessible(accessible);
                }
            }
        }
        // find all methods which is annotated with @PostConstruct
        // and invoke them.
        Method[] methods = myClass.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if(annotation instanceof PostConstruct){
                    method.invoke(object, (Object[])null);
                }
            }
        }
        return object;
    }
}


class Foo {
    @Timestamp
    Date creationTime;
    @PostConstruct
    public void init(){
        System.out.println("Init method called");
    }
}
public class TestAnnotationMain {
	public static void main(String[] args) throws Exception {
		Foo foo = (Foo) ObjectFactory.create(Foo.class);
		System.out.println(foo.creationTime);
	}
}
