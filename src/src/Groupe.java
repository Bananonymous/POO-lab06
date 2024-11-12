import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

class Group {
    private int groupNumber;

    private String orientation;

    private int termNumber;

    private List<Student> students;

    private ArrayList<Lesson> lessons;

    /**
     * Create a group
     *
     * @param number      the number of the group
     * @param orientation the orientation of the group
     * @param term        the term of the group
     * @param students    the students of the group
     */
    public Group(int number, String orientation, int term, List<Student> students) {
        this.students = new ArrayList<>();
        this.groupNumber = number;
        this.orientation = orientation;
        this.termNumber = term;
        this.students.addAll(students);
        lessons = new ArrayList<>();
        for (Student student : this.students) {
            student.setGroup(this);
        }
    }

    /**
     * Get the number of students in the group
     *
     * @return the number of students
     */
    public int studentCount() {
        return students.size();
    }

    /**
     * Get the name of the group
     *
     * @return the name of the group
     */
    public String name() {
        return this.orientation + termNumber + "-" + groupNumber;
    }

    /**
     * Define a lesson
     */
    public void defineLesson() {
        System.out.println("Lessons defined!");
    }

    /**
     * Define lessons
     *
     * @param lessons the lessons to define
     */
    public void defineLessons(Collection<Lesson> lessons) {
        this.lessons.addAll(lessons);
    }

    /**
     * Get the schedule of the group
     *
     * @return the schedule of the group
     */
    public String schedule() {
        return "-- Schedule for group " + name() + " (" + studentCount() + " students)\n" +
                Lesson.schedule(lessons);
    }

    /**
     * Get the schedule of the group
     *
     * @return the schedule of the group
     */
    @Override
    public String toString() {
        return "Group " + name() + ": " + studentCount() + " students, schedule: " + schedule();
    }
}
