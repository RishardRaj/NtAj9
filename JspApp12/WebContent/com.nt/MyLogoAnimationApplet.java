import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;


public class MyLogoAnimationApplet extends Applet {
	
	@Override
	public void paint(Graphics g) {
		 String title=getParameter("title");
		    g.setFont(new Font("arial",Font.BOLD,20));
		    g.drawString(title,50,100);
	}//paint(-)
}//class

