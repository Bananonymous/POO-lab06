import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // 1. Define teachers Daniel Rossier (DRE) and Pier Donini (PDO).
        Teacher dre = new Teacher("Rossier", "Daniel", "DRE");
        Teacher pdo = new Teacher("Donini", "Pier", "PDO");

        // 2. Define three lessons of the OOP course (PDO), one lesson for SYE (DRE), and one TIC lesson (independent project).
        Lesson oop1 = new Lesson("OOP", 3, 6, 2, "H02", pdo);
        Lesson oop2 = new Lesson("OOP", 4, 6, 2, "H02", pdo);
        Lesson oop3 = new Lesson("OOP", 4, 8, 2, "H02", pdo);
        Lesson sye1 = new Lesson("SYE", 1, 1, 2, "G01", dre);
        Lesson sye2 = new Lesson("SYE", 4, 3, 2, "A09", dre);
        Lesson tic1 = new Lesson("TIC", 2, 10, 1, "F06");

        // 3. Define students John Lennon, Paul Mc Cartney, Ringo Starr, George Harrison, Roger Waters, and David Gilmour.
        Student john = new Student("Lennon", "John", 1234);
        Student paul = new Student("Mc Cartney", "Paul", 2341);
        Student ringo = new Student("Starr", "Ringo", 3241);
        Student george = new Student("Harrison", "George", 4321);
        Student roger = new Student("Waters", "Roger", 1324);
        Student david = new Student("Gilmour", "David", 4312);

        // 4. Define an IL6-1 group containing the first four students and an SI6-1 group containing the last two.
        Group il = new Group(1, "IL", 6, Arrays.asList(john, paul, ringo, george));
        Group si = new Group(1, "SI", 6, Arrays.asList(roger, david));

        // 5. Assign all existing lessons to the IL6-1 group. Assign only OOP lessons to the SI6-1 group.
        il.defineLessons(Arrays.asList(oop1, oop2, oop3, sye1, sye2, tic1));
        si.defineLessons(Arrays.asList(oop1, oop2, oop3));

        // 6. Create an array with all persons and display elements using dynamic binding.
        System.out.println("-- Members of the school");
        for (Person p : new Person[]{pdo, dre, john, paul, ringo, george, roger, david}) {
            System.out.println(p);
        }
        System.out.println();

        // 7. Display information about IL6-1 group (name, number of students, schedule).
        System.out.println(il.schedule());

        // 8. Display schedule of teacher PDO.
        System.out.println(pdo.schedule());
    }
}
