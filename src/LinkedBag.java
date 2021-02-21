public class LinkedBag<T> implements BagInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    /**
     * Initialize constructor
     */
    public LinkedBag(){
        firstNode = new Node(null);
        numberOfEntries = 0;
        
    }

    @Override
    /**
     * Gets the current number of entries in this bag.
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize(){
        return numberOfEntries;
        
    }

    @Override
    /**
     * Sees whether this bag is empty
     * @return True if the bag is empty
     */
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    @Override
    /**
     * add a object to the array
     * @param newEntry pass in the value
     * @return true if the addtion successful, or false if not
     */
    public boolean add(T newEntry){
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;

        firstNode = newNode;
        numberOfEntries++;

        return true;
    }

    @Override
    /**
     * remove the first object from the array
     * 
     * @return the object that got romoved
     */
    public T remove(){
        T result = null;

        if(!isEmpty()){
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }

        return result;
    }

    @Override
    /**
     * remove a given object from the array
     * @param newEntry pass in the object to remove
     * @return the object that got romoved
     */
    public boolean remove(T newEntry) {
       boolean result = false;
       Node nodeN = getReferenceTo(newEntry);

       if(nodeN != null){
           nodeN.setData(firstNode.getData());

           firstNode = firstNode.getNextNode();

           numberOfEntries--;

           result = true;
       }

       return result;
    }

    @Override
    /**
     * clear the whole array
     */
    public void clear(){
        while(!isEmpty()){
            remove();
        }
    }

    @Override
    /**
     * count how many time that the given object has repeated
     * @param newEntry pass in to check the how many does it repeat
     * @return the count number
     */
    public int getFrequencyOf(T newEntry){
        int count = 0;
        int frequency = 0;
        Node currentEntry = firstNode;
        
        while((count < numberOfEntries) && (currentEntry != null)){
            if(newEntry.equals(currentEntry.getData())){
                frequency++;
            }
            currentEntry = currentEntry.getNextNode();
            count++;
        }
        return frequency;
    }

    @Override
    /**
     * to check if the number does exist in the array
     * 
     * @param newEntry pass in to check if the array has that number
     * @return true if the array does contain that number, or false if the array
     *         does not contain that number
     */
    public boolean contain(T newEntry){
        boolean found = false;
        Node currentEntry = firstNode;

        while(!found && currentEntry != null){
            if(newEntry.equals(currentEntry.getData())){
                found = true;
            }
            else{
                currentEntry = currentEntry.getNextNode();
            }
        }
        
        return found;
    }

    @Override
    /**
     *  retrieves the entries that are in the bag
     * @return a newly allocated array of all the entries in the bag
     */
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        int j = 0;
        Node currentEntry = firstNode;

        while((j < numberOfEntries) && (currentEntry != null)){
            result[j] = (T) currentEntry.getData();
            j++;
            currentEntry = currentEntry.getNextNode();
        }

        return result;
    }

    @Override
    /**
     * to combine two collection of datas into a new object
     * @param others object with the same class
     * @return a new object that contain the data from the class
     */
	public BagInterface<T> union(BagInterface<T> others) {
        LinkedBag<T> newBag = new LinkedBag<T>();
        T[] tempArray1 = this.toArray();
        T[] tempArray = ((LinkedBag<T>)others).toArray();
        int totalEntries = numberOfEntries + ((LinkedBag<T>)others).getCurrentSize();
        int j = 0;

        if(others instanceof LinkedBag){
            for(int i = 0; i < totalEntries; i++){
                if(i < tempArray1.length){
                    newBag.add(tempArray1[i]);
                }
                else{
                    newBag.add(tempArray[j]);
                    j++;
                }
            }
        }

        return newBag;
    }

    @Override
    /**
     * to search the intersection of two data sets
     * @param others object with the same class
     * @return a new object of the same class that contain the instersect data.
     */
    public BagInterface<T> intersect(BagInterface<T> others) {
        boolean[] counter = new boolean[((LinkedBag<T>) others).getCurrentSize()];
        LinkedBag<T> newBag = new LinkedBag<T>();
        T[] tempBag1 = this.toArray();
        T[] tempBag2 = ((LinkedBag<T>) others).toArray();

        if(others instanceof LinkedBag){
            for (int i = 0; i < numberOfEntries; i++ ){
                for(int j = 0; j < (((LinkedBag<T>) others).getCurrentSize()); j++){
                    if(tempBag1[i].equals(tempBag2[j]) && counter[j] == false){
                        newBag.add(tempBag1[i]);
                        counter[j] = true;
                        break;
                    }
                }
            }
        }
        
        return newBag;


    }

    @Override
    /**
     * to search the difference of two data sets
     * @param others object wotj tje same class
     * @return a new object of the same class that contain the difference data.
     */
    public BagInterface<T> difference(BagInterface<T> others) {
        boolean[] counter = new boolean[((LinkedBag<T>) others).getCurrentSize()];
        LinkedBag<T> newBag = new LinkedBag<T>();
        T[] tempBag1 = this.toArray();
        T[] tempBag2 = ((LinkedBag<T>) others).toArray();
        boolean switchCheck;

        if(others instanceof LinkedBag){
            for (int i = 0; i < numberOfEntries; i++ ){
                switchCheck = true;
                for(int j = 0; j < ((LinkedBag<T>) others).getCurrentSize(); j++){
                    if(tempBag1[i].equals(tempBag2[j]) && counter[j] == false){
                        counter[j] = true;
                        switchCheck = false;
                        break;
                    }
                }
    
                if(switchCheck){
                    newBag.add(tempBag1[i]);
                }
                
            }
    
        }
        
        return newBag;
       
    }

    public class Node{
        private T data;
        private Node next;

        private Node(T data){
            this(data, null);
        }

        private Node(T data, Node nextNode){
            this.data = data;
            this.next = nextNode;
        }

        private T getData(){
            return data;
        }

        private void setData(T newData){
            data = newData;
        }

        private Node getNextNode(){
            return next;
        }

        private void setNextNode(Node nextNode){
            next = nextNode;
        }
    }

    private Node getReferenceTo(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.getData())){
                found = true;
            }
            else
                currentNode = currentNode.getNextNode();
        }

        return currentNode;
    }
    
}
