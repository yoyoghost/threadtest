package ProxyTest;

public class ProxyTest
{
    public static void main(String[] args)
    {
        Phone xiaomi = new XiaoMi();
        Phone phoneProxy = new PhoneProxy(xiaomi);
        phoneProxy.call("");
        System.out.println();
        phoneProxy.call("13520775687");
    }
}
