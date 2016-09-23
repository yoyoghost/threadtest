package chapter1;

class AliveThread extends Thread{

	private String name;
	
	public AliveThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(name+" is runing.......");
		System.out.println(name+"'s status is "+ this.currentThread().getName());
		System.out.println(name+"'s status is "+ this.isAlive());
	}
	
}

public class TestIsAlive {

	public static void main(String[] args) {
		AliveThread at = new AliveThread("hello");
		System.out.println(at.isAlive());
		at.start();
		System.out.println(at.isAlive());
	}
	
}
