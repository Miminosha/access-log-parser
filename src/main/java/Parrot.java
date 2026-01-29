import java.util.Random;

public class Parrot extends Bird {

    String text;

    public Parrot(String text) {
        this.text = text;
    }

    @Override
    public void sing() {
        Random random = new Random();

        int n = random.nextInt(text.length() + 1);
        System.out.println(text.substring(0, n));
    }
}
