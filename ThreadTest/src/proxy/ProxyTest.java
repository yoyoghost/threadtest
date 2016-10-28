package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest
{
    public static void main(String[] args)
    {
        Buy buy = new Buy();
        InvocationHandler dp = new DyProxy(buy);
        Class<? extends AutoBuy> cls = buy.getClass();
        AutoBuy ab = (AutoBuy)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), dp);
        ab.buy(5);
    } 
}
