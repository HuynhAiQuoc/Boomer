package view;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * @version 1.0
 * @author Huynh Ai Quoc
 * Lop dinh nghia hien thi "man hinh tro choi"
 * Thiet lap kich thuoc gioi han cho khung choi
 *  + WIDTHJ(Chieu rong): 947(the image size is default) + 6(addition)
 *  + HEIGHJF(Chieu cao): 675(the image size is default) + 29(addition)
 */
public class GameView {
	private JFrame view;
	public static final int WIDTHJF = 947 + 6;
	public static final int HEIGHTJF = 675 + 29;
	public MyContainer myContainer;

	/**
	 * Phuong thuc dung de hien thi khung tro choi
	 */
	public GameView() {
		view = new JFrame("Game BOOM");
		view.setLayout(new CardLayout());
		view.setSize(WIDTHJF, HEIGHTJF);
		view.setLocationRelativeTo(null);
		view.setResizable(false);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myContainer = new MyContainer(this);
		view.add(myContainer.myContainer);

		Image image = Toolkit.getDefaultToolkit().getImage("src/Images/dau.png");
		view.setIconImage(image);
	}

	public JFrame getView() {
		return view;
	}

}
