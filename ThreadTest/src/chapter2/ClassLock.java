package chapter2;

class TestObject{
	
	synchronized public static void printA(){
		System.out.println("A");
	}
	
	synchronized public static void printB(){
		System.out.println("B");
	}
	
	synchronized public void printC(){
		System.out.println("C");
	}
}

public class ClassLock {

}
