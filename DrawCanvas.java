import java.awt.*;
 import javax.swing.*;
 public class DrawCanvas extends JFrame{
 public static void main(String args[]){
 JFrame frame=new JFrame();
 frame.setSize(600,600);
 frame.setTitle("DrawCanvas");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JCanvas canvas = new JCanvas();
 frame.add(canvas);
 frame.setVisible(true);

 canvas.setStroke(new BasicStroke(5));
 canvas.drawRect(10,20,100,200);
 canvas.drawOval(120,20,100,200);
 canvas.drawRoundRect(230,20,100,200,20,20);
 canvas.drawArc(340,20,100,200,45,270);
 canvas.drawLine(450,20,500,220);
 canvas.drawDashedLine(10,480,20,530,220);

 canvas.setPaint(Color.gray);
 canvas.fillRect(10,320,100,200);
 canvas.fillOval(120,320,100,200);
 canvas.fillRoundRect(230,320,100,200,20,20);
 canvas.fillArc(340,320,100,200,45,270);
 }
}