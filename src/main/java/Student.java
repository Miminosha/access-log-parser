import java.util.Arrays;

public class Student {
    private final String name;
    private int[] grades;

    public Student(String name, int[] grades) {
        this.name = name;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 2 || grades[i] > 5)
                throw new IllegalArgumentException("Grade must be between 2 and 5");
        }

        this.grades = Arrays.copyOf(grades, grades.length);
    }

    public Student(String name) {
        this.name = name;
        this.grades = new int[0];
    }

    public void addGrade(int grade) {

        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Grade must be between 2 and 5");
        }

        int[] newGrades = new int[grades.length + 1];

        for (int i = 0; i < grades.length; i++) {
            newGrades[i] = grades[i];
        }

        newGrades[grades.length] = grade;
        grades = newGrades;
    }

    public int[] getGrades() {
        return Arrays.copyOf(grades, grades.length);
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}
