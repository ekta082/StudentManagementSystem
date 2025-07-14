import java.util.*;

public class Student {
    private String id;
    private String name;
    private String email;
    private List<String> courses;

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courses = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<String> getCourses() { return courses; }

    public void addCourse(String course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public String toFileString() {
        return id + "," + name + "," + email + "," + String.join(";", courses);
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",", 4);
        Student s = new Student(parts[0], parts[1], parts[2]);
        if (parts.length == 4 && !parts[3].isEmpty()) {
            s.courses.addAll(Arrays.asList(parts[3].split(";")));
        }
        return s;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Email: " + email + " | Courses: " + courses;
    }
}

