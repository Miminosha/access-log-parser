public class Main {
    public static void main(String[] args) {

        Bird[] birds = {
                new Sparrow(),
                new Cuckoo(),
                new Sparrow(),
                new Parrot("Кеша"),
                new Cuckoo(),
                new Parrot("хороший")
        };

        sumOfSongs(birds);

    }

    public static void sumOfSongs(Bird[] birds) {
        for (Bird bird : birds) {
            bird.sing();
        }
    }

}