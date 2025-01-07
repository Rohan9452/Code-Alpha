import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a hotel room
class Room {
    int roomNumber;
    String category; // e.g., Single, Double, Suite
    double pricePerNight;
    boolean isBooked;

    public Room(int roomNumber, String category, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber +
               "\nCategory: " + category +
               "\nPrice per Night: $" + pricePerNight +
               "\nStatus: " + (isBooked ? "Booked" : "Available");
    }
}

// Class to represent a reservation
class Reservation {
    String customerName;
    Room room;
    int numberOfNights;
    double totalCost;

    public Reservation(String customerName, Room room, int numberOfNights) {
        this.customerName = customerName;
        this.room = room;
        this.numberOfNights = numberOfNights;
        this.totalCost = room.pricePerNight * numberOfNights;
    }

    @Override
    public String toString() {
        return "Customer Name: " + customerName +
               "\nRoom Number: " + room.roomNumber +
               "\nCategory: " + room.category +
               "\nNumber of Nights: " + numberOfNights +
               "\nTotal Cost: $" + totalCost;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();

        // Initialize rooms
        rooms.add(new Room(101, "Single", 100));
        rooms.add(new Room(102, "Double", 150));
        rooms.add(new Room(103, "Suite", 300));
        rooms.add(new Room(104, "Single", 100));
        rooms.add(new Room(105, "Double", 150));

        boolean exit = false;

        System.out.println("Welcome to the Hotel Reservation System!");

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View reservations");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // View available rooms
                    System.out.println("\nAvailable Rooms:");
                    for (Room room : rooms) {
                        if (!room.isBooked) {
                            System.out.println(room);
                            System.out.println("----------------------------");
                        }
                    }
                    break;

                case 2:
                    // Make a reservation
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();

                    System.out.println("Available Rooms:");
                    for (Room room : rooms) {
                        if (!room.isBooked) {
                            System.out.println(room);
                            System.out.println("----------------------------");
                        }
                    }

                    System.out.print("Enter the room number you want to book: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Room selectedRoom = null;
                    for (Room room : rooms) {
                        if (room.roomNumber == roomNumber && !room.isBooked) {
                            selectedRoom = room;
                            break;
                        }
                    }

                    if (selectedRoom == null) {
                        System.out.println("Invalid room number or room is already booked!");
                        break;
                    }

                    System.out.print("Enter the number of nights: ");
                    int numberOfNights = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Create a reservation
                    selectedRoom.isBooked = true;
                    Reservation reservation = new Reservation(customerName, selectedRoom, numberOfNights);
                    reservations.add(reservation);

                    System.out.println("Reservation successful!");
                    System.out.println(reservation);
                    break;

                case 3:
                    // View reservations
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations found.");
                    } else {
                        System.out.println("\nReservations:");
                        for (Reservation reservationDetails : reservations) {
                            System.out.println(reservationDetails);
                            System.out.println("----------------------------");
                        }
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
