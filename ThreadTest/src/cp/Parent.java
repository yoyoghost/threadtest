package cp;

public class Parent
{
    String name;
    
    String age;
    
    public Parent()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public Parent(String name, String age)
    {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Parent [name=" + name + ", age=" + age + "]";
    }
    
}
