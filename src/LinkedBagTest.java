import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedBagTest {
    public static void main(String[] args) throws Exception {
        
    }

    @Test
    public void test_Add11ToTheBag() {
        LinkedBag<Integer> bag1 = new LinkedBag<Integer>();
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

        Integer[] expected = {11,10,9,8,7,6,5,4,3,2,1};
        Object[] actual = bag1.toArray();

        for(int i = 0; i < expected.length; i++){
            assertEquals("Check if the array have the same value", expected[i], actual[i]);
        }
        
    }

    @Test
    public void test_Union(){
        LinkedBag<String> bag1 = new LinkedBag<String>();
        LinkedBag<String> bag2 = new LinkedBag<String>();
        LinkedBag<String> bag3;
        
            bag1.add("a");
            bag1.add("b");
            bag1.add("c");
            bag2.add("b");
            bag2.add("b");
            bag2.add("d");
            bag2.add("e");
           
        bag3 = (LinkedBag<String>) bag1.union(bag2);
        

        String[] expected = {"b", "b", "d", "e","a", "b", "c"};
        Object[] actual = bag3.toArray();



        for(int i = 0; i < 7; i++){
            assertEquals("Check the first part of the expected match the actual",expected[i], actual[i]);
        }
    }

    @Test
    public void test_Intersept(){
        LinkedBag<Character> bag1 = new LinkedBag<Character>();
        LinkedBag<Character> bag2 = new LinkedBag<Character>();
        LinkedBag<Character> bag3;
        
        bag1.add('a');
        bag1.add('b');
        bag1.add('c');

        bag2.add('b');
        bag2.add('b');
        bag2.add('d');
        bag2.add('e');
        
        bag3 = (LinkedBag<Character>) bag1.intersect(bag2);
        Object[] actual = bag3.toArray();
        char[] expected = {'b'};

        assertEquals("Check the the expected match with actual",expected[0], actual[0]);

        
    }

    @Test
    public void test_Difference(){
        LinkedBag<Character> bag1 = new LinkedBag<Character>();
        LinkedBag<Character> bag2 = new LinkedBag<Character>();
        LinkedBag<Character> bag3;
        
        bag1.add('a');
        bag1.add('b');
        bag1.add('c');

        bag2.add('b');
        bag2.add('b');
        bag2.add('d');
        bag2.add('e');
        
        bag3 = (LinkedBag<Character>) bag1.difference(bag2);
        Object[] actual = bag3.toArray();
        char[] expected = {'a', 'c'};

        for(int i = 0; i < 2; i++){
            assertEquals("Check the the expected match with actual",expected[i], actual[i]);
        }
        

        
    }

}
