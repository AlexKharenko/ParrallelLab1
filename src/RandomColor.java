import java.awt.*;
import java.util.Random;

public class RandomColor extends Color {
    public RandomColor(int r, int g, int b) {
        super(r, g, b);
    }

    public static Color getRandomColor() {
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(256);
        int green = randomGenerator.nextInt(256);
        int blue = randomGenerator.nextInt(256);

        Color randomColour = new Color(red, green, blue);
        return randomColour;
    }
}
