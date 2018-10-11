package patterns.singleton;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    private int score = 0;

    private static GuessGame instance;

    private GuessGame() {
    }

    public void play() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int number;

        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(9);
            System.out.print("Odgadnij wylosowaną liczbę: ");
            number = scanner.nextInt();
            if (number == randomNumber) {
                score++;
            }
        }
    }

    public static GuessGame getInstance() {
        if (instance == null) {
            synchronized (GuessGame.class) {
                if (instance == null) {
                    instance = new GuessGame();
                }
            }
        }
        return instance;
    }

    public int getScore() {
        return score;
    }

}
