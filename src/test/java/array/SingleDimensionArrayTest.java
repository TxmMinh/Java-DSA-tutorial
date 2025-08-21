package array;

import com.completedsa.udemy.array.SingleDimensionArray;
import org.junit.jupiter.api.Test;

public class SingleDimensionArrayTest {
    @Test
    public void testSingleDArray() {
        // insert array
        SingleDimensionArray singleDArray = new SingleDimensionArray(3);
        singleDArray.insert(0, 10);
        singleDArray.insert(1, 20);
        singleDArray.insert(2, 30);
        singleDArray.insert(1, 4);
        singleDArray.insert(11, 5);

        // accessing element in array
        var firstElement = singleDArray.getArray()[0];
        System.out.println(firstElement);
        var thirdElement = singleDArray.getArray()[2];
        System.out.println(thirdElement);

        // traversal array
        singleDArray.traverseArray();

        // search value in array
        singleDArray.searchInArray(20);
        singleDArray.searchInArray(40);

        // delete value in array
        singleDArray.deleteValueByIndex(10);
        System.out.println(singleDArray.getArray()[1]);

    }
}
