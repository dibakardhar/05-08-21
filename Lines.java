import java.awt.*;
import java.applet.*;
import javax.swing.*;

/*
<applet code="Lines" width=300 Height=250>
</applet>
*/
public class Lines extends JFrame
{        
        public void paint(Graphics g)
        {
                g.drawLine(0,0,100,100);
                g.drawLine(0,100,100,0);
                g.drawLine(40,25,250,180);
                g.drawLine(5,290,80,19);
        }
}
