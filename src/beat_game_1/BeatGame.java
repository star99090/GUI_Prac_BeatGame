package beat_game_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BeatGame extends JFrame {
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	
	private Image background = new ImageIcon(Main.class.getResource("../images/Title.jpg")).getImage();
	private Image titleImage;
	private Image selectedImage;
	private Image screenImage;
	
	private Music titleMusic = new Music("Intro.mp3", true); // 배경화면에 Intro.mp3 객체 추가
	private Music selectedMusic;
	
	private int nowSelected = 0;
	private int mouseX, mouseY;
	
	ArrayList<Track> trackList = new ArrayList<Track>(); // ArrayList는 이미 만들어져 제공되는 리스트배열
	
	private Graphics screenGraphic;
	
	private boolean isMainScreen = false; // Main 화면으로 이동하면 true값을 갖게 할 예정
	private boolean isGameScreen = false;
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	public static Game game = new Game();

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
		titleMusic.start(); // 배경음악 실행
		
		addKeyListener(new KeyListener());

		trackList.add(new Track("Angel With A Shotgun Title Image.png", "Angel With A Shotgun Start Image.jpg",
				"Angel With A Shotgun Game Image.jpg", "Angel With A Shotgun Selected.mp3",
				"The Cab - Angel With A Shotgun.mp3"));
		trackList.add(new Track("Lilly Title Image.png", "Lilly Start Image.jpg",
				"Lilly Game Image.jpg", "Lily Selected.mp3",
				"Alan Walker & K-391 & Emelie Hollow -Lily.mp3"));
		
		
		
		startButton.setBounds(287, 540, 293, 93); // x, y, width, height
		startButton.setBorderPainted(false); // 가까이가면 테두리 생겨서 변하는 모습 제거
		startButton.setContentAreaFilled(false);
		startButton.addMouseListener(new MouseAdapter() { // 마우스를 읽어들이기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼에 들어오면
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스가 버튼 안에서는 손가락 모양의 커서
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 누르면
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				enterMain();
			}
		});
		add(startButton);

		exitButton.setBounds(1245, 4, 30, 30);
		exitButton.setBorderPainted(false); // 가까이가면 테두리 생겨서 변하는 모습 제거
		exitButton.setContentAreaFilled(false);
		exitButton.addMouseListener(new MouseAdapter() { // 마우스를 읽어들이기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼에 들어오면
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스가 버튼 안에서는 손가락 모양의 커서
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
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
		
		quitButton.setBounds(700, 540, 293, 93);
		quitButton.setBorderPainted(false); // 가까이가면 테두리 생겨서 변하는 모습 제거
		quitButton.setContentAreaFilled(false);
		quitButton.addMouseListener(new MouseAdapter() { // 마우스를 읽어들이기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼에 들어오면
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스가 버튼 안에서는 손가락 모양의 커서
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false); // isLoop값에 false가 전달되므로 한 번만 실행
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
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 누르면
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				selectLeft();
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
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 누르면
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				selectRight();
			}
		});
		add(rightButton);

		easyButton.setVisible(false);
		easyButton.setBounds(190, 580, 200, 100); // x, y, width, height
		easyButton.setBorderPainted(false); // 가까이가면 테두리 생겨서 변하는 모습 제거
		easyButton.setContentAreaFilled(false);
		easyButton.addMouseListener(new MouseAdapter() { // 마우스를 읽어들이기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼에 들어오면
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스가 버튼 안에서는 손가락 모양의 커서
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 누르면
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				gameStart(nowSelected, "easy");
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(880, 580, 200, 100); // x, y, width, height
		hardButton.setBorderPainted(false); // 가까이가면 테두리 생겨서 변하는 모습 제거
		hardButton.setContentAreaFilled(false);
		hardButton.addMouseListener(new MouseAdapter() { // 마우스를 읽어들이기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼에 들어오면
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스가 버튼 안에서는 손가락 모양의 커서
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 누르면
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				gameStart(nowSelected, "hard");
			}
		});
		add(hardButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20, 20, 70, 70); // x, y, width, height
		backButton.setBorderPainted(false); // 가까이가면 테두리 생겨서 변하는 모습 제거
		backButton.setContentAreaFilled(false);
		backButton.addMouseListener(new MouseAdapter() { // 마우스를 읽어들이기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼에 들어오면
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스가 버튼 안에서는 손가락 모양의 커서
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어나면
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 다시 버튼을 벗어나면 기본값 커서로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 누르면
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				backMain();
			}
		});
		add(backButton);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_WIDTH); // 1280x720 이미지 생성
		screenGraphic = screenImage.getGraphics(); // Image에 Graphic을 통해 그림을 가져올거임
		screenDraw((Graphics2D)screenGraphic); // Graphic를 받아서 Draw 함수를 통해 그리기 위한 정보를 가져옴, Image에 우리가 가져온 그림을 대입함
		g.drawImage(screenImage, 0, 0, null); // Image에 그려진 그림을 그려냄
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage,240, 80, null); // x240, y120 위치에 selectedImage 삽입
			g.drawImage(titleImage, 290, 80, null);
		}
		if(isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g); // JLabel,JButton 등을 JFrame 안에 그려주는 역할
		this.repaint();
	}
	
	public void selectedTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() { // 좌측 버튼 이벤트
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectedTrack(nowSelected);
	}
	
	public void selectRight() { // 우측 버튼 이벤트
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectedTrack(nowSelected);
	}
	
	public void gameStart(int newSelected, String difficulty) {
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		backButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
		isGameScreen = true;
		setFocusable(true); // 키보드 포커스가 맞춰진다
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		backButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		selectedTrack(nowSelected);
		isGameScreen = false;
	}
	
	public void enterMain() {
		startButton.setVisible(false); // 게임 시작 화면 전환 이벤트로서 각 버튼을 숨기고 배경화면을 전환한다.
		quitButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		selectedTrack(0);
		titleMusic.close();
	}
}