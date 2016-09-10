package chapter1;

public class Test {
	public static void main(String[] args) {
		//打印出的是主线程的名字main，和main方法没有关系
		System.out.println(Thread.currentThread().getName());
	}
}
