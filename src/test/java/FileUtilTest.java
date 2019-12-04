import com.epam.task1.exceptions.MyFileUtilException;
import com.epam.task1.util.FileUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

public class FileUtilTest {
    @Test
    public void testParsingLines() throws MyFileUtilException {
        String[] testArr = {"-1.0 2.0 3.0", "-1.z0 2.0 3.z0"};

       double[][] result = FileUtil.parsingLines(testArr);

        Assert.assertEquals(result[0].length,3);
        Assert.assertEquals(result[1].length,1);
        Assert.assertEquals(result[0][0],-1.0);
        Assert.assertEquals(result[0][1],2.0);
        Assert.assertEquals(result[1][0],2.0);

    }
    @Test
    public void testReadLines() throws IOException, MyFileUtilException {
        String[] result = FileUtil.readLines("testFile.txt");
        Assert.assertEquals(result.length,2);
    }
}
