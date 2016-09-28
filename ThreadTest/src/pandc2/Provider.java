package pandc2;

public class Provider {

	private String lock;

	public Provider(String lock) {
		super();
		this.lock = lock;
	}
	
	public void setValue() {
		System.out.println("provider enter");
		try {
			synchronized (lock) {
				if("".equals(ValueStore.value)) {
					ValueStore.value = "hello-" + Math.random()*10;
					System.out.println("provider has set value :" + ValueStore.value);
					Thread.sleep(1000);
					lock.notify();
				}
				lock.wait();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
