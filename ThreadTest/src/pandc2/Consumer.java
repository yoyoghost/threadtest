package pandc2;

public class Consumer {
	private String lock;

	public Consumer(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue(){
		System.out.println("consumer enter");
		try {
			synchronized (lock) {
				if("".equals(ValueStore.value)) {
					lock.wait();
				}
				System.out.println("consumer has got value :" + ValueStore.value);
				ValueStore.value = "";
				Thread.sleep(1000);
				lock.notify();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
