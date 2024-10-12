import javax.swing.*;
import java.awt.*;
class GUImenu extends JFrame{

    JButton writeToPatient;
    JButton writeToDoctor;
    JButton writeToAppointment;
    JButton todaysAppointment;
    JButton updateAppointment;
    
    GUImenu(){
        setSize(400,400);
        setLayout(new GridLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
        //JButton s=new JButton("click me");
        writeToPatient=new JButton("write to patient");
        writeToDoctor=new JButton("write to doctor");
        writeToAppointment=new JButton("write to appointment");
        todaysAppointment=new JButton("today's appointment");
        updateAppointment=new JButton("update appoinment");

        MyActionListener a1=new MyActionListener();                   //registering buttons with events a1(action)
        writeToPatient.addActionListener(a1);
        writeToDoctor.addActionListener(a1);
        writeToAppointment.addActionListener(a1);
        todaysAppointment.addActionListener(a1);
        updateAppointment.addActionListener(a1);

        add(writeToPatient);
        add(writeToDoctor);                                         
        add(writeToAppointment);
        add(todaysAppointment);
        add(updateAppointment);
    }
}
