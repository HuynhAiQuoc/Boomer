package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

/**
 * @version 1.0
 * @author Huynh Ai Quoc
 * Lop dinh nghia thoi gian dem nguoc(countdown) trong mot man, ap dung Observer pattern
 */
public class Countdown extends Observable {
	private Timer timer;
	private int minute;
	private int second;

	/**
	 * Constructor
	 */
	public Countdown() {
		// minute=2;
		// second=0;
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tick();
			}
		});

	}

	/**
	 * Phuong thuc dung de kiem tra thoi gian trong game
	 * setChanged(): thiet lap thay doi len Observer
	 * notifyObservers(): thong bao thay doi len Observer
	 * @return
	 */
	public boolean checkTimeOut() {
		if (minute == 1 && second == 0) {
			return true;
		}
		return false;
	}

	public void tick() {
		if (second == 0) {
			minute--;
			second = 60;
		}
		second--;
		if (second == 0 && minute == 0) {
			timer.stop();
		}
		setChanged();
		notifyObservers(this);
	}

	public int getMinute() {
		return minute;
	}

	public Timer getTimer() {
		return timer;
	}

	public int getSecond() {
		return second;
	}

	public void update(int minute, int second) {
		this.minute = minute;
		this.second = second;
	}

}
