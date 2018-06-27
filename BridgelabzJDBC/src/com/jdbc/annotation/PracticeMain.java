package com.jdbc.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

@interface MyAnnotation {
    public String name();
    public String value();
}


@MyAnnotation(name="someName",  value = "Hello World")
class TheClass {
}

public class PracticeMain {

	public static void main(String[] args) {
		Class aClass = TheClass.class;
		Annotation[] annotations = aClass.getAnnotations();

		for(Annotation annotation : annotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		        System.out.println(myAnnotation.getClass());
		    }
		}
		
		
	}

}
