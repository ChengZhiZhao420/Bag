
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayBagTest {
    public static void main(String[] args) throws Exception {
        
    }

    @Test
    public void test_Add11ToTheBag() {
        ResizeableArrayBag<Integer> bag1 = new ResizeableArrayBag<Integer>();
        bag1.add(1);
        bag1.add(2);
        bag1.add(3);
        bag1.add(4);
        bag1.add(5);
        bag1.add(6);
        bag1.add(7);
        bag1.add(8);
        bag1.add(9);
        bag1.add(10);
        bag1.add(11);

        Integer[] expected = {1,2,3,4,5,6,7,8,9,10,11};
        Object[] actual = bag1.toArray();

        for(int i = 0; i < expected.length; i++){
            assertEquals("Check if the array have the same value", expected[i], actual[i]);
        }
        
    }

    @Test
    public void test_Union(){
        ResizeableArrayBag<Integer> bag1 = new ResizeableArrayBag<Integer>();
        ResizeableArrayBag<Integer> bag2 = new ResizeableArrayBag<Integer>();
        ResizeableArrayBag<Integer> bag3;
        int j = 0;
        int k = 0;


        for(int i = 0; i < 10; i++){
            bag1.add(j);
            bag2.add(j);
            j++;
        }
        bag3 = (ResizeableArrayBag<Integer>) bag1.union(bag2);
        
        Object[] expected1 = bag1.toArray();
        Object[] expected2 = bag2.toArray();
        Object[] actual = bag3.toArray();


        for(int i = 0; i < 10; i++){
            assertEquals("Check the first part of the expected match the actual",expected1[i], actual[k]);
            k++;
            if(k >= bag1.getCurrentSize() && k < 10){
                assertEquals("Check the first part of the expected match the actual",expected2[i], actual[k]);
            }
        }
    }

    @Test
    public void test_Intersept(){
        ResizeableArrayBag<Character> bag1 = new ResizeableArrayBag<Character>();
        ResizeableArrayBag<Character> bag2 = new ResizeableArrayBag<Character>();
        ResizeableArrayBag<Character> bag3;
        
        bag1.add('a');
        bag1.add('b');
        bag1.add('c');

        bag2.add('b');
        bag2.add('b');
        bag2.add('d');
        bag2.add('e');
        
        bag3 = (ResizeableArrayBag<Character>) bag1.intersect(bag2);
        Object[] actual = bag3.toArray();
        char[] expected = {'b'};

        assertEquals("Check the the expected match with actual",expected[0], actual[0]);

        
    }

    @Test
    public void test_Difference(){
        ResizeableArrayBag<Character> bag1 = new ResizeableArrayBag<Character>();
        ResizeableArrayBag<Character> bag2 = new ResizeableArrayBag<Character>();
        ResizeableArrayBag<Character> bag3;
        
        bag1.add('a');
        bag1.add('b');
        bag1.add('c');

        bag2.add('b');
        bag2.add('b');
        bag2.add('d');
        bag2.add('e');
        
        bag3 = (ResizeableArrayBag<Character>) bag1.difference(bag2);
        Object[] actual = bag3.toArray();
        char[] expected = {'a', 'c'};

        for(int i = 0; i < 2; i++){
            assertEquals("Check the the expected match with actual",expected[i], actual[i]);
        }
        

        
    }


}
