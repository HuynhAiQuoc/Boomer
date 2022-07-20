package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @version 1.0
 * @author Huynh Ai Quoc
 * Lop dinh nghia hien thi menu cua tro choi
 */
public class MenuView {
	protected JPanel menuPanel;
	// private int padding = 15;;
	private JLabel lbbackground;
	private JLabel lbPlayGame;
	private JLabel lbOption;
	private JLabel lbHigthScore;
	private JLabel lbExit;
	private ImageIcon backgroundIcon;

	/**
	 * Constructor
	 */
	public MenuView() {
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.YELLOW);
		menuPanel.setLayout(null);
		initComps();
		initbackground();
	}

	/**
	 * @return label(toan canh)
	 */
	public JLabel getLbbackground() {
		return lbbackground;
	}

	/**
	 * @return label(choi game)
	 */
	public JLabel getLbPlayGame() {
		return lbPlayGame;
	}

	/**
	 * @return label(lua chon)
	 */
	public JLabel getLbOption() {
		return lbOption;
	}

	/**
	 * @return label(diem cao)
	 */
	public JLabel getLbHigthScore() {
		return lbHigthScore;
	}

	/**
	 * @return label(thoat)
	 */
	public JLabel getLbExit() {
		return lbExit;
	}

	/**
	 * Phuong thuc dung de load(tai) hinh anh vao mot label => roi add(them) vao panelMenu
	 */
	public void initComps() {
		lbPlayGame = setLabel(500, 110, "/Images/Play.png");
		lbOption = setLabel(620, 230, "/Images/Option.png");
		lbHigthScore = setLabel(680, 350, "/Images/HightScore.png");
		lbExit = setLabel(620, 470, "/Images/Exit.png");

		menuPanel.add(lbPlayGame);
		menuPanel.add(lbOption);
		menuPanel.add(lbHigthScore);
		menuPanel.add(lbExit);
	}

	/**
	 * Phuong thuc dung de thiet lap va load(tai) background_Menu => roi add(them) vao panelMenu
	 */
	public void initbackground() {
		lbbackground = new JLabel();
		lbbackground.setBounds(0, -15, GameView.WIDTHJF, GameView.HEIGHTJF);
		lbbackground.setBackground(Color.BLACK);
		backgroundIcon = new ImageIcon(getClass().getResource("/Images/background_Menu.png"));
		lbbackground.setIcon(backgroundIcon);
		menuPanel.add(lbbackground);
	}

	/**
	 * 
	 * @param x: tham so truyen vao la mot bien x co kieu Integer theo truc toa do x(Ox)
	 * @param y: tham so truyen vao la mot bien y co kieu Integer theo truc toa do y(Oy)
	 * @param ImageIcon: tham so truyen vao la duong dan hinh anh co kieu String
	 * @return
	 */
	public JLabel setLabel(int x, int y, String ImageIcon) {
		JLabel label = new JLabel();
		ImageIcon Icon = new ImageIcon(getClass().getResource(ImageIcon));
		label.setBounds(x, y, Icon.getIconWidth(), Icon.getIconHeight());
		label.setIcon(Icon);
		return label;
	}

	/**
	 * @param adapter: tham so truyen vao la mot bien co kieu MouseAdapter
	 * MouseAdapter: xu ly su kien con chuot
	 */
	public void addMenuMouseListener(MouseAdapter adapter) {
		lbPlayGame.addMouseListener(adapter);
		lbOption.addMouseListener(adapter);
		lbHigthScore.addMouseListener(adapter);
		lbExit.addMouseListener(adapter);
	}
}
