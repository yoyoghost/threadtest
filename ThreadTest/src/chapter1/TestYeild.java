package chapter1;

class YeildThread extends Thread{

	@Override
	public void run() {
		
		long time1 = System.currentTimeMillis();
		System.out.println("start :"+time1);
		
		for (int i = 0; i < 100000; i++) {
			Thread.yield();
			Math.random();
		}
		long time2 = System.currentTimeMillis();
		System.out.println("end :"+time2);
		System.out.println("cost time :"+(time2-time1));
	}
}

public class TestYeild{
	
	public static void main(String[] args) {
		YeildThread yt = new YeildThread();
		yt.start();
	}
	
}
