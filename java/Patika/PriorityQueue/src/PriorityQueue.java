import java.util.*;

class Student implements Comparable<Student>{
    private final int id;
    private final String name;
    private final double cgpa;

    Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getCGPA(){
        return this.cgpa;
    }

    @Override
    public int compareTo(Student student) {
        if(this.cgpa > student.cgpa){
            return -1;
        }else if(this.cgpa < student.cgpa){
            return 1;
        }
        return 0;
    }
}

class Priorities{
    public Queue<Student> getStudents(Queue<Student> students, String event, String name, double cgpa, int id) {
        if (event.equals("ENTER")) {
            students.offer(new Student(id, name, cgpa));
        } else if (event.equals("SERVED")) {
            students.poll();
        }
        return students;
    }
}

public class PriorityQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Priorities priorities = new Priorities();

        Queue<Student> students = new java.util.PriorityQueue<Student>();

        String[] enter;

        int row = scanner.nextInt();
        scanner.nextLine();

        String event, name = null;
        double cgpa = 0;
        int id = 0;
        for (int i = 0; i < row; i++) {
            enter = scanner.nextLine().trim().split(" ");
            event = enter[0];
            if(event.equals("ENTER")){
                name = enter[1];
                cgpa = Double.parseDouble(enter[2]);
                id = Integer.parseInt(enter[3]);
            }
            priorities.getStudents(students, event, name, cgpa, id);
        }

        while (!students.isEmpty()) {
            System.out.println(students.poll().getName());
        }
    }
}

/*
    12
    ENTER John 3.75 50
    ENTER Mark 3.8 24
    ENTER Shafaet 3.7 35
    SERVED
    SERVED
    ENTER Samiha 3.85 36
    SERVED
    ENTER Ashley 3.9 42
    ENTER Maria 3.6 46
    ENTER Anik 3.95 49
    ENTER Dan 3.95 50
    SERVED
 */