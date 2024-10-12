import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeletePatient extends JFrame{
    
    JButton b1,b2;
    JLabel l1;
    JTextField t1;
public DeletePatient(){
    setSize(400,400);
    setLayout(new GridLayout(5,2));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
//setLayout(new GridLayout(5,2));
l1=new JLabel("name");
t1=new JTextField(20);

b1=new JButton("home");
b2=new JButton("delete patient");
add(l1);
add(t1);
add(b1);
add(b2);
DeletePatientListener a=new DeletePatientListener();
b1.addActionListener(a);
b2.addActionListener(a);
}
 
public class DeletePatientListener implements ActionListener{

public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("delete patient")){

    String n=t1.getText();
    
  Patient.deleteAPatient(n);
    JOptionPane.showMessageDialog(null,"patient deleted successfully");
    }
   else if(ae.getActionCommand().equals("home")){
        GUImenu sg=new GUImenu();
    }
}
}
}

