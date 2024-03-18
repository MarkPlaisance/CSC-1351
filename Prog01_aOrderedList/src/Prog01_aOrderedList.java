import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
* Prog01_aOrderedList: Deals with the input/output of the text files and the adding/deleting cars in the list. Uses aOrderedList to perform the needed operations
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author Mark Plaisance
* @since 3/17/2024
*
*/
public class Prog01_aOrderedList {

	
	/**
	* main: Reads input from the given input file, adds or removes cars based specified conditions, and then outputs the number of cars and make/year/price into given output file
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public static void main(String[] args) {
        aOrderedList orderedList = new aOrderedList();

        try {
            Scanner scanner = getInputFile("Enter input filename: ");
            PrintWriter writer = getOutputFile("Enter output filename: ");
            int numCars = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].trim().equals("A")) {
                    String make = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    int price = Integer.parseInt(parts[3].trim());
                    Car car = new Car(make, year, price);
                    orderedList.add(car);
                    numCars++;
                } else if (parts[0].trim().equals("D")) {
                    String make = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    orderedList.remove(make, year);
                    numCars--;
                }
            }
            scanner.close();

            writer.println("Number of cars: " + numCars);
            orderedList.reset();
            while (orderedList.hasNext()) {
                Car car = (Car) orderedList.next();
                writer.println();
                writer.println("Make: " + car.getMake());
                writer.println("Year: " + car.getYear());
                writer.println("Price: $" + car.getPrice());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Program execution canceled.");
        }
    }

    
    /**
	* getInputFile: Prompts user to enter an input file name, and then returns a scanner for the file if it is found. If it is not found, asks the user if they want to try another name or end the program
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public static Scanner getInputFile(String userPrompt) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(userPrompt);
            String filename = scanner.nextLine();
            File file = new File(filename);
            if (file.exists()) {
                try {
                    return new Scanner(file);
                } catch (FileNotFoundException e) {
                    System.out.println("Error: File could not be opened.");
                    throw e;
                }
            } else {
                System.out.println("File specified <" + filename + "> does not exist.");
                System.out.print("Would you like to continue? <Y/N> ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    throw new FileNotFoundException();
                }
            }
        }
    }

    
    /**
	* getOutputFile: Prompts user to enter an output file name, and then returns a PrintWriter for the given file
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public static PrintWriter getOutputFile(String userPrompt) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(userPrompt);
            String filename = scanner.nextLine();
            try {
                return new PrintWriter(filename);
            } catch (FileNotFoundException e) {
                System.out.println("Error: File could not be found.");
                System.out.print("Would you like to continue? <Y/N> ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    throw e;
                }
            }
        }
    }
}