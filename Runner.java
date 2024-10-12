
public class Runner {

    public static void main(String[] args) {
        
        System.out.println("**********");
        Patient p1=new Patient("a1","Ali",18,"Hepatitis");
        Patient p2=new Patient("a2","Ahmed",20,"Diabetes");
        
        Patient.writeToPatient(p1);
        Patient.writeToPatient(p2);
        
        Patient.readAllPatients();
        
        Patient.deleteAPatient("Ali");
        Patient.updateAPatient("Ahmed", "AIDS");
        Patient.readAllPatients();
        
        System.out.println("**********");
        Doctor d1=new Doctor("b1","sohail tata",40,"Neurologist");
        Doctor d2=new Doctor("b2","farukh kodja",35,"Cardiologist");
        
        Doctor.writeToDoctor(d1);
        Doctor.writeToDoctor(d2);
        
        Doctor.readAllDoctors();
        
        Doctor.DeleteADoctor("sohail tata");
        Doctor.updateADoctor("farukh kodja","ENT");
        Doctor.readAllDoctors();
        
        
        System.out.println("**********");
        Appointment a1=new Appointment("12-12-2023",p1,d1);
        Appointment a2=new Appointment("3-9-2024",p2,d2);
        
        Appointment.writeToAppointment(a1);
        Appointment.writeToAppointment(a2);
        
        Appointment.readAllAppointments();
        
        Appointment.deleteAAppointment("12-12-2023");
        Appointment.updateAAppointment("3-9-2024", p1, d1);
        Appointment.readAllAppointments();
    }   
}
