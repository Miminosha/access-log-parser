import java.util.Random;

public class Cuckoo extends Bird {

    @Override
    public void sing() {
        Random random = new Random();
        int count = random.nextInt(10) + 1;
        for (int i = 0; i < count; i++) {
            System.out.print("ку-ку ");
        }
        System.out.println();
    }
}
