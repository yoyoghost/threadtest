import java.text.SimpleDateFormat;
import java.util.Date;


public class TestDate
{
    public static void main(String[] args) throws Exception
    {
        
        Date d = new Date();
        System.out.println(d);
        
        //将扩展信息中的字符串类型的时间转换为Date
        SimpleDateFormat spDaFor = new SimpleDateFormat("yyyyMMddhhmmss");
        Date startTime = null;
        //startTime = spDaFor.parse("2016-04-12 09:58:20");
        startTime = spDaFor.parse("20140626203823");
        Long s = startTime.getTime();
        Long e = new Date().getTime();
        Long j = (e-s)/1000/60/60;
        System.out.println(j);
        System.out.println(startTime);
    }
}
