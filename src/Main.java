import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("The first example. MyArrayList<String> sorting: ");

        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Hello");
        myArrayList.add("World");
        myArrayList.add("Java");
        myArrayList.add("Python");
        myArrayList.add("C");
        myArrayList.add("Java");


        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i) + " ");
        }

        QuickSort<String> sortEx1 = new QuickSort<>();
        sortEx1.quickSort(myArrayList, 0, 5);

        System.out.println("After sorting: ");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i) + " ");
        }

        System.out.println("The second example. ArrayList<Students> sorting: ");

        Student st1 = new Student("Ivan", 'm', 20, 3, 8.3);
        Student st2 = new Student("Masha", 'f', 21, 3, 9.8);
        Student st3 = new Student("Petr", 'm', 19, 1, 3.3);
        Student st4 = new Student("Kira", 'f', 18, 1, 7.8);
        Student st5 = new Student("Georgiy", 'm', 18, 1, 8.9);
        Student st6 = new Student("Olga", 'f', 18, 1, 7.8);
        Student st7 = new Student("Oleg", 'm', 18, 1, 8.9);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);
        studentList.add(st6);
        studentList.add(st7);

        System.out.println(studentList);

        QuickSort<Student> sortEx2 = new QuickSort<>();
        sortEx2.quickSort(studentList, 0, studentList.size() - 1, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        System.out.println("After sorting: ");
        System.out.println(studentList);


    }
}

/**
 * Example of class
 */
class Student implements Comparable<Student> {

    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(final String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sex == student.sex &&
                age == student.age &&
                course == student.course &&
                Double.compare(student.avgGrade, avgGrade) == 0 &&
                Objects.equals(name, student.name);
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public String name() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public char sex() {
        return sex;
    }

    public Student setSex(char sex) {
        this.sex = sex;
        return this;
    }

    public int age() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public int course() {
        return course;
    }

    public Student setCourse(int course) {
        this.course = course;
        return this;
    }

    public double avgGrade() {
        return avgGrade;
    }

    public Student setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
        return this;
    }
}





