//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        // checking the begining args
        if (args.length == 0) {
            System.out.println("No ARGS! Please provide at least one argument!");
            System.out.println("please follow the options insted");
            System.out.println("  to load the data: l");
            System.out.println("  to show the data: s");
            System.out.println("  to add something in the txt file: +Name");
            System.out.println("  to search for something in the txt: ?Name");
            System.out.println("  to count No of words: c");
            System.out.println("  to update the employee: uName");
            System.out.println("  to delete he employee: dName");
            return;
        }

        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(Constants.EMPLOYEE_FILE)));
                String[] employees = reader.readLine().split(",");
                for (String emp : employees) {
                    System.out.println(emp);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE)));
                String line = reader.readLine();
                System.out.println(line);
                String[] employees = line.split(",");
                Random random = new Random();
                int randomIndex = random.nextInt(employees.length);
                System.out.println(employees[randomIndex]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(Constants.EMPLOYEE_FILE, true));
                writer.write(", " + args[0].substring(1));
                writer.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE)));
                String[] employees = reader.readLine().split(",");
                String searchName = args[0].substring(1);

                int i;
                for (i = 0; i < employees.length; i++) {
                    if (employees[i].equals(searchName)) {
                        System.out.println("Employee found!");
                        break;
                    }
                }

                if (i == employees.length) {
                    System.out.println("Employee not found!");
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE)));
                String line = reader.readLine();
                int count = 0;

                if (line != null && !line.isEmpty()) {
                    String[] words = line.trim().split("\\s+");
                    count = words.length;
                }

                System.out.println(count + " word(s) found " + line.length());
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE)));
                String[] employees = reader.readLine().split(",");
                String nameToUpdate = args[0].substring(1);
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(nameToUpdate)) {
                        employees[i] = "Updated";
                    }
                }
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(Constants.EMPLOYEE_FILE));
                writer.write(String.join(",", employees));
                writer.close();
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE)));
                String[] employees = reader.readLine().split(",");
                String nameToDelete = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(nameToDelete);
                BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.EMPLOYEE_FILE));
                writer.write(String.join(",", employeeList));
                writer.close();
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        }
    }
}