package array;

import com.completedsa.udemy.array.TwoDimensionArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TwoDimensionArrayTest {
    @Test
    public void testTwoDArray() {
        int[][] int2Array = new int[2][2];
        int2Array[0][0] = 1;
        int2Array[0][1] = 2;
        int2Array[1][0] = 3;
        int2Array[1][1] = 4;

        System.out.println(Arrays.deepToString(int2Array));

        //All together
        String[][] s2Array = {{"a", "b"}, {"c", "d"}};
        System.out.println(Arrays.deepToString(s2Array));

        // insert value
        TwoDimensionArray sda = new TwoDimensionArray(3, 3);
        sda.insertValueInTheArray(0, 0, 10);
        sda.insertValueInTheArray(0, 1, 20);
        sda.insertValueInTheArray(1, 0, 30);
        sda.insertValueInTheArray(1, 1, 40);
        System.out.println(Arrays.deepToString(sda.getArray()));

        // access value
        sda.accessCell(0, 1);

        // traverse array
        sda.traverse2DArray();

        // searching value
        sda.searchingValue(20);
        sda.searchingValue(100);

        // deleting a value
        sda.deleteValueFromArray(0, 0);
        System.out.println(Arrays.deepToString(sda.getArray()));
    }
}
