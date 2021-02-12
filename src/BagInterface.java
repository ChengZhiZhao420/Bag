public interface BagInterface<T>{
    /**
     * Gets the current number of entries in this bag.
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize();

    /**
     * Sees whether this bag is full
     * @return True if the bag is full
     */
    public boolean isFull();

    /**
     * Sees whether this bag is empty
     * @return True if the bag is empty
     */
    public boolean isEmpty();

    
    public boolean add(T newEntry);
    public T remove();
    public T remove(T newEntry);
    public void clear();
    public int getFrequencyOf(T newEntry);
    public boolean contain(T newEntry);
    public T[] toArray();
    public boolean isArrayFull();
	public T union(BagInterface<T> others);
    public T intersect(BagInterface<T> others);
    public T difference(BagInterface<T> others);
}
