package htu.edu.assingment;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeTest {


    public static void main(String[] args) throws IOException {
        start();
    }

    static void start() throws IOException {
        System.out.println("Enter add to add employee \n" +
                "update to edit employee \n" +
                "delete to remove employee \n" +
                "search to search for employee \n" +
                "exit to close");
        switch (new Scanner(System.in).next().toLowerCase()) {
            case "add":
                EmployeeManagement.add();
                break;
            case "update":
                EmployeeManagement.update();
                break;
            case "delete":
                EmployeeManagement.delete();
                break;
            case "search":
                EmployeeManagement.search();
            case "exit":
                break;
            default:
                System.err.println("Invalid input try again");
        }
        start();
    }
}
