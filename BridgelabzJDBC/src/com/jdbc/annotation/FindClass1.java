package com.jdbc.annotation;



@Findable(name="JAYANTA")
class FindClass1 implements AnnotatedClass {

}

class FindClass2 implements AnnotatedClass{
	
}

class AnnotatedClassProcsor {
static AnnotatedClass ac;
public void processClass() {
	        System.out.println("------Class Processing Begin---------");	
	        if (ac.getClass().isAnnotationPresent(Findable.class)) {
	        	System.out.println("Class: " + ac.getClass().getName());
	        }
	 }
}

