import java.awt.*;
public class gui {
 public static void main (String args []) {
 // Create the window (frame)
 Frame f = new Frame("O fereastra");
 // Set the layout of the frame
 f.setLayout (new FlowLayout());
 // Create the components
 Button b1 = new Button("OK");
 Button b2 = new Button("Cancel");
 // Add the components to the frame
 f.add(b1);
 f.add(b2);
 f.pack();
 // Show the frame
 f.setVisible(true);
 }
}