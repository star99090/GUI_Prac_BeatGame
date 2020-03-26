package beat_game_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BeatGame extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Angel With A Shotgun Start Image.jpg")).getImage();
	private Image titleImage = new ImageIcon(Main.class.getResource("../images/Angel With A Shotgun Title Image.png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/Title.jpg")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false; // Main 화면으로 이동하면 true값을 갖게 할 예정
	public BeatGame() { // 생성자
		setUndecorated(true);
		setTitle("BeatGame");
		setSize(Main.SCREEN_WIDTH, Main.SECREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		startButton.setBounds(40, 200, 293, 93); // x, y, width, height
		startButton.setBorderPainted(false); // 가까이가면 테두리 생겨서 변하는 모습 제거
		startButton.setContentAreaFilled(false);
		startButton.addMouseListener(new MouseAdapter() { // 마우스를 읽어들이기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼에 들어오면
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스가 버튼 안에서는 손가락 모양의 커서
				Music ButtonEnteredMusic = new Music("exitButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 누르면
				Music ButtonPressedMusic = new Music("exitButtonEffect.mp3", false);
				ButtonPressedMusic.start();
				startButton.setVisible(false); // 게임 시작 화면 전환 이벤트로서 각 버튼을 숨기고 배경화면을 전환한다.
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);

		exitButton.setBounds(1245, 5, 30, 30);
		exitButton.setBorderPainted(false); // 가까이가면 테두리 생겨서 변하는 모습 제거
		exitButton.setContentAreaFilled(false);
		exitButton.addMouseListener(new MouseAdapter() { // 마우스를 읽어들이기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼에 들어오면
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스가 버튼 안에서는 손가락 모양의 커서
				Music ButtonEnteredMusic = new Music("exitButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonPressedMusic = new Music("exitButtonEffect.mp3", false);
				ButtonPressedMusic.start();
				try {
					Thread.sleep(200); // 0.2초 딜레이
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		quitButton.setBounds(40, 330, 293, 93);
		quitButton.setBorderPainted(false); // 가까이가면 테두리 생겨서 변하는 모습 제거
		quitButton.setContentAreaFilled(false);
		quitButton.addMouseListener(new MouseAdapter() { // 마우스를 읽어들이기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼에 들어오면
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스가 버튼 안에서는 손가락 모양의 커서
				Music ButtonEnteredMusic = new Music("exitButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonPressedMusic = new Music("exitButtonEffect.mp3", false); // isLoop값에 false가 전달되므로 한 번만 실행
				ButtonPressedMusic.start();
				try {
					Thread.sleep(200);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);

		leftButton.setVisible(false);
		leftButton.setBounds(80, 360, 60, 60); // x, y, width, height
		leftButton.setBorderPainted(false); // 가까이가면 테두리 생겨서 변하는 모습 제거
		leftButton.setContentAreaFilled(false);
		leftButton.addMouseListener(new MouseAdapter() { // 마우스를 읽어들이기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼에 들어오면
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스가 버튼 안에서는 손가락 모양의 커서
				Music ButtonEnteredMusic = new Music("exitButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 누르면
				Music ButtonPressedMusic = new Music("exitButtonEffect.mp3", false);
				ButtonPressedMusic.start();
				// 왼쪽 버튼 이벤트
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1140, 360, 60, 60); // x, y, width, height
		rightButton.setBorderPainted(false); // 가까이가면 테두리 생겨서 변하는 모습 제거
		rightButton.setContentAreaFilled(false);
		rightButton.addMouseListener(new MouseAdapter() { // 마우스를 읽어들이기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼에 들어오면
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스가 버튼 안에서는 손가락 모양의 커서
				Music ButtonEnteredMusic = new Music("exitButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 누르면
				Music ButtonPressedMusic = new Music("exitButtonEffect.mp3", false);
				ButtonPressedMusic.start();
				// 오른쪽 버튼 이벤트
			}
		});
		add(rightButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX(); //클릭 된 곳의 X 좌표
				mouseY = e.getY();
			}
			
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen(); // 화면 위의 순간순간 x 좌표
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(menuBar);


		Music titleMusic = new Music("Intro.mp3", true); // 배경화면에 Intro.mp3 객체 추가
		titleMusic.start(); // 배경음악 실행
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_WIDTH); // 1280x720 이미지 생성
		screenGraphic = screenImage.getGraphics(); // Image에 Graphic을 통해 그림을 가져올거임
		screenDraw(screenGraphic); // Graphic를 받아서 Draw 함수를 통해 그리기 위한 정보를 가져옴, Image에 우리가 가져온 그림을 대입함
		g.drawImage(screenImage, 0, 0, null); // Image에 그려진 그림을 그려냄
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage,240,120,null); // x240, y120 위치에 selectedImage 삽입
			g.drawImage(titleImage, 290, 120, null);
		}
		paintComponents(g); // JLabel,JButton 등을 JFrame 안에 그려주는 역할
		this.repaint();
	}
}