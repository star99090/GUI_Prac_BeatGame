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
	
	private boolean isMainScreen = false; // Main ȭ������ �̵��ϸ� true���� ���� �� ����
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

		startButton.setBounds(40, 200, 293, 93); // x, y, width, height
		startButton.setBorderPainted(false); // �����̰��� �׵θ� ���ܼ� ���ϴ� ��� ����
		startButton.setContentAreaFilled(false);
		startButton.addMouseListener(new MouseAdapter() { // ���콺�� �о���̱�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� ������
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺�� ��ư �ȿ����� �հ��� ����� Ŀ��
				Music ButtonEnteredMusic = new Music("exitButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� ������
				Music ButtonPressedMusic = new Music("exitButtonEffect.mp3", false);
				ButtonPressedMusic.start();
				startButton.setVisible(false); // ���� ���� ȭ�� ��ȯ �̺�Ʈ�μ� �� ��ư�� ����� ���ȭ���� ��ȯ�Ѵ�.
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);

		exitButton.setBounds(1245, 5, 30, 30);
		exitButton.setBorderPainted(false); // �����̰��� �׵θ� ���ܼ� ���ϴ� ��� ����
		exitButton.setContentAreaFilled(false);
		exitButton.addMouseListener(new MouseAdapter() { // ���콺�� �о���̱�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� ������
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺�� ��ư �ȿ����� �հ��� ����� Ŀ��
				Music ButtonEnteredMusic = new Music("exitButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonPressedMusic = new Music("exitButtonEffect.mp3", false);
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
		
		quitButton.setBounds(40, 330, 293, 93);
		quitButton.setBorderPainted(false); // �����̰��� �׵θ� ���ܼ� ���ϴ� ��� ����
		quitButton.setContentAreaFilled(false);
		quitButton.addMouseListener(new MouseAdapter() { // ���콺�� �о���̱�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� ������
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺�� ��ư �ȿ����� �հ��� ����� Ŀ��
				Music ButtonEnteredMusic = new Music("exitButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonPressedMusic = new Music("exitButtonEffect.mp3", false); // isLoop���� false�� ���޵ǹǷ� �� ���� ����
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
				Music ButtonEnteredMusic = new Music("exitButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� ������
				Music ButtonPressedMusic = new Music("exitButtonEffect.mp3", false);
				ButtonPressedMusic.start();
				// ���� ��ư �̺�Ʈ
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
				Music ButtonEnteredMusic = new Music("exitButtonEffect.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ��ư�� �����
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �ٽ� ��ư�� ����� �⺻�� Ŀ���� ����
			}
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� ������
				Music ButtonPressedMusic = new Music("exitButtonEffect.mp3", false);
				ButtonPressedMusic.start();
				// ������ ��ư �̺�Ʈ
			}
		});
		add(rightButton);
		
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


		Music titleMusic = new Music("Intro.mp3", true); // ���ȭ�鿡 Intro.mp3 ��ü �߰�
		titleMusic.start(); // ������� ����
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_WIDTH); // 1280x720 �̹��� ����
		screenGraphic = screenImage.getGraphics(); // Image�� Graphic�� ���� �׸��� �����ð���
		screenDraw(screenGraphic); // Graphic�� �޾Ƽ� Draw �Լ��� ���� �׸��� ���� ������ ������, Image�� �츮�� ������ �׸��� ������
		g.drawImage(screenImage, 0, 0, null); // Image�� �׷��� �׸��� �׷���
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage,240,120,null); // x240, y120 ��ġ�� selectedImage ����
			g.drawImage(titleImage, 290, 120, null);
		}
		paintComponents(g); // JLabel,JButton ���� JFrame �ȿ� �׷��ִ� ����
		this.repaint();
	}
}