import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelColor extends JFrame implements ActionListener
{
        Container cont;
        String namestr[]={"Green","Blue","Red","Pink","Gray","Yellow","Cyan","Magenta","black"};
        Color colorstr[]={Color.green,Color.blue,Color.red,Color.pink,Color.gray,Color.yellow,Color.cyan,Color.magenta,Color.black};
        JPanel[] panel=new JPanel[namestr.length];
        JMenuItem[] menuitem=new JMenuItem[namestr.length];
        JPanel jp;
        JPopupMenu jpop;
        PanelColor()
        {
                cont=getContentPane();
                cont.setLayout(new GridLayout(3,3));
                jpop=new JPopupMenu();
                for(int i=0;i<namestr.length;i++)
                {
                panel[i]= new JPanel();
                cont.add(panel[i]);
                panel[i].setBackground(colorstr[i]);
                panel[i].addMouseListener(new mousehandler());
                }
                for(int i=0;i<namestr.length;i++)
                {
                menuitem[i]=new JMenuItem(namestr[i]);
                jpop.add(menuitem[i]);
                menuitem[i].addActionListener(this);
                }
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
class mousehandler extends MouseAdapter
{
     public void mouseReleased(MouseEvent mouseevent)
        {
         if(mouseevent.isPopupTrigger())
          {

jpop.show(mouseevent.getComponent(),mouseevent.getX(),mouseevent.getY());
          }
        }
     public void mousePressed(MouseEvent mouseevent)
        {
            jpop.removeAll();
            Object obj=mouseevent.getSource();
            if(obj instanceof JPanel)
            {
            jp=(JPanel) obj;
            Color c=jp.getBackground();
            for(int i=0;i<namestr.length;i++)
                 {

                     if(!c.equals(colorstr[i]))
                     {
                        jpop.add(menuitem[i]);
                     }
                }
            }
        }
   }
public void actionPerformed(ActionEvent actionevent)
        {
        String s=actionevent.getActionCommand();
        for(int i=0;i<colorstr.length;i++)
        if(s.equals(namestr[i]))
            {
                jp.setBackground(colorstr[i]);
                setTitle(namestr[i]);
            }
        }
public static void main(String args[])
        {
        PanelColor men=new PanelColor();
        men.setSize(400,400);
        men.setTitle("PanelColor");
        men.show();
        }
}