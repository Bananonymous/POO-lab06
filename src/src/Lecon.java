// Lesson.java

import java.util.Collection;

class Lesson {

    private enum Days {Mon, Tue, Wed, Thu, Fri}

    private static final String[] HOURS = {"8:30", "9:15", "10:25", "11:15", "12:00", "13:15",
            "14:00", "14:55", "15:45", "16:35", "17:20"};

    private static final char COL_SEP = '|', LINE_SEP = '-';

    private static final int FIRST_COL_WIDTH = 5,
            SUBJECT_INITIALS = 5, ROOM_INITIALS = 3,
            COL_WIDTH_DAYS = 2 + Teacher.INITIALS_COUNT + SUBJECT_INITIALS + ROOM_INITIALS;

    private static final String CELL_BOTTOM = COL_SEP + (LINE_SEP + "").repeat(COL_WIDTH_DAYS),
            EMPTY_CELL = CELL_BOTTOM.replace(LINE_SEP, ' '),
            TIME_SEP = " ".repeat(FIRST_COL_WIDTH),
            COMPLETE_LINE_SEP = TIME_SEP + CELL_BOTTOM.repeat(Days.values().length) + COL_SEP +
                    "\n",
            TIME_FORMAT = "%" + FIRST_COL_WIDTH + "s",
            CELL_FORMAT = COL_SEP + "%-" + SUBJECT_INITIALS + "s %" + ROOM_INITIALS + "s %" +
                    Teacher.INITIALS_COUNT + "s";

    private final String subject;

    private final int dayOfWeek;

    private final int startPeriod;

    private final int duration;

    private final String room;

    private Teacher teacher;

    /**
     * Create a lesson
     *
     * @param subject     the subject of the lesson
     * @param dayOfWeek   the day of the week of the lesson
     * @param startPeriod the start period of the lesson
     * @param duration    the duration of the lesson
     * @param room        the room of the lesson
     */
    public Lesson(String subject, int dayOfWeek, int startPeriod, int duration, String room) {
        if (startPeriod + duration > HOURS.length) {
            throw new RuntimeException("The duration of the lesson exceeds the schedule length");
        }
        if (duration < 1 || startPeriod < 1) {
            throw new RuntimeException("Duration and start period must be > 0");
        }
        if (dayOfWeek < 1 || dayOfWeek > Days.values().length) {
            throw new RuntimeException("The day of the week must be between 1 and " +
                    Days.values().length);
        }
        if (room.length() > ROOM_INITIALS) {
            throw new RuntimeException("Room initials cannot exceed " +
                    ROOM_INITIALS + " characters. Current: " + room.length());
        }
        if (subject.length() > SUBJECT_INITIALS) {
            throw new RuntimeException("Subject initials cannot exceed " +
                    SUBJECT_INITIALS + " characters. Current: " + subject.length());
        }

        this.subject = subject;
        this.dayOfWeek = dayOfWeek;
        this.startPeriod = startPeriod;
        this.duration = duration;
        this.room = room;
    }

    /**
     * Create a lesson
     *
     * @param subject         the subject of the lesson
     * @param dayOfWeek       the day of the week of the lesson
     * @param startPeriod     the start period of the lesson
     * @param duration        the duration of the lesson
     * @param room            the room of the lesson
     * @param assignedTeacher the teacher assigned to the lesson
     */
    public Lesson(String subject, int dayOfWeek, int startPeriod, int duration, String room, Teacher assignedTeacher) {
        this(subject, dayOfWeek, startPeriod, duration, room);
        if (assignedTeacher != null) {
            teacher = assignedTeacher;
            teacher.assignLesson(this);
        }
    }

    /**
     * Create the header of the schedule
     *
     * @return the header of the schedule
     */
    private static StringBuilder createHeader() {
        StringBuilder header = new StringBuilder(TIME_SEP);
        for (Days day : Days.values()) {
            header.append(String.format(COL_SEP + " %-" + (COL_WIDTH_DAYS - 1) + "s",
                    day.name()));
        }
        return header.append(COL_SEP + "\n").append(COMPLETE_LINE_SEP);
    }

    /**
     * Create a cell of the schedule
     *
     * @param rowIndex the index of the row
     * @param lesson   the lesson to display
     * @return the cell of the schedule
     */
    private static String createCell(int rowIndex, Lesson lesson) {
        boolean isEvenRow = rowIndex % 2 == 0;

        if (lesson == null) {
            if (isEvenRow) {
                return EMPTY_CELL;
            }
            return CELL_BOTTOM;
        }
        int currentPeriod = rowIndex / 2 - lesson.startPeriod + 2;

        if (currentPeriod == 1) {
            if (isEvenRow) {
                return String.format(CELL_FORMAT, lesson.subject, lesson.room,
                        lesson.teacher != null ? lesson.teacher.abbreviation() : "");
            }
            if (lesson.duration > 1) {
                return EMPTY_CELL;
            }
        }
        if (currentPeriod < lesson.duration || isEvenRow) {
            return EMPTY_CELL;
        }
        return CELL_BOTTOM;
    }

    /**
     * Create the schedule
     *
     * @param lessons the lessons to display
     * @return the schedule
     */
    public static String schedule(Collection<Lesson> lessons) {
        Lesson[][] lessonGrid = new Lesson[HOURS.length][Days.values().length];
        for (Lesson lesson : lessons) {
            for (int i = 0; i < lesson.duration; ++i) {
                lessonGrid[lesson.startPeriod - 1 + i][lesson.dayOfWeek - 1] = lesson;
            }
        }

        StringBuilder schedule = new StringBuilder(createHeader());
        for (int i = 0; i < (HOURS.length * 2) - 1; ++i) {
            schedule.append(i % 2 != 0 ? TIME_SEP : String.format(TIME_FORMAT, HOURS[i / 2]));
            for (int j = 0; j < Days.values().length; ++j) {
                schedule.append(createCell(i, lessonGrid[i / 2][j]));
            }
            schedule.append(COL_SEP + "\n");
        }
        return schedule.append(COMPLETE_LINE_SEP).toString();
    }
}
