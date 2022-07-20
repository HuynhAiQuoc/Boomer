package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.HightScore;

/**
 * @version 1.0
 * @author Huynh Ai Quoc
 * Lop dinh nghia hien thi so diem cao dat duoc trong game
 */
public class HightScorePanel {
	protected JPanel hightScorePanel;
	private ArrayList<HightScore> arrHightScore;
	private JLabel lbCancel;
	private ImageIcon backgrLbOp;

	/**
	 * Constructor
	 */
	public HightScorePanel() {
		hightScorePanel = pnHighScore;
		hightScorePanel.setBackground(Color.YELLOW);
		hightScorePanel.setLayout(null);
		initCompts();
	}

	/**
	 * Phuong thuc dung de hien thi man hinh diem so
	 */
	public void initCompts() {
		lbCancel = new JLabel();
		backgrLbOp = new ImageIcon(getClass().getResource("/Images/cancel1.png"));
		lbCancel.setBounds(829, 564, backgrLbOp.getIconWidth(), backgrLbOp.getIconHeight());
		lbCancel.setIcon(backgrLbOp);
		hightScorePanel.add(lbCancel);
	}

	@SuppressWarnings("serial")
	private JPanel pnHighScore = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			drawImage(g2d);
			if (arrHightScore != null) {
				drawHightSore(g2d);
			}
		}
	};

	/**
	 * 
	 * @param g2d: tham so truyen vao co kieu la Graphics2D
	 * Graphics2D: xu ly do hoa 2D(theo he truc toa do Oxy)
	 */
	public void drawImage(Graphics2D g2d) {
		Image background = new ImageIcon(getClass().getResource("/Images/background_Menu2.png")).getImage();
		Image backgrLb = new ImageIcon(getClass().getResource("/Images/background_hightscore.png")).getImage();
		g2d.drawImage(background, 0, 0, null);
		g2d.drawImage(backgrLb, 55, 40, null);
	}

	/**
	 * @param g2d: tham so truyen vao co kieu la Graphics2D
	 * Graphics2D: xu ly do hoa 2D(theo he truc toa do Oxy)
	 * Man hinh diem so:
	 *  1. Kich thuoc tong 850x607
	 *  2. Kich thuoc hien thi: ,  
	 *     + STT(tang dan bien i): vi tri(chieu rong 195px); - Ox
	 *     + Name: vi tri(chieu rong: 330px); - Ox
	 *     + Diem so: vi tri(chieu rong 665px); - Ox
	 *     + Khoang cach moi dong: y + 45px; - Oy
	 */
	public void drawHightSore(Graphics2D g2d) {
		g2d.setStroke(new java.awt.BasicStroke(2));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("Arial", Font.BOLD, 30));
		g2d.setColor(Color.YELLOW);
		int y = 170;
		for (int i = 0; i < arrHightScore.size(); i++) {
			g2d.drawString("" + (i + 1), 195, y);
			g2d.drawString("" + arrHightScore.get(i).getName(), 330, y);
			g2d.drawString("" + arrHightScore.get(i).getScore(), 665, y);
			y = y + 45;
		}

	}

	/**
	 * Phuong thuc dung de thiet lap so diem
	 * @param arrHightScore: tham so truyen vao co kieu la mot mang ArrayList
	 */
	public void setArrHightScore(ArrayList<HightScore> arrHightScore) {
		this.arrHightScore = arrHightScore;
	}

	public JLabel getLbCancel() {
		return lbCancel;
	}

	public void addHightScoreActorMouseListener(MouseAdapter adapter) {
		lbCancel.addMouseListener(adapter);
	}
}
