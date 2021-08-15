import java.awt.*;
import java.applet.*;
/*
<applet code="Rectanlge" width=300 Height=300>
</applet>
*/
public class Rectanlge extends Applet
{        
        public void paint(Graphics g)
        {
                g.drawRect(10,10,60,50);
                g.fillRect(100,100,100,0);
                g.drawRoundRect(190,10,60,50,15,15);
                g.fillRoundRect(70,90,140,100,30,40);
        }
}
