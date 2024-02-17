import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Course {
    private String courseName;
    private int marks;

    public Course(String courseName, int marks) {
        this.courseName = courseName;
        this.marks = marks;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMarks() {
        return marks;
    }
}

class Student {
    private String name;
    private String program;
    private String department;
    private List<Course> courses;

    public Student(String name, String program, String department) {
        this.name = name;
        this.program = program;
        this.department = department;
        this.courses = new ArrayList<>();
    }

    public void addCourse(String courseName, int marks) {
        courses.add(new Course(courseName, marks));
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public String getDepartment() {
        return department;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Map<String, Integer> getCoursesWithMarksBelow40() {
        Map<String, Integer> coursesBelow40 = new HashMap<>();
        for (Course course : courses) {
            if (course.getMarks() < 40) {
                coursesBelow40.put(course.getCourseName(), course.getMarks());
            }
        }
        return coursesBelow40;
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John Doe", "Computer Science", "Engineering");
        student1.addCourse("Mathematics", 75);
        student1.addCourse("Physics", 32);
        student1.addCourse("Programming", 45);

        // Retrieving student information
        System.out.println("Student Name: " + student1.getName());
        System.out.println("Program: " + student1.getProgram());
        System.out.println("Department: " + student1.getDepartment());

        // Retrieving courses where student scored less than 40
        Map<String, Integer> coursesBelow40 = student1.getCoursesWithMarksBelow40();
        if (!coursesBelow40.isEmpty()) {
            System.out.println("Courses with Marks below 40:");
            for (Map.Entry<String, Integer> entry : coursesBelow40.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else {
            System.out.println("No courses with marks below 40.");
        }
    }
}