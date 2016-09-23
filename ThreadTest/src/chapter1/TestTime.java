package chapter1;

import java.util.Date;

class Thread2 extends Thread{

	private String name;
	
	public Thread2(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println(name+" is runing.......");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class TestTime {
	
	public static void main(String[] args) {
		System.out.println(getStartTime());
		System.out.println(getRunTime());
	}
	
	static long getStartTime(){
		Date d1 = new Date();
		long l1 = d1.getTime();
		Thread2 t2 = new Thread2("strat");
		t2.start();
		Date d2 = new Date();
		long l2 = d2.getTime();
		return l2 -l1;
	}
	
	static long getRunTime(){
		Date d1 = new Date();
		long l1 = d1.getTime();
		Thread2 t2 = new Thread2("run");
		t2.run();
		Date d2 = new Date();
		long l2 = d2.getTime();
		return l2 -l1;
	}
}
