import com.epam.task1.action.BinarySearch;
import com.epam.task1.exceptions.MyBinarySearchException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearch() throws MyBinarySearchException {
        BinarySearch binarySearch = new BinarySearch();
        double[] arr = new double[3];
        arr[0] = -1.0;
        arr[1] = 2.0;
        arr[2] = 3.0;

        int result = binarySearch.binarySearch(arr, -1.0);
        Assert.assertEquals(result, 0);
        result = binarySearch.binarySearch(arr, 4.0);
        Assert.assertEquals(result, -1) ;
    }
}
