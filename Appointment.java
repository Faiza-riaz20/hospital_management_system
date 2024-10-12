import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Appointment implements Serializable {
    private String date;
    private Patient patient;
    private Doctor doctor;
    
    Appointment(){
        
    }
    Appointment(String dat,Patient p1,Doctor d1){
        date=dat;
        patient=p1;
        doctor=d1;
    }
    Appointment(Appointment a){
        date=a.date;
        patient=a.patient;
        doctor=a.doctor;
    }
    public void setDate(String d){
        date=d;
    }
    public void setPatient(Patient p){
        patient=p;
    }
    public void setDoctor(Doctor d){
        doctor=d;
    }
    
    public String getDate(){
        return date;
    }
    public Patient getPatient(){
        return patient;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    
    
    public static void writeToAppointment(Appointment a){
        
        try{
            File f=new File("appointments.ser");
            ObjectOutputStream oos;
            if(f.exists()){
                oos=new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos=new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(a);
            oos.close();
        }
        catch(IOException e){
            System.out.println("Error in File Handling");
        }
    }
    
    public static ArrayList<Appointment> readAllAppointments(){
        
        ArrayList<Appointment> list=new ArrayList<Appointment>();
        ObjectInputStream ois;
        try{
                ois=new 
                ObjectInputStream(new FileInputStream("appointments.ser"));
            
            while(true){
                Appointment a=(Appointment)ois.readObject();
                list.add(a);
                System.out.println(a.date+"    "+a.patient.name+"   "+
                    a.doctor.name);
            }
        }
        catch(ClassNotFoundException e1){
            System.out.println("ClassNotFoundException");
        }
        catch(EOFException e2){
            return list;
        }
        catch(IOException e3){
            System.out.println("Error in file reader");
        }
        return list;
    }
    
    public static void deleteAAppointment(String date){
        ArrayList<Appointment> list=readAllAppointments();
        
        for(int i=0;i<list.size();i++){
            if(list.get(i).getDate().equals(date)){
                System.out.println("Appointment with date "+date
                    +" has been deleted successfully");
                list.remove(i);
            }
        }
        
        try{
            ObjectOutputStream oos=new 
                ObjectOutputStream(new FileOutputStream("appointments.ser")); 
            for(int i=0;i<list.size();i++){
                oos.writeObject(list.get(i));
            }
        }
        catch(IOException e){
            System.out.println("Error writing in delete function");
        }
    }
    
    public static void updateAAppointment(String date,Patient p,Doctor d){
        
        ArrayList<Appointment> list=readAllAppointments();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getDate().equals(date)){
                list.get(i).setPatient(p);
                list.get(i).setDoctor(d);
                System.out.println("Doctor & Patient of Appointment of date "
                    +date+" has been updated successfully");
            }
        }
        try{
            ObjectOutputStream obj=new 
                ObjectOutputStream(new FileOutputStream("appointments.ser")); 
            for(int i=0;i<list.size();i++){
                obj.writeObject(list.get(i));
            }
        }
        catch(IOException e){
            System.out.println("Error writing in update function");
        }
    }
    
    public void display(){
        System.out.println("Date: "+date);
        patient.display();
        doctor.display();
    }
    
    public String toString(){
        return "Date: "+date+" Patient's info: "
            +patient.toString()+
            "   Doctor's info: "+doctor.toString();
    }
    public static void updateAAppointment(String string, String string2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAAppointment'");
    }
}