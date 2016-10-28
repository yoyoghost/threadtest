package ProxyTest;

import util.StringUtil;

public class PhoneProxy extends Phone
{
    
    private Phone phone;
    
    public PhoneProxy(Phone phone)
    {
        super();
        this.phone = phone;
    }
    
    public PhoneProxy()
    {
        super();
    }

    public boolean validateName(String name){
        if(StringUtil.isEmpty(name)){
            System.out.println("the name is empty!!!");
            return false;
        }
        return true;
    }
    
    public void callSuccess(String name){
        System.out.println("call "+name+" success!!!");
    }
    
    public void callFail(String name){
        System.out.println("call "+name+" fail!!!");
    }
    
    @Override
    public void call(String name)
    {
        if(validateName(name)){
            phone.call(name);
            callSuccess(name);
        }else{
            callFail(name);
        }
    }
}
