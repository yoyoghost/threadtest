package chapter2;

import chapter2.InClass.PrivateClass;

class InClass {
	private String name;
	private String sex;

	static class PrivateClass {
		private String age;
		private String address;

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}

public class InnerClass {
	public static void main(String[] args) {
		InClass ic = new InClass();
		ic.setName("a");
		ic.setSex("b");
		//PrivateClass pc = ic.new PrivateClass();
		PrivateClass pc = new PrivateClass();//static 类型的内部类不需要用外部类.new
		pc.setAddress("da");
		pc.setAge("10");
	}
}
