package model;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

/**
 * @version 1.0
 * @author Huynh Ai Quoc
 * Lop dinh nghia ve nhan vat "Be Bong" trong tro choi
 */
public class BeBong extends Bomber {

	/**
	 * constructor
	 * @param x: di chuyen theo truc 0x(trai - phai)
	 * @param y: di chuyen theo truc 0y(len - xuong)
	 * @param type: so nhan vat tu 1 -> 4
	 * @param orient: huong di chuyen
	 * @param speed: toc do
	 * @param sizebomb: kich thuoc bomb
	 * @param quantityBomb: so luong bomb
	 */
	public BeBong(int x, int y, int type, int orient, int speed, int sizebomb, int quantityBomb) {
		super(x, y, type, orient, speed, sizebomb, quantityBomb);

		this.runBomb = DISALLOW_RUN;
		this.heart = 5;
		this.score = 0;
		this.status = Actor.ALIVE;
		this.img = new ImageIcon(getClass().getResource("/Images/bebong_down.png")).getImage();
		width = img.getWidth(null);
		height = img.getHeight(null) - 11;
	}

	@Override
	public void setNew(int x, int y) {
		this.x = x;
		this.y = y;
		this.status = ALIVE;
		this.img = new ImageIcon(getClass().getResource("/Images/bebong_down.png")).getImage();
	}

	@Override
	public void drawActor(Graphics2D g2d) {
		super.drawActor(g2d);
		drawable = new DrawBeBongImpl();
		drawable.draw(this, g2d);
	}

	@Override
	public void changeOrient(int orient) {
		super.changeOrient(orient);
		orientable = new OrientBeBongImpl();
		orientable.changeOrient(this, orient);
	}

	@Override
	public void setQuantityBomb(int quantityBomb) {
		if (quantityBomb > 10) {
			return;
		}
		this.quantityBomb = quantityBomb;
	}

	@Override
	public void setSizeBomb(int sizeBomb) {
		if (sizeBomb > 10) {
			return;
		}
		this.sizeBomb = sizeBomb;
	}

	@Override
	public void setSpeed(int speed) {
		if (speed < 1) {
			return;
		}
		this.speed = speed;
	}
}