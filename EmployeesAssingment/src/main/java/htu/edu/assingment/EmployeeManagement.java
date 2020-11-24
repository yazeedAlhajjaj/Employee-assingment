package htu.edu.assingment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeManagement {
    private static final Scanner s = new Scanner(System.in);
    static FileWriter writer;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void add() throws IOException {
        System.out.println("Enter Employee name");
        String name = s.next();
        System.out.println("Enter salary");
        double salary = s.nextDouble();
        System.out.println("Enter Department");
        String dep = s.next();
        new Employees(name, salary, dep);
    }

    public static Employees add(int id) throws IOException {
        System.out.println("Enter Employee name");
        String name = s.next();
        System.out.println("Enter salary");
        double salary = s.nextDouble();
        System.out.println("Enter Department");
        String dep = s.next();
        return new Employees(id, name, salary, dep);
    }

    public static void update() throws IOException {
        System.out.println("Enter ID to edit ");
        int id = s.nextInt();
        if (Employees.map.containsKey(id)) {
            Employees.map.replace(id, add(id));
            write();
        } else {
            System.err.println("Invalid Id \n Try again");
            update();
        }
    }

    public static void delete() throws IOException {
        System.out.println("Enter Employee ID to delete");
        Employees.map.remove(s.nextInt());
        System.out.println("field successfully deleted");
        write();
    }

    static void write() throws IOException {
        writer = new FileWriter("C:\\Users\\yazeed\\OneDrive\\Desktop\\test.txt");
        for (Employees e : Employees.map.values()
        ) {
            writer.write(e.toString() + "\n");
        }
        writer.flush();
    }

    public static void search() {
        System.out.println("Enter 1 to search by ID \n" +
                "2 to search by name");
        if (s.nextInt() == 2) {
            System.out.println("Enter Employee name");
            String name = s.next();
            for (Map.Entry<Integer, Employees> entry : Employees.map.entrySet()
            ) {
                if (entry.getValue().getName().equals(name)) {
                    System.out.println(entry.getValue().toString());
                }
            }
        } else {

            System.out.println(Employees.map.get(s.nextInt()).toString());
        }
    }
}
