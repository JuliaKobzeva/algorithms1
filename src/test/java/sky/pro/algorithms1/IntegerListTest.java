package sky.pro.algorithms1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerListTest {
    private IntegerList expected;
    private IntegerList actual;

    @BeforeEach
    public void setUp(){
        expected = new IntegerList(10);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        actual = new IntegerList(10);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
    }

    @Test
    public void addString(){
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void addByIndex(){
        expected.add(1, 5);
        actual.add(1, 5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void set(){
        expected.set(1, 5);
        actual.set(1, 5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeByIndex(){
        expected.remove(1);
        actual.remove(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeByString(){
        expected.remove(4);
        actual.remove(4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void contains(){
        assert expected.contains(1);
        assert !expected.contains(100);
    }

    @Test
    public void indexOf(){Assertions.assertEquals(expected.indexOf(4),0);}

    @Test
    public void LastIndexOf(){Assertions.assertEquals(expected.indexOf(4),0);}

    @Test
    public void get(){Assertions.assertEquals(expected.get(0), 1);}

    @Test
    public void equals(){Assertions.assertTrue(expected.equals(actual));}

    @Test
    public void size(){Assertions.assertEquals(expected.size(), actual.size());}

    @Test
    public void isEmpty(){Assertions.assertFalse(expected.isEmpty());}

    @Test
    public void clear(){
        expected.clear();
        Assertions.assertTrue(expected.isEmpty());
    }

    @Test
    public void toArray(){
        Integer[] integer1 = expected.toArray();
        Integer[] integer2 = new Integer[10];
        integer2[0] = 1;
        integer2[1] = 2;
        integer2[2] = 3;
        integer2[3] = 4;
        Assertions.assertEquals(integer1, integer2);
    }

    @Test
    public void toRandomArray(){
        Integer[] integers = new Integer[]{};
        integers = IntegerList.toRandomArray();
        Assertions.assertTrue(integers.length > 0);
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenUseMethodAdd(){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> expected.add(11,15));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodAdd(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.add(8,null));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.add(null));
    }
}
