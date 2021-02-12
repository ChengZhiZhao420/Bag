public class ResizeableArrayBag <T> implements BagInterface<T>{
    private final T[] array;
    private final int INITIAL_SIZE = 20;
    private int numberOfEntry;

    private void resize(){
        
        
    }

    public ResizeableArrayBag(T[] array) {
        this.numberOfEntry = array.length;
        this.array = array;

    }

    @Override
    public T union(BagInterface<T> others) {
        // TODO Auto-generated method stub
        
        return null;
    }

    @Override
    public T intersect(BagInterface<T> others) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T difference(BagInterface<T> others) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getCurrentSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean add(T newEntry) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T remove(T newEntry) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getFrequencyOf(T newEntry) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contain(T newEntry) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isArrayFull() {
        // TODO Auto-generated method stub
        return false;
    }

}
