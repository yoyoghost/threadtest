package pandc2;

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
		
		ProviderThread pt = new ProviderThread(p);
		ConsumerThread ct = new ConsumerThread(c);
		
		ct.start();
		pt.start();
	}
}
