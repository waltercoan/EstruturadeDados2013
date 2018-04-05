import javax.swing.JFrame;
import javax.swing.JLabel;


public class MuitoBobinho extends JFrame {
	public MuitoBobinho() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		
		add(new JLabel("UNIVILLE"));
		setVisible(true);
	}
	public static void main(String[] args) {
		new MuitoBobinho();
	}
}
