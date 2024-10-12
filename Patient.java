import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import java.io.*;

public class Patient extends Person implements Serializable{        //serialized..means that the obj can be converted into stream of bytes 
                                                    //and later restored into orignal state
    private String illness;

    Patient(){

    }
    Patient(String i,String n,int a,String ill){
        super(i,n,a);
        illness=ill;
    }
    Patient(Patient p){
        super(p.ID,p.name,p.age);
        illness=p.illness;
    }

    public void setIllness(String ill){
        illness=ill;
    }
    public String getIllness(){
        return illness;
    }

    public static void writeToPatient(Patient p){
        try{
            File f=new File("patients.ser");
            ObjectOutputStream oos;
            if(f.exists()){
                oos=new MyObjectOutputStream(new FileOutputStream(f,true));     //prevents writing a new header

            }
            else{
                oos=new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(p);
            oos.close();            //prevent data leakage
        }
        catch(IOException e){
            System.out.println("Error in File Handling");
        }
    }

    public static ArrayList<Patient> readAllPatients(){

        ArrayList<Patient> list=new ArrayList<Patient>();       //by default index=10

        ObjectInputStream ois;
        try{
            ois=new ObjectInputStream(new FileInputStream("patients.ser"));

            while(true){
                Patient p=(Patient)ois.readObject();        //returns obj specifically of type patient otherwise it will return any serialized obj
                list.add(p);
                System.out.println(p.name);             //patient name
            }
        }
        catch(ClassNotFoundException e1){
            System.out.println("ClassNotFoundException");
        }
        catch(EOFException e2){
            return list;
        }
        catch(IOException ex){                  //when a file cant be opened, read or written
            System.out.println("File not found in reader");
        }

        return list;
    }

    public static void deleteAPatient(String name){

        ArrayList<Patient> list=readAllPatients();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().equals(name)){
                System.out.println(list.get(i).getName()+
                    " is deleted successfully from file");
                list.remove(i);
            }
        }
        try{
            ObjectOutputStream obj=new ObjectOutputStream
                (new FileOutputStream("patients.ser"));                 //.ser serialized file() byte stream...deserialized--byte stream back into orignal obj through casting

            for(int i=0;i<list.size();i++){
              obj.writeObject(list.get(i));
            }
        }
        catch(IOException e){
            System.out.println("Error writing in delete function");
        }

    }
    public static void patientIllness(String ill){
        ArrayList<Patient> list=readAllPatients();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getIllness().equals(ill)){
                System.out.println(list.get(i).getIllness()+
                    " patients with same illness");
                list.get(i).display();
            }
        }
    }
    
    public static void updateAPatient(String name,String ill){
        ArrayList<Patient> list=readAllPatients();

        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().equals(name)){
                System.out.println(list.get(i).getName()+
                    " is updated successfully in file");
                list.get(i).setIllness(ill);
            }    
        }

        try{
            ObjectOutputStream obj=new ObjectOutputStream
                (new FileOutputStream("patients.ser"));

            for(int i=0;i<list.size();i++){
                obj.writeObject(list.get(i));
            }
        }

        catch(IOException e){
            System.out.println("Error writing in update function");
        }
    }
    @Override
    public void display(){
        super.display();
        System.out.println("Patient's Illness: "+illness);
    }

    @Override
    public String toString(){
        return super.toString()+"Patinet's Illness: "+illness;
    }
}
