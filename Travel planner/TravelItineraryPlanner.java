import java.util.ArrayList;
import java.util.Scanner;

class TravelDestination {
    String destination;
    String startDate;
    String endDate;
    double accommodationBudget;
    double transportBudget;
    double foodBudget;
    double miscBudget;

    public TravelDestination(String destination, String startDate, String endDate, 
                             double accommodationBudget, double transportBudget, 
                             double foodBudget, double miscBudget) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.accommodationBudget = accommodationBudget;
        this.transportBudget = transportBudget;
        this.foodBudget = foodBudget;
        this.miscBudget = miscBudget;
    }

    // Calculate the total budget for this destination
    public double getTotalBudget() {
        return accommodationBudget + transportBudget + foodBudget + miscBudget;
    }

    @Override
    public String toString() {
        return "Destination: " + destination +
               "\nStart Date: " + startDate +
               "\nEnd Date: " + endDate +
               "\nAccommodation Budget: $" + accommodationBudget +
               "\nTransport Budget: $" + transportBudget +
               "\nFood Budget: $" + foodBudget +
               "\nMiscellaneous Budget: $" + miscBudget +
               "\nTotal Budget: $" + getTotalBudget();
    }
}

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TravelDestination> itinerary = new ArrayList<>();
        boolean exit = false;

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a destination");
            System.out.println("2. View itinerary");
            System.out.println("3. Calculate total budget");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    boolean addMoreDestinations = true;
                    while (addMoreDestinations) {
                        System.out.print("Enter destination: ");
                        String destination = scanner.nextLine();
                        System.out.print("Enter start date (YYYY-MM-DD): ");
                        String startDate = scanner.nextLine();
                        System.out.print("Enter end date (YYYY-MM-DD): ");
                        String endDate = scanner.nextLine();

                        System.out.print("Enter accommodation budget: ");
                        double accommodationBudget = scanner.nextDouble();

                        System.out.print("Enter transport budget: ");
                        double transportBudget = scanner.nextDouble();

                        System.out.print("Enter food budget: ");
                        double foodBudget = scanner.nextDouble();

                        System.out.print("Enter miscellaneous expenses budget: ");
                        double miscBudget = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline

                        itinerary.add(new TravelDestination(destination, startDate, endDate, 
                                                           accommodationBudget, transportBudget, 
                                                           foodBudget, miscBudget));
                        System.out.println("Destination added successfully!");

                        // Ask if the user wants to add another destination
                        System.out.print("Would you like to add another destination? (yes/no): ");
                        String response = scanner.nextLine();
                        if (!response.equalsIgnoreCase("yes")) {
                            addMoreDestinations = false;
                        }
                    }
                    break;

                case 2:
                    if (itinerary.isEmpty()) {
                        System.out.println("No destinations added yet.");
                    } else {
                        System.out.println("\nYour Travel Itinerary:");
                        for (int i = 0; i < itinerary.size(); i++) {
                            System.out.println("\nDestination #" + (i + 1));
                            System.out.println(itinerary.get(i));
                        }
                    }
                    break;

                case 3:
                    double totalBudget = calculateTotalBudget(itinerary);
                    System.out.println("Total estimated budget for all destinations: $" + totalBudget);
                    break;

                case 4:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Safe travels!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        scanner.close();
    }

    // Method to calculate the total budget for all destinations
    private static double calculateTotalBudget(ArrayList<TravelDestination> itinerary) {
        double total = 0;
        for (TravelDestination destination : itinerary) {
            total += destination.getTotalBudget();
        }
        return total;
    }
}
