class ThreadA extends Thread
{
    @Override
    public void run()
    {
        try
        {   
            System.out.println("ThreadA start");
            Thread.sleep(2000);
            System.out.println("ThreadA end");
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread
{
    @Override
    public void run()
    {
        try
        {   
            System.out.println("ThreadB start");
            Thread.sleep(2000);
            System.out.println("Thread end");
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class ThreadC extends Thread
{
    @Override
    public void run()
    {
        try
        {   
            System.out.println("ThreadC start");
            Thread.sleep(2000);
            System.out.println("ThreadC end");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

public class JoinTest
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("main thread start");
        
        ThreadA ta = new ThreadA();
        ta.start();
        ta.join();
        
        ThreadB tb = new ThreadB();
        tb.start();
        tb.join();
        
        ThreadC tc = new ThreadC();
        tc.start();
        tc.join();
        
        System.out.println("main thread end");
    }
}
