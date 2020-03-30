package beat_game_1;

public class Main {
	public static final int SCREEN_WIDTH = 1280;
	public static final int SECREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 5;  // 노트가 떨어지는 속도
	public static final int SLEEP_TIME = 10; // 노트가 떨어지는 주기
	public static final int REACH_TIME = 2;
	
	public static void main(String[] args) {
			new BeatGame();
	}
}