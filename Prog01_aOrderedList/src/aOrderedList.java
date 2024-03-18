import java.util.Arrays;


/**
* aOrderedList: Contains the methods used by Prog01_aOrderedList to do the operations needed to sort/add/delete cars in the list.
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author Mark Plaisance
* @since 3/17/2024
*
*/
public class aOrderedList {

    private final int SIZEINCREMENTS = 20; //Increment size for the ordered list
    private Car[] oList; //The ordered list itself
    private int listSize; //Size of the ordered list
    private int numObjects; //Number of objects in the ordered list
    private int curr; //Index of current car

    
    /**
	* aOrderedList: Initializes an ordered list of cars
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public aOrderedList() {
        numObjects = 0;
        listSize = SIZEINCREMENTS;
        oList = new Car[listSize];
        curr = -1;
    }

    
    /**
	* add: Adds a new car to the list. If the array is full, it increases its size. Moves cars to make space and keep correct sorting
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public void add(Car newCar) {
        //If the array is full, increase its size
        if (numObjects == listSize) {
            increaseSize();
        }

        //Find the correct position to keep sorted
        int insertIndex = 0;
        while (insertIndex < numObjects && oList[insertIndex].compareTo(newCar) < 0) {
            insertIndex++;
        }

        //Move cars to make space for newCar
        for (int i = numObjects; i > insertIndex; i--) {
            oList[i] = oList[i - 1];
        }

        //Insert newCar at the correct position
        oList[insertIndex] = newCar;
        numObjects++;
    }

    
    /**
	* get: Gets a car at a specific index. If it is in bounds, returns the car at that index, else it returns nulls for IndexOutOfBounds
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public Car get(int index) {
        if (index >= 0 && index < numObjects) {
            return oList[index];
        }
        return null; //Index out of bounds
    }

    
    /**
	* size: Returns the number of cars in the list
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public int size() {
        return numObjects;
    }

    
    /**
	* remove: Removes car with specific make and year
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public void remove(String make, int year) {
        int index = 0;
        while (index < numObjects) {
            if (oList[index].getMake().equals(make) && oList[index].getYear() == year) {
                for (int i = index; i < numObjects - 1; i++) {
                    oList[i] = oList[i + 1];
                }
                oList[numObjects - 1] = null; // Remove reference to the last element
                numObjects--;
                return; // Exit the method after the first occurrence is removed
            }
            index++;
        }
    }
    
    
    /**
	* reset: Resets the iterator's position to the beginning of the list
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    // Public Method to Reset Iterator Parameters
    public void reset() {
        curr = -1;
    }

    
    /**
	* next: Gets next car in the iteration. If there are more cars, it returns true, else returns null
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    // Public Method to Get the Next Car Object in the Iteration
    public Car next() {
        if (hasNext()) {
            curr++;
            return oList[curr];
        }
        return null;
    }

    
    /**
	* hasNext: Checks to make sure there are more cars to iterate through
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    public boolean hasNext() {
        return curr < numObjects - 1;
    }

    
    /**
	* increaseSize: Increases the size of the array when it becomes full
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Mark Plaisance
	* @since 3/17/2024
	*
	*/
    // Private Method to Increase the Size of the Array
    private void increaseSize() {
        oList = Arrays.copyOf(oList, listSize + SIZEINCREMENTS);
        listSize += SIZEINCREMENTS;
    }
}