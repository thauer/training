import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AvoidRoadsTest {

    protected AvoidRoads solution;

    @Before
    public void setUp() {
        solution = new AvoidRoads();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int width = 6;
        int height = 6;
        String[] bad = new String[]{"0 0 0 1", "6 6 5 6"};

        long expected = 252L;
        long actual = solution.numWays(width, height, bad);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int width = 1;
        int height = 1;
        String[] bad = new String[]{};

        long expected = 2L;
        long actual = solution.numWays(width, height, bad);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int width = 35;
        int height = 31;
        String[] bad = new String[]{};

        long expected = 6406484391866534976L;
        long actual = solution.numWays(width, height, bad);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int width = 2;
        int height = 2;
        String[] bad = new String[]{"0 0 1 0", "1 2 2 2", "1 1 2 1"};

        long expected = 0L;
        long actual = solution.numWays(width, height, bad);

        Assert.assertEquals(expected, actual);
    }

}
