package chapter1;

public class LoginTestA extends Thread{
	@Override
	public void run() {
		System.out.println("LoginTestA  start....");
		Login.doPost("a", "aaa");
	}
}
