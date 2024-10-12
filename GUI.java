import javax.swing.*;
import java.awt.*;
// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;
class SimpleGUI extends JFrame{

    JButton button1;
    SimpleGUI(){
        setSize(400,400);
        setLayout(new GridLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        button1=new JButton("click me");
        MyActionListener a1=new MyActionListener();
        button1.addActionListener(a1);                      //registering og buttons wd actions
        add(button1);           
       
    }
}
