package com.jdbc.reflection;

public class ConcreteClass extends BaseClass implements BaseInterface {

	public ConcreteClass(int i) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void method1() {
		
	System.out.println("this is method one");
	}

	@Override
	public int method2(String str) {
		System.out.println("this is method two");
		return 2;
	}
	
	@Override
	public int method4(){
		System.out.println("Method4 overriden.");
		return 0;
	}
	
	public int method5(int i){
		System.out.println("this is method 5");
		return 5;
	}
	
	// inner classes
	public class ConcreteClassPublicClass{}
	private class ConcreteClassPrivateClass{}
	protected class ConcreteClassProtectedClass{}
	class ConcreteClassDefaultClass{}
	
	//member enum
	enum ConcreteClassDefaultEnum{}
	public enum ConcreteClassPublicEnum{}
	
	//member interface
	public interface ConcreteClassPublicInterface{}

}
