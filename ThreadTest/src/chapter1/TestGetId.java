package chapter1;

class GetIdThread extends Thread{
	private String name;
	
	public GetIdThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(name+" is runing.......");
		System.out.println(this.currentThread().getName()+"----"+this.currentThread().getId());
	}
}

public class TestGetId {
	public static void main(String[] args) {
		
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+"----"+t.getId());
		
		GetIdThread gt2 = new GetIdThread("hello2");
		gt2.run();
		
		GetIdThread gt1 = new GetIdThread("hello1");
		gt1.start();
		
		GetIdThread gt0 = new GetIdThread("hello0");
		gt0.start();
		
	}
}
