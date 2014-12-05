import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NormalizingTreesTest {

    protected NormalizingTrees solution;

    @Before
    public void setUp() {
        solution = new NormalizingTrees();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] tree = new int[]{2, 0, -1, 4, 2, 4};

        int[] expected = new int[]{-1, 0, 0, 0, 1, 4};
        int[] actual = solution.normalize(tree);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] tree = new int[]{-1, 0, 1, 2, 3};

        int[] expected = new int[]{-1, 0, 0, 1, 2};
        int[] actual = solution.normalize(tree);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] tree = new int[]{3, 3, 3, 4, -1, 3};

        int[] expected = new int[]{-1, 0, 0, 0, 0, 0};
        int[] actual = solution.normalize(tree);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] tree = new int[]{10, 9, 6, 10, 6, 9, 7, -1, 9, 7, 7, 10, 6};

        int[] expected = new int[]{-1, 0, 0, 0, 0, 1, 1, 5, 5, 5, 6, 6, 6};
        int[] actual = solution.normalize(tree);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] tree = new int[]{-1, 0, 0, 0, 0, 1, 1, 5, 5, 5, 6, 6, 6};

        int[] expected = new int[]{-1, 0, 0, 0, 0, 1, 1, 5, 5, 5, 6, 6, 6};
        int[] actual = solution.normalize(tree);

        Assert.assertArrayEquals(expected, actual);
    }
    
    @Test(timeout = 2000)
    public void testCase5() {
        int[] tree = new int[]{9, 7, -1, 2, 1, 2, 11, 2, 7, 2, 7, 3, 1, 7};

        int[] expected = new int[]{-1, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 6, 7, 11};
        int[] actual = solution.normalize(tree);

        Assert.assertArrayEquals(expected, actual);
    }
    
    @Test(timeout = 15000)
    public void testCase6() {
        int[] tree = new int[]{21, 25, 17, 24, 17, 21, 26, 40, 34, 18, 42, 
            46, 13, 45, 45, 33, 25, 36, 26, 9, 42, 24, 47, 40, 26, 18, -1, 
            14, 17, 34, 11, 13, 42, 3, 3, 9, 24, 21, 33, 14, 46, 11, 45, 13, 
            40, 6, 6, 36, 9};

        int[] expected = new int[]{
            -1,  0,  0,  0,  0,  1,  1,  1,  2,  2, 
             2,  3,  3,  4,  4, 11, 11, 12, 12, 15, 
            15, 15, 16, 16, 17, 17, 17, 18, 18, 19, 
            19, 19, 20, 20, 21, 21, 22, 22, 22, 23, 
            23, 32, 32, 32, 33, 34, 34, 35, 35};
        int[] actual = solution.normalize(tree);

        Assert.assertArrayEquals(expected, actual);
    }   
}
