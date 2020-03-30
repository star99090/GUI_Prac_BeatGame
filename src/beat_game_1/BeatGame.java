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
	
	private Music titleMusic = new Music("Intro.mp3", true); // ���ȭ�鿡 Intro.mp3 ��ü �߰�
	private Music selectedMusic;
	
	private int nowSelected = 0;
	private int mouseX, mouseY;
	
	ArrayList<Track> trackList = new ArrayList<Track>(); // ArrayList�� �̹� ������� �����Ǵ� ����Ʈ�迭
	
	private Graphics screenGraphic;
	
	private boolean isMainScreen = false; // Main ȭ������ �̵��ϸ� true���� ���� �� ����
	private boolean isGameScreen = false;
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	public static Game game = new Game();

	public BeatGame() { // ������
		setUndecorated(true);
		setTitle("BeatGame");
		setSize(Main.SCREEN_WIDTH, Main.SECREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		titleMusic.start(); // ������� ����
		
		addKeyListener(new KeyListener());

		trackList.add(new Track("Angel With A Shotgun Title Image.png", "Angel With A Shotgun Start Image.jpg",
				"Angel With A Shotgun Game Image.jpg", "Angel With A Shotgun Selected.mp3",
				"The Cab - Angel With A Shotgun.mp3"));
		trackList.add(new Track("Lilly Title Image.png", "Lilly Start Image.jpg",
				"Lilly Game Image.jpg", "Lily Selected.mp3",
				"Alan Walker & K-391 & Emelie Hollow -Lily.mp3"));
		
		
		
		startButton.setBounds(287, 540, 293, 93); // x, y, width, height
		startButton.setBorderPainted(false); // �����̰��� �׵θ� ���ܼ� ���ϴ� ��� ����
		startButton.setContentAreaFilled(false);
		startButton.addMouseListener(new MouseAdapter() { // ���콺�� �о���̱�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� ������
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺�� ��ư �ȿ����� �հ��� ����� Ŀ��
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� ������
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				enterMain();
			}
		});
		add(startButton);

		exitButton.setBounds(1245, 4, 30, 30);
		exitButton.setBorderPainted(false); // �����̰��� �׵θ� ���ܼ� ���ϴ� ��� ����
		exitButton.setContentAreaFilled(false);
		exitButton.addMouseListener(new MouseAdapter() { // ���콺�� �о���̱�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� ������
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺�� ��ư �ȿ����� �հ��� ����� Ŀ��
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				try {
					Thread.sleep(200); // 0.2�� ������
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
				mouseX = e.getX(); //Ŭ�� �� ���� X ��ǥ
				mouseY = e.getY();
			}
			
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen(); // ȭ�� ���� �������� x ��ǥ
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(menuBar);
		
		quitButton.setBounds(700, 540, 293, 93);
		quitButton.setBorderPainted(false); // �����̰��� �׵θ� ���ܼ� ���ϴ� ��� ����
		quitButton.setContentAreaFilled(false);
		quitButton.addMouseListener(new MouseAdapter() { // ���콺�� �о���̱�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� ������
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺�� ��ư �ȿ����� �հ��� ����� Ŀ��
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false); // isLoop���� false�� ���޵ǹǷ� �� ���� ����
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
		leftButton.setBorderPainted(false); // �����̰��� �׵θ� ���ܼ� ���ϴ� ��� ����
		leftButton.setContentAreaFilled(false);
		leftButton.addMouseListener(new MouseAdapter() { // ���콺�� �о���̱�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� ������
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺�� ��ư �ȿ����� �հ��� ����� Ŀ��
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� ������
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				selectLeft();
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1140, 360, 60, 60); // x, y, width, height
		rightButton.setBorderPainted(false); // �����̰��� �׵θ� ���ܼ� ���ϴ� ��� ����
		rightButton.setContentAreaFilled(false);
		rightButton.addMouseListener(new MouseAdapter() { // ���콺�� �о���̱�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� ������
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺�� ��ư �ȿ����� �հ��� ����� Ŀ��
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� ������
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				selectRight();
			}
		});
		add(rightButton);

		easyButton.setVisible(false);
		easyButton.setBounds(190, 580, 200, 100); // x, y, width, height
		easyButton.setBorderPainted(false); // �����̰��� �׵θ� ���ܼ� ���ϴ� ��� ����
		easyButton.setContentAreaFilled(false);
		easyButton.addMouseListener(new MouseAdapter() { // ���콺�� �о���̱�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� ������
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺�� ��ư �ȿ����� �հ��� ����� Ŀ��
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� ������
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				gameStart(nowSelected, "easy");
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(880, 580, 200, 100); // x, y, width, height
		hardButton.setBorderPainted(false); // �����̰��� �׵θ� ���ܼ� ���ϴ� ��� ����
		hardButton.setContentAreaFilled(false);
		hardButton.addMouseListener(new MouseAdapter() { // ���콺�� �о���̱�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� ������
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺�� ��ư �ȿ����� �հ��� ����� Ŀ��
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� ������
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				gameStart(nowSelected, "hard");
			}
		});
		add(hardButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20, 20, 70, 70); // x, y, width, height
		backButton.setBorderPainted(false); // �����̰��� �׵θ� ���ܼ� ���ϴ� ��� ����
		backButton.setContentAreaFilled(false);
		backButton.addMouseListener(new MouseAdapter() { // ���콺�� �о���̱�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� ������
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺�� ��ư �ȿ����� �հ��� ����� Ŀ��
				Music ButtonEnteredMusic = new Music("ButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� ������
				Music ButtonPressedMusic = new Music("ButtonPressedEffect.mp3", false);
				ButtonPressedMusic.start();
				backMain();
			}
		});
		add(backButton);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_WIDTH); // 1280x720 �̹��� ����
		screenGraphic = screenImage.getGraphics(); // Image�� Graphic�� ���� �׸��� �����ð���
		screenDraw((Graphics2D)screenGraphic); // Graphic�� �޾Ƽ� Draw �Լ��� ���� �׸��� ���� ������ ������, Image�� �츮�� ������ �׸��� ������
		g.drawImage(screenImage, 0, 0, null); // Image�� �׷��� �׸��� �׷���
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage,240, 80, null); // x240, y120 ��ġ�� selectedImage ����
			g.drawImage(titleImage, 290, 80, null);
		}
		if(isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g); // JLabel,JButton ���� JFrame �ȿ� �׷��ִ� ����
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
	
	public void selectLeft() { // ���� ��ư �̺�Ʈ
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectedTrack(nowSelected);
	}
	
	public void selectRight() { // ���� ��ư �̺�Ʈ
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
		setFocusable(true); // Ű���� ��Ŀ���� ��������
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
		startButton.setVisible(false); // ���� ���� ȭ�� ��ȯ �̺�Ʈ�μ� �� ��ư�� ����� ���ȭ���� ��ȯ�Ѵ�.
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