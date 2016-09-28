package pandc1;

public class Consumer {
	private String lock;

	public Consumer(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue(){
		System.out.println("consumer " + Thread.currentThread().getName() + " enter");
		try {
			synchronized (lock) {
				while("".equals(ValueStore.value)) {
					System.out.println("consumer " + Thread.currentThread().getName() + " is waiting");
					lock.wait();
				}
				System.out.println("consumer " + Thread.currentThread().getName() + " has got value :" + ValueStore.value);
				ValueStore.value = "";
				Thread.sleep(1000);
				lock.notifyAll();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
