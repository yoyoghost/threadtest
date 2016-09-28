package pandc1;

public class Provider {

	private String lock;

	public Provider(String lock) {
		super();
		this.lock = lock;
	}
	
	public void setValue() {
		System.out.println("provider " + Thread.currentThread().getName() + " enter");
		try {
			synchronized (lock) {
				while("".equals(ValueStore.value)) {
					ValueStore.value = "hello-" + Math.random()*10;
					System.out.println("provider " + Thread.currentThread().getName() + " has set value :" + ValueStore.value);
					Thread.sleep(1000);
					lock.notifyAll();
				}
				System.out.println("provider " + Thread.currentThread().getName() + " is waiting");
				lock.wait();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
