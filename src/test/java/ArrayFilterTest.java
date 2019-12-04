import com.epam.task1.action.ArrayFilter;
import com.epam.task1.exceptions.MyArrayFilterException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayFilterTest {
    @Test
    public void testGetNewArray() throws MyArrayFilterException {
      ArrayFilter arrayFilter = new ArrayFilter();
        double[] arr = new double[3];
        arr[0] = -1.0;
        arr[1] = 2.0;
        arr[2] = 3.0;

        int [] result = arrayFilter.getNewArray(arr);
        Assert.assertEquals(result[0],0);
        Assert.assertEquals(result[1], 2);
        Assert.assertEquals(result[2], 0);



    }
}
