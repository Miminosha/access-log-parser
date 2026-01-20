import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Иван");
        Student s2 = new Student("Анна", new int[]{5, 5, 4});
        System.out.println(s1);
        System.out.println(s2);
        s2.addGrade(3);
        System.out.println(Arrays.toString(s2.getGrades()));
    }
}