
    import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class updatePatient extends JFrame{
    
    JButton b1,b2;
    JLabel l1;
    JLabel l2;
    JTextField t1;
    JTextField t2;
public updatePatient(){
    setSize(400,400);
    setLayout(new GridLayout(5,2));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
//setLayout(new GridLayout(5,2));
l1=new JLabel("name");
t1=new JTextField(20);
l2=new JLabel("illness");
t2=new JTextField(20);

b1=new JButton("home");
b2=new JButton("update patient");
add(l1);
add(t1);
add(l2);
add(t2);
add(b1);
add(b2);
updatePatientListener a=new updatePatientListener();
b1.addActionListener(a);
b2.addActionListener(a);
}
 
public class updatePatientListener implements ActionListener{

public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("update patient")){

    String n=t1.getText();
    String ill=t2.getText();
    
  Patient.updateAPatient(n,ill);
    JOptionPane.showMessageDialog(null,"patient updated successfully");
    }
   else if(ae.getActionCommand().equals("home")){
        GUImenu sg=new GUImenu();
    }
}
}
}
