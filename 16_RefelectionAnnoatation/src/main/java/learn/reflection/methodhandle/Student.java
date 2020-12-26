package learn.reflection.methodhandle;

public class Student {
    private static int numOfStudent;
    private String name, course;

    public Student(){
        numOfStudent++;
    }

    public Student(String name, String course){
        numOfStudent++;
        this.name = name;
        this.course = course;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    public static int getNumOfStudent() {
        return numOfStudent;
    }

    public static void setNumOfStudent(int numOfStudent) {
        Student.numOfStudent = numOfStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Invoked");
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
