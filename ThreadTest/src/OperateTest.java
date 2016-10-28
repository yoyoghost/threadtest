
public class OperateTest
{
    public static void main(String[] args)
    {
        int a = 0;
        int b = 1;
        a = ++a+b++;
        //a = a+++b++;
        //a = (++a)+(++b);
        //a = (a++)+(b++);
        System.out.println(a);
    }
}
