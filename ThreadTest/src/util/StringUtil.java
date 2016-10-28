package util;

public class StringUtil
{
    public static boolean isEmpty(String str){
        if(null==str||"".equals(str.trim())||str.length()==0){
            return true;
        }
        return false;
    }
}
