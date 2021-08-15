import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class Test extends JFrame
{
        JPanel testpanel,answerpanel,buttonpanel;
        JLabel num1,num2,oper,answer,equal;
        JButton check,next;
        JTextField field;
        JMenuBar bar;
        JMenu options;
        JRadioButtonMenuItem add,mul,div,sub;
        JMenuItem exit;
        ButtonGroup group;
        ImageIcon correct,wrong,empty;
        Container cont;
        int a,b,c,temp,test=0,marks=0,ch=0;
        int i=23;
        int j=10;
Test()
 {
        cont=getContentPane();
        bar=new JMenuBar();
        options=new JMenu("Options");
        group=new ButtonGroup();
        add=new JRadioButtonMenuItem("Addition",true);
        sub=new JRadioButtonMenuItem("Substraction");
        mul=new JRadioButtonMenuItem("Multiplication");
        div=new JRadioButtonMenuItem("Division");
        exit=new JMenuItem("Exit");
        JSeparator separator=new JSeparator();
        group.add(add);
        group.add(sub);
        group.add(mul);
        group.add(div);
        options.add(add);
        options.add(sub);
        options.add(mul);
        options.add(div);
        options.add(separator);
        options.add(exit);
        bar.add(options);
        setJMenuBar(bar);
        cont.setLayout(new BoxLayout(cont,BoxLayout.Y_AXIS));
        testpanel=new JPanel();
        testpanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        answerpanel=new JPanel();
        answerpanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        answerpanel.setBackground(Color.white);
        buttonpanel=new JPanel();
        buttonpanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        Font f=new Font("Arial",Font.PLAIN,18);

        check=new JButton("Check");
        next=new JButton("Next");
        buttonpanel.add(next);
        buttonpanel.add(check);

        num1=new JLabel(""+i);
        num1.setFont(f);
        num2=new JLabel(""+j);
        num2.setFont(f);

        oper=new JLabel("+");
        oper.setFont(f);

        equal=new JLabel("=");
        equal.setFont(f);

        correct=new ImageIcon("correct.gif");
        wrong=new ImageIcon("wrong.gif");
        empty=new ImageIcon("empty.gif");
        answer=new JLabel();
        answer.setIcon(empty);

        JPanel textpanel=new JPanel();
        textpanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        field=new JTextField(10);
        field.setFont(f);
        field.addKeyListener(new KeyAdapter()
        {
         public void keyTyped(KeyEvent ke)
         {
           char x=ke.getKeyChar();
           if(x>='a'&& x<='z')
           {
           ke.consume();
           }
           else
           {}
         }
        });
        field.setText("");
        textpanel.add(field);
        answerpanel.add(answer);
        testpanel.add(num1);
        testpanel.add(oper);
        testpanel.add(num2);
        testpanel.add(equal);
        testpanel.add(textpanel);
        testpanel.add(answerpanel);
        cont.add(testpanel);
        cont.add(buttonpanel);
        field.addMouseListener(new mouselistener());
        check.addActionListener(new buttonlistener());
        next.addActionListener(new buttonlistener());
        add.addItemListener(new radiohandler());
        sub.addItemListener(new radiohandler());
        mul.addItemListener(new radiohandler());
        div.addItemListener(new radiohandler());
        exit.addActionListener(new buttonlistener());
 }
public class radiohandler implements ItemListener
{
        public void itemStateChanged(ItemEvent itemevent)
         {
                AbstractButton 
button=(AbstractButton)itemevent.getItem();
                String label=button.getText();
                if(label.equals("Addition"))
                {
                oper.setText("+");
                field.setText("");
                initialise();
                setTitle("ADDITION");
                }
                if(label.equals("Substraction"))
                {
                oper.setText("-");
                field.setText("");
                initialise();
                setTitle("SUBSTRACTION");
                }
                if(label.equals("Multiplication"))
                {
                oper.setText("*");
                field.setText("");
                initialise();
                setTitle("MULTIPLICATION");
                }
                if(label.equals("Division"))
                {
                oper.setText("/");
                initialise();
                field.setText("");
                setTitle("DIVISION");
                }

        }
}
public void initialise()
{
         field.setEditable(true);
         field.setForeground(Color.black);
         num1.setText("23");
         num2.setText("10");
         answer.setIcon(empty);
         validate();
         test=0;
}
class mouselistener extends MouseAdapter
{
public void mouseEntered(MouseEvent me)
{
        if(test==1)
        {
        field.setForeground(Color.green);
        field.setToolTipText(""+c);
        field.setText(""+c);
        answer.setIcon(correct);
        }
        else
        {
        c=0;
        field.setToolTipText(""+c);
        }
}
public void mouseExited(MouseEvent me)
{
        if(test==1)
        {
         if(temp==c)
          {
           field.setText("");
           field.setForeground(Color.green);
           field.setText(""+temp);
           answer.setIcon(correct);
          }
         else
          {
           field.setText("");
           field.setForeground(Color.red);
           field.setText(""+temp);
           answer.setIcon(wrong);
          }
        }
        else if(test==0)
        {
           temp=0;
        }
 }
}
class buttonlistener implements ActionListener
 {
  public void actionPerformed(ActionEvent ae)
  {
        String str=ae.getActionCommand();
        if(str.equals("Check"))
        {
        temp=Integer.parseInt(field.getText());
        field.setText("");
        String mathoper=oper.getText();

        a=Integer.parseInt(num1.getText());
        b=Integer.parseInt(num2.getText());

        if(mathoper.equals("+"))
        {
        addcheck();
        }
        if(mathoper.equals("-"))
        {
        subcheck();
        }
        if(mathoper.equals("*"))
        {
        mulcheck();
        }
        if(mathoper.equals("/"))
        {
        divcheck();
        }
        check();
        test=1;
        }
        if(str.equals("Next"))
         {
                int x=i+2;
                int y=i+2;
                i=Integer.parseInt(num1.getText()) + randomInt(x);
                j=Integer.parseInt(num2.getText()) + randomInt(y);
                num1.setText(""+i);
                num2.setText(""+j);
                field.setEditable(true);
                field.setForeground(Color.black);
                field.setText("");
                test=0;
                answer.setIcon(empty);
                field.requestFocus();
                validate();
          }
         if(str.equals("Exit"))
           {
                System.exit(0);
           }
  }
}
static int randomInt(int max)
  {
  int r=(int)(max*Math.random());
  r%=max;
  return r;
  }
public void addcheck()
        {
        c=a+b;
        }
public void subcheck()
        {
        c=a-b;
        }
public void mulcheck()
        {
        c=a*b;
        }
public void divcheck()
        {
        c=a/b;
        }
public void check()
{
        if(temp==c)
         {
         field.setText(""+temp);
         field.setForeground(Color.green);
         answer.setIcon(correct);
         }
         else
         {
         field.setText(""+temp);
         field.setForeground(Color.red);
         answer.setIcon(wrong);
         }
}
public static void main(String args[])
 {
        Test test=new Test();
        test.setTitle("ADDITION");
        test.setSize(400,170);
        test.show();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}