package base;

import java.lang.ref.SoftReference;

public class Refer
{
    public static void main(String[] args)
    {
        String a = "ccc";
        SoftReference<String> str = new SoftReference<String>(a);
    }
}
