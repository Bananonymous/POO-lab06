// Person.java

import java.util.ArrayList;

class Person {

    private final String lastName;

    private final String firstName;

    /**
     * Create a person
     *
     * @param lastName  the last name of the person
     * @param firstName the first name of the person
     */
    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    /**
     * Get the last name of the person
     *
     * @return the last name of the person
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

class Student extends Person {

    private final int id;

    private Group group;

    /**
     * Create a student
     *
     * @param lastName  the last name of the student
     * @param firstName the first name of the student
     * @param id        the ID of the student
     */
    public Student(String lastName, String firstName, int id) {
        super(lastName, firstName);
        if (id < 0) {
            throw new RuntimeException("ID cannot be < 0");
        }
        this.id = id;
    }

    /**
     * Set the group of the student
     *
     * @param group the group of the student
     */
    void setGroup(Group group) {
        this.group = group;
    }

    /**
     * Get the group of the student
     *
     * @return the group of the student
     */
    @Override
    public String toString() {
        return "Student " + super.toString() + " (#" + id + ") - " + group.name();
    }
}

class Teacher extends Person {
    private final String abbreviation;

    private final ArrayList<Lesson> lessons = new ArrayList<>();

    static final int INITIALS_COUNT = 3;

    /**
     * Create a teacher
     *
     * @param lastName     the last name of the teacher
     * @param firstName    the first name of the teacher
     * @param abbreviation the abbreviation of the teacher
     */
    public Teacher(String lastName, String firstName, String abbreviation) {
        super(lastName, firstName);
        this.abbreviation = abbreviation;
    }

    /**
     * Assign a lesson to the teacher
     *
     * @param lesson the lesson to assign
     */
    void assignLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    /**
     * Get the abbreviation of the teacher
     *
     * @return the abbreviation of the teacher
     */
    public String abbreviation() {
        return abbreviation;
    }

    /**
     * Get the schedule of the teacher
     *
     * @return the schedule of the teacher
     */
    @Override
    public String toString() {
        return "Teacher " + super.toString() + " (" + abbreviation + ")";
    }


    /**
     * Get the schedule of the teacher
     *
     * @return the schedule of the teacher
     */
    public String schedule() {
        return "-- Schedule " + this + "\n" + Lesson.schedule(lessons);
    }
}
