import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import java.io.Serializable;

public class Doctor extends Person implements Serializable{
    private String specialization;
    
    Doctor(){
        
    }
    Doctor(String i,String n,int a,String s){
        super(i,n,a);
        specialization=s;
    }
    Doctor(Doctor d){
        super(d.ID,d.name,d.age);
        specialization=d.specialization;
    }
    
    public void setSpecialization(String s){
        specialization=s;
    }
    public String getSpecialization(){
        return specialization;
    }
    
    public static void writeToDoctor(Doctor d){
        try{
            File f=new File("doctors.ser");
            ObjectOutputStream oos;
            if(f.exists()){
                oos=new MyObjectOutputStream
                    (new FileOutputStream(f,true));
            }
            else{
                oos=new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(d);
            oos.close();
        }
        catch(IOException e){
            System.out.println("Error in File Handling");
        }
    }
    
    public static ArrayList<Doctor> readAllDoctors(){
        
        ArrayList<Doctor> list=new ArrayList<Doctor>();
        ObjectInputStream ois;
        
        try{
            ois=new ObjectInputStream(new FileInputStream("doctors.ser"));
            while(true){
                Doctor d=(Doctor)ois.readObject();
                list.add(d);
                System.out.println(d.name);
            }
        }
        catch(ClassNotFoundException e1){
            System.out.println("ClassNotFoundException");
        }
        catch(EOFException e2){
            return list;
        }
        catch(IOException e3){
            System.out.println("File not found in reader");
        }
        return list;
    }
    
    public static void DeleteADoctor(String name){
        
        ArrayList<Doctor> list=readAllDoctors();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().equals(name)){
                System.out.println(list.get(i).getName()
                    +" is deleted successfully from file");
                list.remove(i);
            }
        }
        try{
            ObjectOutputStream oos=new ObjectOutputStream
                (new FileOutputStream("doctors.ser"));
            for(int i=0;i<list.size();i++){
                oos.writeObject(list.get(i));
            }
        }
        catch(IOException e){
            System.out.println("Error writing in delete function");
        }
    }
    
    public static void updateADoctor(String name,String special){
        
        ArrayList<Doctor> list=readAllDoctors();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().equals(name)){
                System.out.println(list.get(i).getName()+
                        " is updated successfully in file");
                list.get(i).setSpecialization(special);
            }
        }
        
        try{
            ObjectOutputStream obj=new 
                ObjectOutputStream(new FileOutputStream("doctors.ser")); 
            for(int i=0;i<list.size();i++){
                obj.writeObject(list.get(i));
            }
        }
        catch(IOException e){
            System.out.println("Error writing in update file");
        }
    }
    
    @Override
    public void display(){
        super.display();
        System.out.println("Doctor's Specialization: "+specialization);
    }

    @Override
    public String toString(){
        return super.toString()+
            "   Doctor's Specialization: "+specialization;
    }

}
