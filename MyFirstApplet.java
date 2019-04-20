import java.awt.*;
import java.applet.*;
public class MyFirstApplet extends Applet {
  public void init(){
    super.setBackground(Color.yellow);
    super.setForeground(Color.blue);
  }
    public void paint(Graphics g){
        g.drawString("Welcome to Virat kingdom",200,200);
    }
}
