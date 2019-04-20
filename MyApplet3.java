import java.applet.Applet;
import java.awt.Color;
import java.awt.event.*;
import javafx.scene.control.Button;
public class MyApplet3 extends Applet implements ActionListener {
    Button b;
    public void init(){
    b=new Button("click me");
   add(b);
   b.addActionListener(this);
   
    }
  

    
    public void actionPerformed(ActionEvent e) {
         setBackground(Color.red);
       
 //To change body of generated methods, choose Tools | Templates.
    }
}