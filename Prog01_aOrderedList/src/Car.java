/**
* Car class: Constructor for Car object containing get methods and compareTo
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author Mark Plaisance
* @since 3/17/2024
*
*/
public class Car {

    private String make; //Represents make of a car
    private int year; //Represents make of a year
    private int price; //Represents make of a price

    
    
    /**
	* Car: Initializes Car object with given make/year/price
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public Car(String make, int year, int price) {
        this.make = make; //Specific instance of make
        this.year = year; //Specific instance of year
        this.price = price; //Specific instance of price
    }

    
    /**
	* getMake: Returns the make of the car
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public String getMake() {
        return make;
    }

    
    /**
	* getYear: Returns the year of the car
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public int getYear() {
        return year;
    }

    
    /**
	* getPrice: Returns the price of the car
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public int getPrice() {
        return price;
    }

    
    /**
	* compareTo: Compares two cars based on their make and year
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public int compareTo(Car other) {
        if (this.make.compareTo(other.getMake()) == 0) {
            return Integer.compare(this.year, other.getYear());
        } else {
            return this.make.compareTo(other.getMake());
        }
    }

    
    /**
	* toString: returns a string of make/year/price
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public String toString() {
        return "Make: " + make + ", Year: " + year + ", Price: " + price + ";";
    }
}