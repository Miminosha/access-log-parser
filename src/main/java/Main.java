public class Main {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        Cuckoo cuckoo = new Cuckoo();
        Parrot parrot = new Parrot("привет");
        sparrow.sing();
        cuckoo.sing();
        parrot.sing();
    }
}