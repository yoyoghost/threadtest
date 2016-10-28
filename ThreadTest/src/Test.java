
public class Test
{
    public static void main(String[] args)
    {
        //System.out.println(TestEnum.valueOf("/").calculate(4, 2));
        //System.out.println(TestEnum.valueOf(TestEnum.class, "/").calculate(4, 2));
        TestEnum te = Enum.valueOf(TestEnum.class, "DIVIDE");
        int r = te.calculate(4, 2);
        System.out.println(r);
    }
}
