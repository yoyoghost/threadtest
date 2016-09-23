package chapter1;

class SleepThread extends Thread{
	
	private String name;
	
	public SleepThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(name+" is running.....");
	}
}

public class TestSleep {
	//和 TestTime 测试过程相同
}
