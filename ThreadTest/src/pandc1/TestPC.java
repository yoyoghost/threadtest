package pandc1;

class ProviderThread extends Thread{
	private Provider provider;

	public ProviderThread(Provider provider) {
		super();
		this.provider = provider;
	}

	@Override
	public void run() {
		while(true) {
			provider.setValue();
		}
	}
}

class ConsumerThread extends Thread{
	private Consumer c;

	public ConsumerThread(Consumer c) {
		super();
		this.c = c;
	}

	@Override
	public void run() {
		while(true) {
			c.getValue();
		}
	}
}

public class TestPC {
	public static void main(String[] args) throws Exception{
		String lock = new String("lock");
		Provider p = new Provider(lock);
		Consumer c = new Consumer(lock);
		
		ProviderThread[] pt = new ProviderThread[2];
		ConsumerThread[] ct = new ConsumerThread[2];
		
		for(int i = 0 ;i < 2; i++) {
			pt[i] = new ProviderThread(p);
			pt[i].setName("生产者"+(i+1)+"号");
			ct[i] = new ConsumerThread(c);
			ct[i].setName("消费者"+(i+1)+"号");
			pt[i].start();
			ct[i].start();
		}
		
	}
}
