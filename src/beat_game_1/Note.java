package beat_game_1;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000/Main.SLEEP_TIME*Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x = 228;
		}
		else if(noteType.equals("D")) {
			x = 332;
		}
		else if(noteType.equals("F")) {
			x = 436;
		}
		else if(noteType.equals("Space")) {
			x = 540;
		}
		else if(noteType.equals("J")) {
			x = 744;
		}
		else if(noteType.equals("K")) {
			x = 848;
		}
		else if(noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("Space")) {
			g.drawImage(noteBasicImage,  x,  y,  null);
			g.drawImage(noteBasicImage,  x + 100,  y,  null);
		}
		else {
			g.drawImage(noteBasicImage,  x,  y,  null);
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
		if(y>620) {
			System.out.println("Miss");
			close();
		}
	}
	
	@Override
	public void run() { // 쓰레드가 실행되게 하는 함수
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME); // 0.001초 기준이므로 10 = 1초에 700픽셀만큼!
				}
				else {
					interrupt();
					break;
				}
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void judge() {
		if(y>=600) {
			System.out.println("Late");
			close();
		}
		else if(y>=590) {
			System.out.println("Good");
			close();
		}
		else if(y>=575) {
			System.out.println("Great");
			close();
		}
		else if(y>=565) {
			System.out.println("Perfect");
			close();
		}
		else if(y>=560) {
			System.out.println("Great");
			close();
		}
		else if(y>=550) {
			System.out.println("Good");
			close();
		}
		else if(y>=540) {
			System.out.println("Early");
			close();
		}
	}
}
