package beat_game_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 228, 580, null);
		
		for(int i=0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		}
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName,  20,  702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 850, 702);
	}

	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig2.mp3", false).start();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig3.mp3", false).start();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBigSpace.mp3", false).start();
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3", false).start();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall3.mp3", false).start();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	@Override
	public void run() {
		dropNotes();
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt(); // 현재 이 스레드 종료
	}
	
	public void dropNotes() {
		Beat[] beats = null;
		if(titleName.equals("The Cab - Angel With A Shotgun") && difficulty.equals("Easy")) {
			int startTime = 580 - Main.REACH_TIME * 500;
			int gap = 10;
			beats = new Beat[] {
					new Beat(startTime + gap * 265, "K"),
					new Beat(startTime + gap * 285, "K"),
					new Beat(startTime + gap * 670, "J"),
					new Beat(startTime + gap * 1050, "J"),
					new Beat(startTime + gap * 1070, "K"),
					new Beat(startTime + gap * 1254, "L"),
					new Beat(startTime + gap * 1294, "L"),
					new Beat(startTime + gap * 1334, "L"),
					new Beat(startTime + gap * 1374, "L"),
					new Beat(startTime + gap * 1440, "Space"),
					new Beat(startTime + gap * 1440, "D"),
					new Beat(startTime + gap * 1490, "J"),
					new Beat(startTime + gap * 1540, "Space"),
					new Beat(startTime + gap * 1540, "D"),
					new Beat(startTime + gap * 1600, "S"),
					new Beat(startTime + gap * 1620, "J"),
					new Beat(startTime + gap * 1700, "J"),
					new Beat(startTime + gap * 1740, "Space"),
					new Beat(startTime + gap * 1740, "D"),
					new Beat(startTime + gap * 1840, "J"),
					new Beat(startTime + gap * 1880, "J"),
					new Beat(startTime + gap * 1940, "Space"),
					new Beat(startTime + gap * 1940, "D"),
					new Beat(startTime + gap * 1980, "S"),
					new Beat(startTime + gap * 2000, "J"),
					new Beat(startTime + gap * 2080, "J"),
					new Beat(startTime + gap * 2130, "Space"),
					new Beat(startTime + gap * 2130, "D"),
					new Beat(startTime + gap * 2171, "F"),
					new Beat(startTime + gap * 2190, "D"),
					new Beat(startTime + gap * 2220, "S"),//변환부분
					new Beat(startTime + gap * 2220, "Space"),//변환부분
					new Beat(startTime + gap * 2268, "S"),
					new Beat(startTime + gap * 2316, "F"),
					new Beat(startTime + gap * 2364, "S"),
					new Beat(startTime + gap * 2412, "F"),
					new Beat(startTime + gap * 2436, "J"),
					new Beat(startTime + gap * 2460, "S"),
					new Beat(startTime + gap * 2508, "F"),
					new Beat(startTime + gap * 2556, "S"),
					new Beat(startTime + gap * 2604, "F"),
					new Beat(startTime + gap * 2628, "J"),
					new Beat(startTime + gap * 2652, "S"),
					new Beat(startTime + gap * 2700, "F"),//10
					new Beat(startTime + gap * 2749, "S"),
					new Beat(startTime + gap * 2798, "F"),
					new Beat(startTime + gap * 2822, "J"),
					new Beat(startTime + gap * 2846, "S"),
					new Beat(startTime + gap * 2894, "F"),
					new Beat(startTime + gap * 2942, "S"),
					new Beat(startTime + gap * 2991, "F"),
					new Beat(startTime + gap * 2991, "Space"),
					new Beat(startTime + gap * 3015, "J"),
					new Beat(startTime + gap * 3040, "S"),
					new Beat(startTime + gap * 3088, "F"),
					new Beat(startTime + gap * 3136, "S"),
					new Beat(startTime + gap * 3184, "F"),//20
					new Beat(startTime + gap * 3206, "J"),
					new Beat(startTime + gap * 3232, "S"),
					new Beat(startTime + gap * 3281, "F"),
					new Beat(startTime + gap * 3329, "S"),
					new Beat(startTime + gap * 3377, "F"),
					new Beat(startTime + gap * 3401, "J"),
					new Beat(startTime + gap * 3425, "S"),
					new Beat(startTime + gap * 3473, "F"),
					new Beat(startTime + gap * 3522, "S"),
					new Beat(startTime + gap * 3570, "F"),
					new Beat(startTime + gap * 3618, "S"),
					new Beat(startTime + gap * 3642, "J"),
					new Beat(startTime + gap * 3666, "S"),//30
					new Beat(startTime + gap * 3714, "S"),
					new Beat(startTime + gap * 3714, "Space"),
					/*new Beat(startTime + gap * 3763, "F"),
					new Beat(startTime + gap * 3812, "S"),
					new Beat(startTime + gap * 3860, "F"),
					new Beat(startTime + gap * 3908, "S"),
					new Beat(startTime + gap * 3957, "F"),
					new Beat(startTime + gap * 4005, "S"),
					new Beat(startTime + gap * 4053, "F"),
					new Beat(startTime + gap * 4101, "S"),
					new Beat(startTime + gap * 4149, "F"),//40
					new Beat(startTime + gap * 4198, "S"),
					new Beat(startTime + gap * 4195, "F"),
					new Beat(startTime + gap * 4242, "S"),
					new Beat(startTime + gap * 4289, "F"),
					new Beat(startTime + gap * 4336, "S"),
					new Beat(startTime + gap * 4383, "F"),
					new Beat(startTime + gap * 4430, "S"),
					new Beat(startTime + gap * 4477, "F"),
					new Beat(startTime + gap * 4524, "S"),
					new Beat(startTime + gap * 4571, "F"),//50
					new Beat(startTime + gap * 4618, "S"),
					new Beat(startTime + gap * 4665, "F"),
					new Beat(startTime + gap * 4712, "S"),
					new Beat(startTime + gap * 4759, "F"),
					new Beat(startTime + gap * 4806, "S"),
					new Beat(startTime + gap * 4853, "F"),
					new Beat(startTime + gap * 4900, "S"),
					new Beat(startTime + gap * 4947, "F"),
					new Beat(startTime + gap * 4994, "S"),
					new Beat(startTime + gap * 5041, "S"),//60*/
					
			};
		}
		else if(titleName.equals("The Cab - Angel With A Shotgun") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					
			};
		}
		else if(titleName.equals("Alan Walker & K-391 & Emelie Hollow - Lily") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					
			};
		}
		else if(titleName.equals("Alan Walker & K-391 & Emelie Hollow - Lily") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					
			};
		}
		int i=0;
		gameMusic.start();
		while(i<beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime()<=gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void judge(String input) {
		for(int i=0; i < noteList.size(); i++) {
			Note note =  noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
}
