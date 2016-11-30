package cp;

public class Child extends Parent
{
    
    String gender;
    
    public Child()
    {
        super();
    }
    
    public Child(String name, String age, String gender)
    {
        super(name, age);
        this.gender = gender;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
}
