package chapter1;

public class LoginTestB extends Thread{
	@Override
	public void run() {
		System.out.println("LoginTestB  start....");
		Login.doPost("b", "bbb");
	}
}