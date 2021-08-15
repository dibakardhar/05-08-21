import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
//<applet code=Calculator height=300 width=200></applet>
public class //Server.java
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Server extends JFrame
{
 JTextField txtenter;
 JTextArea txtadisplay;
 ObjectOutputStream output;
 ObjectInputStream input;
 public Server()
 {
  super("SERVER");
  Container c=getContentPane();

  txtenter=new JTextField();
  txtenter.setEnabled(false);
  txtenter.addActionListener(
  new ActionListener(){
   public void actionPerformed(ActionEvent e)
   {
     sendData(e.getActionCommand());
   }
  }
  );
  c.add(txtenter,BorderLayout.SOUTH);

  txtadisplay=new JTextArea();
  txtadisplay.setEditable(false);
  c.add(new JScrollPane(txtadisplay),BorderLayout.CENTER);

  setSize(300,150);
  show();
 }
 public void runServer()
 {
  ServerSocket ss;
  Socket s;
  int counter = 1;

  try
  {
    //create a seversocket
   ss=new ServerSocket(5000,100);

   while(true)
   {

     //wait for the connection
    txtadisplay.setText("Waiting for the Connection...");

     //establishing connection
    s=ss.accept();
    txtadisplay.append("
Conection "+counter+"received
from:"+s.getInetAddress().getHostName());

     //getting input/output
    output=new ObjectOutputStream(s.getOutputStream());
    output.flush();

    input=new ObjectInputStream(s.getInputStream());

     //processing connection
    String message="Server>>>Conection Sucessfull...";
    output.writeObject(message);
    output.flush();
    txtenter.setEnabled(true);

    do
    {
     message=(String) input.readObject();
     txtadisplay.append("
"+message);
     txtadisplay.setCaretPosition(txtadisplay.getText().length());
    }while(!message.equals("CLIENT>>>TERMINATE"));

    txtadisplay.append("
User Terminated Connection...");
    output.close();
    input.close();
    s.close();
    ++counter;
   }
  }
  catch(Exception e)
  {

  }
 }
 public void sendData(String s)
 {
  try
  {
   output.writeObject("SERVER>>>"+s);
   txtadisplay.append("
SERVER>>>"+s);
  }
  catch(Exception e)
  {

  }
 }
 public static void main(String args[])
 {
  Server ser=new Server();

  ser.addWindowListener(
  new WindowAdapter(){
  public void WindowClosing(WindowEvent e)
  {
   System.exit(0);
  }
  }
  );
  ser.runServer();
 }

}


//Client.java
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Client extends JFrame
{
 JTextField txtenter;
 JTextArea txtadisplay;
 ObjectOutputStream output;
 ObjectInputStream input;
 String message="";

 public Client()
 {
  super("CLIENT");
  Container c=getContentPane();

  txtenter=new JTextField();
  txtenter.setEnabled(false);
  txtenter.addActionListener(
  new ActionListener(){
  public void actionPerformed(ActionEvent e)
  {
   sendData(e.getActionCommand());
  }
  });
  c.add(txtenter,BorderLayout.SOUTH);

  txtadisplay=new JTextArea();
  txtadisplay.setEditable(false);
  c.add(new JScrollPane(txtadisplay),BorderLayout.CENTER);

  setSize(300,150);
  show();
 }
 public void runClient()
 {
  Socket s;
  try
  {
    txtadisplay.setText("Attempting Connection...");

     //establishing connection
    s=new Socket("localhost",5000);
    txtadisplay.append("
Connected
to:"+s.getInetAddress().getHostName());

    output=new ObjectOutputStream(s.getOutputStream());
    output.flush();
    input=new ObjectInputStream(s.getInputStream());

    txtenter.setEnabled(true);

     //processing connection
    do
    {
     message=(String)input.readObject();
     txtadisplay.append("
"+message);
     txtadisplay.setCaretPosition(txtadisplay.getText().length());
    }while(!message.equals("SERVER>>>TERMINATE"));
    txtadisplay.append("
Closing Connection...");
    input.close();
    output.close();
    s.close();
 }
 catch(Exception e)
 {}
 }
 public void sendData(String s)
 {
  try
   {
    message=s;
    output.writeObject("CLIENT>>>"+s);
    output.flush();

    txtadisplay.append("
CLIENT>>>"+s);
   }
  catch(Exception e)
  {

  }
 }
 public static void main(String args[])
 {
  Client cli=new Client();

  cli.addWindowListener(
  new WindowAdapter(){
  public void windowClosing(WindowEvent e)
  {
   System.exit(0);
  }
  }
  );
  cli.runClient();

 }
}
 extends JApplet {
   public void init() {
      CalculatorPanel calc=new CalculatorPanel();
      getContentPane().add(calc);
      }
   }

   class CalculatorPanel extends JPanel implements ActionListener {
      JButton 
n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,plus,minus,mul,div,dot,equal;
      static JTextField result=new JTextField("0",45);
      static String lastCommand=null;
      JOptionPane p=new JOptionPane();
      double preRes=0,secVal=0,res;

      private static void assign(String no)
        {
         if((result.getText()).equals("0"))
            result.setText(no);
          else if(lastCommand=="=")
           {
            result.setText(no);
            lastCommand=null;
           }
          else
            result.setText(result.getText()+no);
         }

      public CalculatorPanel() {
         setLayout(new BorderLayout());
         result.setEditable(false);
         result.setSize(300,200);
         add(result,BorderLayout.NORTH);
         JPanel panel=new JPanel();
         panel.setLayout(new GridLayout(4,4));

         n7=new JButton("7");
         panel.add(n7);
         n7.addActionListener(this);
         n8=new JButton("8");
         panel.add(n8);
         n8.addActionListener(this);
         n9=new JButton("9");
         panel.add(n9);
         n9.addActionListener(this);
         div=new JButton("/");
         panel.add(div);
         div.addActionListener(this);

         n4=new JButton("4");
         panel.add(n4);
         n4.addActionListener(this);
         n5=new JButton("5");
         panel.add(n5);
         n5.addActionListener(this);
         n6=new JButton("6");
         panel.add(n6);
         n6.addActionListener(this);
         mul=new JButton("*");
         panel.add(mul);
         mul.addActionListener(this);

         n1=new JButton("1");
         panel.add(n1);
         n1.addActionListener(this);
         n2=new JButton("2");
         panel.add(n2);
         n2.addActionListener(this);
         n3=new JButton("3");
         panel.add(n3);
         n3.addActionListener(this);
         minus=new JButton("-");
         panel.add(minus);
         minus.addActionListener(this);

         dot=new JButton(".");
         panel.add(dot);
         dot.addActionListener(this);
         n0=new JButton("0");
         panel.add(n0);
         n0.addActionListener(this);
         equal=new JButton("=");
         panel.add(equal);
         equal.addActionListener(this);
         plus=new JButton("+");
         panel.add(plus);
         plus.addActionListener(this);
         add(panel,BorderLayout.CENTER);
      }
      public void actionPerformed(ActionEvent ae)
         {
      if(ae.getSource()==n1) assign("1");
      else if(ae.getSource()==n2) assign("2");
      else if(ae.getSource()==n3) assign("3");
      else if(ae.getSource()==n4) assign("4");
      else if(ae.getSource()==n5) assign("5");
      else if(ae.getSource()==n6) assign("6");
      else if(ae.getSource()==n7) assign("7");
      else if(ae.getSource()==n8) assign("8");
      else if(ae.getSource()==n9) assign("9");
      else if(ae.getSource()==n0) assign("0");
      else if(ae.getSource()==dot)
            {
             if(((result.getText()).indexOf("."))==-1)
                result.setText(result.getText()+".");
           }
      else if(ae.getSource()==minus)
             {
             preRes=Double.parseDouble(result.getText());
             lastCommand="-";
             result.setText("0");
             }
      else if(ae.getSource()==div)
             {
             preRes=Double.parseDouble(result.getText());
             lastCommand="/";
             result.setText("0");
             }
      else if(ae.getSource()==equal)
             {
             secVal=Double.parseDouble(result.getText());
             if(lastCommand.equals("/"))
                  res=preRes/secVal;
             else if(lastCommand.equals("*"))
                  res=preRes*secVal;
             else if(lastCommand.equals("-"))
                  res=preRes-secVal;
             else if(lastCommand.equals("+"))
                  res=preRes+secVal;
             result.setText(" "+res);
             lastCommand="=";
             }
      else if(ae.getSource()==mul)
             {
              preRes=Double.parseDouble(result.getText());
              lastCommand="*";
              result.setText("0");
              }
      else if(ae.getSource()==plus)
              {
              preRes=Double.parseDouble(result.getText());
              lastCommand="+";
              result.setText("0");
              }

       }
 }