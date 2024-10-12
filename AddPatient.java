import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddPatient extends JFrame{
    
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
public AddPatient(){
   setSize(400,400);
    setLayout(new GridLayout(5,2));
    setDefaultCloseOperation(EXIT_ON_CLOSE);                
    setVisible(true);

l1=new JLabel("name");
t1=new JTextField(20);              //20..>it can take max 20 characters(columns)
l2=new JLabel("ID");
t2=new JTextField(20);
l3=new JLabel("age");
t3=new JTextField(20);
l4=new JLabel("illness");
t4=new JTextField(20);

b1=new JButton("home");
b2=new JButton("add patient");
b3=new JButton("search patient");
add(b1);
add(b2);        
add(b3);
add(l1);                        
add(t1);                             //t-input box
add(l2);                             //class of swing library. which allow use to enter single line text
add(t2);
add(l3);
add(t3);
add(l4);
add(t4);

AddPatientListener a=new AddPatientListener();
b1.addActionListener(a);                        //action perfomed--new class of action listenr
b2.addActionListener(a);                        //reisteration of buttons with events
b3.addActionListener(a);
}
 
public class AddPatientListener implements ActionListener{

public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("add patient")){

    String n=t1.getText();
    String ID=t2.getText();
    int a=Integer.parseInt(t3.getText());
    String ill=t4.getText();
    
    Patient p=new Patient(ID,n,a,ill);
    Patient.writeToPatient(p);
    JOptionPane.showMessageDialog(null,"patient added successfully");       //class of swing library..static method(joptionppane)
    }                                                 //to open dialog box...null > to show in middle..if frame..then it will show in middle of frame 
   else if(ae.getActionCommand().equals("home")){
        GUImenu sg=new GUImenu();
    }

    else if(ae.getActionCommand().equals("search patient")){       
            JFrame newly=new JFrame("Search");
            newly.setSize(400,400);
            newly.setDefaultCloseOperation(EXIT_ON_CLOSE);
            newly.setVisible(true);
            newly.setLayout(new GridLayout(5,0));

            JLabel l1=new JLabel("Patient's Illness");
            JTextField t1=new JTextField(20);
            JButton b1=new JButton("Search");

            newly.add(l1);
            newly.add(t1);
            newly.add(b1);

            b1.addActionListener(new ActionListener(){              //anonymous class
                                                        //used to instantiate objects without making a new class

                @Override
                public void actionPerformed(ActionEvent ae){
                    String ill=t1.getText();
                    
                    ArrayList<Patient> list=Patient.readAllPatients();
                    StringBuilder top=new StringBuilder();          //for making the string mutable..for appending the strings
                    if(list.isEmpty())
                    top.append("No Patients availible to search");                                                                                  
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).getIllness().equalsIgnoreCase(ill)){
                            top.append(list.get(i)).append("\n");
                        }
                    }
                    if(top.isEmpty())
                    top.append("No Patients for this particular illness");
                    
                    JOptionPane.showMessageDialog(newly,top.toString());

                    JFrame faiza=new JFrame ("Searched result");
                    faiza.setSize(400,400);
                    JTextArea t=new JTextArea(top.toString());
                    //t.setEditable(false);
                   
                    faiza.add(new JScrollPane(t));
                    faiza.setVisible(true);

                }
            });
        }
}
}
}
            //to enhance the readability we make another class of action listener and to make it modular