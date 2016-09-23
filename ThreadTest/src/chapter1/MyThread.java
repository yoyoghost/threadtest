package chapter1;

public class MyThread extends Thread{

	//private int count = 10;
	
	
	
	@Override
	public void run() {
		super.run();
		//count--;
		//System.out.println(this.currentThread().getName()+"---count ="+count);
		System.out.println("currentThread().getName()="+this.currentThread().getName()+"----this.getName()="+this.getName());
	}

	public MyThread() {
		System.out.println("currentThread().getName()="+this.currentThread().getName()+"----this.getName()="+this.getName());
	}
	
}
