public interface BagInterface<T>{
    /**
     * Gets the current number of entries in this bag.
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize();

    /**
     * Sees whether this bag is empty
     * @return True if the bag is empty
     */
    public boolean isEmpty();

    /**
     * add a object to the array
     * @param newEntry pass in the value
     * @return true if the addtion successful, or false if not
     */
    public boolean add(T newEntry);

    /**
     * remove the first object from the array
     * @return the object that got romoved
     */
    public T remove();

    /**
     * remove a given object from the array
     * @param newEntry pass in the object to remove
     * @return the object that got romoved
     */
    public boolean remove(T newEntry);

    /**
     * clear the whole array
     */
    public void clear();

    /**
     * count how many time that the given object has repeated
     * @param newEntry pass in to check the how many does it repeat
     * @return the count number
     */
    public int getFrequencyOf(T newEntry);

    /**
     * to check if the number does exist in the array
     * @param newEntry pass in to check if the array has that number
     * @return true if the array does contain that number, or false if the array does not contain that number
     */
    public boolean contain(T newEntry);

    /**
     * return the array 
     * @return the array
     */
    public T[] toArray();

    /**
     * to combine two collection of datas into a new object
     * @param others object with the same class
     * @return a new object that contain the data from the class
     */
	public BagInterface<T> union(BagInterface<T> others);

    /**
     * to search the intersection of two data sets
     * @param others object with the same class
     * @return a new object of the same class that contain the instersect data.
     */
    public BagInterface<T> intersect(BagInterface<T> others);

    /**
     * to search the difference of two data sets
     * @param others object wotj tje same class
     * @return a new object of the same class that contain the difference data.
     */
    public BagInterface<T> difference(BagInterface<T> others);
}
