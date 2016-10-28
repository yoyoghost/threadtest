package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DyProxy implements InvocationHandler
{
    private Object obj;
    
    public DyProxy()
    {
        super();
    }
    
    public DyProxy(Object obj)
    {
        this.obj = obj;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable
    {
        System.out.println( " before buying "  + method);
        //System.out.println( "proxy:"+proxy.toString());
        method.invoke(obj,args);
        System.out.println( " after buying "  + method);
        return  null ;
    }
    
}
