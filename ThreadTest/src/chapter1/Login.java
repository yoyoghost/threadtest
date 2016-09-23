package chapter1;

public class Login {
	private static String usernameRef;
	private static String passwordRef;
	synchronized public static void doPost(String userName, String password) {
		try {
			usernameRef = userName;
			if ("a".equals(userName)) {
				Thread.sleep(5000);
			}
			
			passwordRef = password;
			System.out.println("username ="+usernameRef+",password ="+passwordRef);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
