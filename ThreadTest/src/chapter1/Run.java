package chapter1;

public class Run {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		System.out.println("Run");
		//�ᷢ��Run ����  MyThread ֮ǰ��ӡ����
	}
}
