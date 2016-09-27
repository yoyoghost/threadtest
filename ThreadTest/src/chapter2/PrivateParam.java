package chapter2;

public class PrivateParam {
	private int num;

	public void addNum(String param) {
		try {
			if ("a".equals(param)) {
				System.out.println("a is running");
				num = 1000;
				Thread.sleep(2000);
			} else {
				System.out.println("b is running");
				num = 2000;
			}
			System.out.println("param = "+param +",num = "+num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
