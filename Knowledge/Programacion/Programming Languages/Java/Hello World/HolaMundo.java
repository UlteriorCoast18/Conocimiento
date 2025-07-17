import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class HolaMundo {
    public static void main(String args[]) {
    JFrame frame = new JFrame("HelloWorldGUI window title");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel contentPane = (JPanel) frame.getContentPane();
    JLabel label = new JLabel("Hello World!");
    contentPane.add(label);

    frame.setSize(100, 50);
    frame.setVisible(true);
    }
}