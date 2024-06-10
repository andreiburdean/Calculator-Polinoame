package GUI;
import java.awt.Font;
import javax.swing.JTextField;

public class TextField extends JTextField{
	
	TextField(int x, int y, int width, int height, int fontSize){
		setBounds(x,y,width,height);
		setFont(new Font("Arial", Font.PLAIN, fontSize));
	}
}
