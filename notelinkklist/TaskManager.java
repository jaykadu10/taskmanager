package notelinkklist;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskManager {

   
    private LinkedList<String> tasks;

   
    public TaskManager() {
        tasks = new LinkedList<>();
    }

    
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

  
    public void deleteTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task index. Please try again.");
        } else {
            String removedTask = tasks.remove(index);
            System.out.println("Task '" + removedTask + "' deleted successfully.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Your Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

  
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the task description: ");
                    String task = scanner.nextLine();
                    taskManager.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter the task number to delete: ");
                    int taskNumber = scanner.nextInt();
                    taskManager.deleteTask(taskNumber - 1);
                    break;
                case 3:
                    taskManager.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
