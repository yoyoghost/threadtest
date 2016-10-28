public class TestFinal
{
    final Integer a;
    
    public TestFinal(Integer a)
    {
        super();
        this.a = a;
    }
    
    public static void main(String[] args)
    {
        Integer s = new Integer(1);
        TestFinal tf = new TestFinal(s);
        System.out.println(tf.a);
        s = new Integer(3);
        Integer s1 = new Integer(5);
        TestFinal tf1 = new TestFinal(s1);
        tf = tf1;
        System.out.println(tf.a);
    }
}
