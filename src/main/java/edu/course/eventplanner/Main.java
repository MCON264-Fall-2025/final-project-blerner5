package edu.course.eventplanner;

import edu.course.eventplanner.model.Guest;
import edu.course.eventplanner.model.Task;
import edu.course.eventplanner.model.Venue;
import edu.course.eventplanner.service.GuestListManager;
import edu.course.eventplanner.service.SeatingPlanner;
import edu.course.eventplanner.service.TaskManager;
import edu.course.eventplanner.service.VenueSelector;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        GuestListManager guestList = new GuestListManager();
        TaskManager taskManager = new TaskManager();
        List<Venue> venues = null;
        Venue selectedVenue = null;
        boolean finished = false;
        while (!finished) {
            System.out.println("Event Planner Menu:");
            System.out.println("1. Load sample data");
            System.out.println("2. Add guest");
            System.out.println("3. Remove guest");
            System.out.println("4. Select venue");
            System.out.println("5. Generate seating chart");
            System.out.println("6. Add preparation task");
            System.out.println("7. Execute next task");
            System.out.println("8. Undo last task");
            System.out.println("9. Print event summary");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String answer = keyboard.nextLine();
            switch (answer) {
                case "1":
                    venues = List.of();
                    System.out.println("Sample data cleared.");
                    break;
                case "2":
                    System.out.print("Enter guest name: ");
                    String name = keyboard.nextLine();
                    System.out.print("Enter guest description: ");
                    String description = keyboard.nextLine();
                    guestList.addGuest(new Guest(name, description));
                    System.out.println("Guest added.");
                    break;
                case "3":
                    System.out.print("Enter guest name to remove: ");
                    String removeName = keyboard.nextLine();
                    if (guestList.removeGuest(removeName)) {
                        System.out.println("Guest removed.");
                    } else {
                        System.out.println("Guest not found.");
                    }
                    break;
                case "4":
                    if (venues == null || venues.isEmpty()) {
                        System.out.println("Load sample data first.");
                        break;
                    }
                    System.out.print("Enter event budget: ");
                    double budget = Double.parseDouble(keyboard.nextLine());
                    int count = guestList.getGuestCount();
                    VenueSelector selector = new VenueSelector();
                    selectedVenue = selector.selectVenue(venues, count, budget);
                    if (selectedVenue != null) {
                        System.out.println("Selected venue: " + selectedVenue.getName());
                    } else {
                        System.out.println("No venue fits the requirements.");
                    }
                    break;
                case "5":
                    if (selectedVenue == null) {
                        System.out.println("Select a venue first.");
                    } else {
                        SeatingPlanner planner = new SeatingPlanner(selectedVenue);
                        Map<Integer, List<Guest>> seating = planner.generateSeating(guestList.getAllGuests());
                        System.out.println("Seating chart generated:");
                        for (Integer table : seating.keySet()) {
                            System.out.println("Table " + table + ": " + seating.get(table).size() + " guests");
                        }
                    }
                    break;
                case "6":
                    System.out.print("Enter task description: ");
                    String taskDesc = keyboard.nextLine();
                    taskManager.addTask(new Task(taskDesc));
                    System.out.println("Task added.");
                    break;
                case "7":
                    Task executed = taskManager.executeNextTask();
                    if (executed == null) {
                        System.out.println("No tasks to execute.");
                    } else {
                        System.out.println("Executed: " + executed.getDescription());
                    }
                    break;
                case "8":
                    Task undone = taskManager.undoLastTask();
                    if (undone == null) {
                        System.out.println("No tasks to undo.");
                    } else {
                        System.out.println("Undone: " + undone.getDescription());
                    }
                    break;
                case "9":
                    System.out.println("Event Planner Summary");
                    System.out.println("Guests: " + guestList.getGuestCount());
                    System.out.println("Venue: " + (selectedVenue == null ? "None" : selectedVenue.getName()));
                    System.out.println("Remaining tasks: " + taskManager.remainingTaskCount());
                    break;
                case "0":
                    System.out.println("Event Planner Menu Exiting Now!");
                    finished = true;
                    break;
                default:
                    System.out.println("Please enter a valid event planner menu option.");
            }
        }
        keyboard.close();
    }
}