import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {                       //all methods shud be overridden in interface
                public void actionPerformed(ActionEvent ae){
                    if(ae.getActionCommand().equals("write to patient")){
                        AddPatient a =new AddPatient();
                    }
                   
                    //Patient.readAllPatients();
                    // else if(ae.getActionCommand().equals("write to doctor")){
                    //     Doctor.writeToDoctor(d2);
                    //     AddDoctor a =new AddDoctor();

                    // }
                    // else if(ae.getActionCommand().equals("write to appointment")){
                    //     AddAppointment a =new AddAppointment();

                    // }
                    // else if(ae.getActionCommand().equals("today's appointment")){
                    //     ArrayList<Appointment> list = Appointment.readAllAppointments();
                    //     boolean flag=true;
                    //     for(int i=0;i<list.size();i++){
                    //         if(list.get(i).getDate().equals("18-5-2024")){
                    //             list.get(i).display();
                    //             flag=false;

                    //         }
                    //     }
                    //         if (flag){
                    //             System.out.println("no appitnments fot today..");
                    //     }
                    // }   else if(ae.getActionCommand().equals("update appointment")){
                    //         Appointment.updateAAppointment("12-3-2023", "13-12-2023");
                    //         Appointment.updateAAppointment("15-3-2024", "16-12-2024");

                    // }
                        }
                }   
            
        
    
                