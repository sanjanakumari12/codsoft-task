import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int enrolled;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
        this.schedule = schedule;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public String getSchedule() {
        return schedule;
    }

    public boolean enrollStudent() {
        if (enrolled < capacity) {
            enrolled++;
            return true;
        } else {
            return false;
        }
    }

    public void removeStudent() {
        if (enrolled > 0) {
            enrolled--;
        }
    }

    public String toString() {
        return "Code: " + code + "\nTitle: " + title + "\nDescription: " + description + "\nCapacity: " + capacity + "\nEnrolled: " + enrolled + "\nSchedule: " + schedule;
    }
}

class Student {
    private int id;
    private String name;
    private List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.enrollStudent();
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.removeStudent();
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nRegistered Courses: " + registeredCourses.size();
    }
}

public class CourseRegistrationSystem {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize courses
        initializeCourses();

        // Display available courses
        displayCourses();

        // Register students
        Student student1 = new Student(1, "John");
        Student student2 = new Student(2, "Alice");

        student1.registerCourse(courses.get(0)); // Register student1 to the first course
        student2.registerCourse(courses.get(1)); // Register student2 to the second course

        // Display updated course information after registration
        displayCourses();

        // Drop a course
        student1.dropCourse(courses.get(0)); // Drop the first course for student1

        // Display updated course information after dropping
        displayCourses();
    }

    private static void initializeCourses() {
        courses.add(new Course("CSC101", "Introduction to Programming", "Basic programming concepts", 20, "Mon-Wed-Fri 9:00-10:30"));
        courses.add(new Course("MAT201", "Calculus I", "Differential and integral calculus", 30, "Tue-Thu 11:00-12:30"));
        // Add more courses here if needed
    }

    private static void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
            System.out.println("------------------------------");
        }
    }
}
