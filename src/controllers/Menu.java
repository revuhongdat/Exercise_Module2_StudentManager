package controllers;

import services.ClassesManager;
import services.ComparatorAge;
import services.ComparatorAvgPoint;
import services.StudentsManager;

import java.util.Scanner;

public class Menu {
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        ClassesManager classesManager = new ClassesManager();
        StudentsManager studentsManager = new StudentsManager();
        ComparatorAvgPoint comparatorAvgPoint = new ComparatorAvgPoint();
        ComparatorAge comparatorAge = new ComparatorAge();

        do {
            System.out.println("MENU:");
            System.out.println("1. Menu Classes");
            System.out.println("2. Menu Student");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuClasses(classesManager, scanner);
                    break;
                case 2:
                    menuStudent(studentsManager, scanner, classesManager, comparatorAge, comparatorAvgPoint);
                    break;
                case 0:
                    System.exit(0);

            }
        } while (true);
    }

    private void menuClasses(ClassesManager classesManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("Menu Classes:");
            System.out.println("1. Create classes");
            System.out.println("2. Edit classes");
            System.out.println("3. Display classes");
            System.out.println("0. Back to menu");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    classesManager.createClasses();
                    break;
                case 2:
                    classesManager.editClasses();
                    break;
                case 3:
                    classesManager.displayClasses();
                    break;
            }

        } while (choice != 0);
    }

    private void menuStudent(StudentsManager studentsManager,
                             Scanner scanner, ClassesManager classesManager,
                             ComparatorAge comparatorAge, ComparatorAvgPoint comparatorAvgPoint) {
        int choice;
        do {
            System.out.println("Menu Student");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Find Student by name");
            System.out.println("5. Student sort by age");
            System.out.println("6. Student sort by point");
            System.out.println("7. Display student by ID");
            System.out.println("8. Display all student");
            System.out.println("0. Back to menu");
            System.out.println("Enter your choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentsManager.addStudent(classesManager);
                    break;
                case 2:
                    studentsManager.deleteStudent();
                    break;
                case 3:
                    studentsManager.editStudent(classesManager);
                    break;
                case 4:
                    studentsManager.findStudent();
                    break;
                case 5:
                    studentsManager.sortByAge(comparatorAge);
                    break;
                case 6:
                    studentsManager.sortByAvgPoint(comparatorAvgPoint);
                    break;
                case 7:
                    studentsManager.displayStudentById();
                    break;
                case 8:
                    studentsManager.displayStudent();
                    break;
            }
        } while (choice != 0);
    }
}
