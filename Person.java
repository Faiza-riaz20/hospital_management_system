
    import java.io.Serializable;
public class Person implements Serializable {
    protected String ID;
    protected String name;
    protected int age;
    
    Person(){
        
    }
    Person(String i,String n,int a){
        ID=i;
        name=n;
        age=a;
    }
    Person(Person p){
        ID=p.ID;
        name=p.name;
        age=p.age;
    }
    public void setID(String i){
        ID=i;
    }
    public void setName(String n){
        name=n;
    }
    public void setAge(int a){
        age=a;
    }
    
    public String getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    
    public void display(){
        System.out.println("Person's ID: "+ID+
            "\nPerson's Name: "+name+"\nPerson's Age: "+age);   
    }

    public String toString(){
        return "Person's ID: "+ID+" Person's Name: "+name
                +"  Person's Age: "+age;
    }
}


