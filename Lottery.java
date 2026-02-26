import java.util.Random;
enum Color {
    GREEN, BLUE, PURPLE, WHITE, BLACK, YELLOW, ORANGE
}

class ColorSupplier {
    private final Random random = new Random();

    public String getRandomColor() {
        Color[] colors = Color.values();
        int index = random.nextInt(colors.length);
        return colors[index].name();
    }
}

class Ball {
    private String color;
    private int number;
    public Ball(String color, int number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Ball" + color + ", number:" + number;    
    }
    
}

class Lottery {
    private final ColorSupplier colorSupplier = new ColorSupplier();
    private final Random random = new Random();
    private static final int MAX_NUMBER = 100;

    public Ball getRandomBall() {
        String color = colorSupplier.getRandomColor();
        
        int number = random.nextInt(MAX_NUMBER + 1); 
        return new Ball(color, number);
    }

}
    public class Main {
    public static void main(String[] args) {
        Lottery lottery = new Lottery();

        System.out.println("Drawing 3 balls");
        
        for (int i = 1; i <= 3; i++) {
            Ball ball = lottery.getRandomBall();
            System.out.println("Draw #" + i + ": " + ball);
        }
    }
}