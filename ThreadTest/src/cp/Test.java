package cp;

import java.util.ArrayList;
import java.util.List;

public class Test
{
    public static void main(String[] args)
    {
        long beforeMemory=Runtime.getRuntime().totalMemory();
        Child c = null;
        List<Child> l = new ArrayList<Child>();
        for (int i = 0; i < 30000; i++)
        {
            c = new Child("q"+i,"w"+i,"x"+i);
            l.add(c);
        }
        System.out.println(l.size());
        long afterMemory=Runtime.getRuntime().totalMemory();
        System.out.println("Memory used:"+(beforeMemory-afterMemory));
    }
}
