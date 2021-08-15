import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

public class CheckImage{
public static void main(String args[]){
JFrame frame=new JFrame("CheckImage");
frame.setSize(800,600);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JCanvas canvas=new JCanvas();
frame.add(canvas);
frame.setVisible(true);

BufferedImage img1=canvas.loadImage("res/Fox.jpg");
BufferedImage img2=canvas.scaleImage(img1,400,300);
BufferedImage img3=canvas.cropImage(img2,130,60,110,115);
canvas.storeImage(img3,"fox1.jpg");
BufferedImage img4=canvas.scaleImage(img3,2);
BufferedImage img5=canvas.rotateImage(img3);
BufferedImage img6=canvas.loadImage("fox1.jpg");
BufferedImage img7=canvas.rotateImage(canvas.rotateImage(img6));
BufferedImage img8=canvas.tileImage(img3,530,200);
BufferedImage img9=canvas.rotateImage(img8);
canvas.drawImage(img2,10,10);
canvas.drawImage(img4,10,320);
canvas.drawScaledImage(img3,245,380,1.5f);
canvas.drawImage(img3,420,10);
canvas.drawImage(img5,420,130);
canvas.drawScaledImage(img3,420,245,110,180);
canvas.drawImage(img7,420,435);
canvas.drawImage(img9,550,10);
canvas.writeToImage("checkimage.jpg",800,600);
}
}

