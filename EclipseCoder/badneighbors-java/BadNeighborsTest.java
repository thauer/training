import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BadNeighborsTest {

    protected BadNeighbors solution;

    @Before
    public void setUp() {
        solution = new BadNeighbors();
    }

    @Test(timeout = 2000)
    public void testCase97() {
      int[] donations = new int[]{
          836, 100, 274, 931, 632, 817, 951, 992,  17, 349, 
          189,  99,  77, 316, 698,  10, 732,   3,   2, 445, 
          524, 343, 953, 513, 459
          };

      int expected = 6933;
      int actual = solution.maxDonations(donations);

      Assert.assertEquals(expected, actual);
    }
    
    @Test(timeout = 2000)
    public void testCase98() {
        int[] donations = new int[]{
            268, 265, 254, 470, 850, 746, 225, 541, 595, 773,
            924, 112, 597, 413, 965, 222, 722, 287, 263, 326, 
            109,   4, 776, 458, 621,  34, 211, 982, 108, 295, 
            974, 978,   1, 677, 600, 671, 318, 779, 328, 358
            };

        int expected = 11793;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase99() {
        int[] donations = new int[]{
            399, 470,  76, 788, 170, 349, 895, 682,  49, 873, 
            943, 798, 111, 981, 678, 600, 459, 265, 939, 555, 
            406};

        int expected = 6886;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] donations = new int[]{10, 3, 2, 5, 7, 8};

        int expected = 19;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] donations = new int[]{11, 15};

        int expected = 15;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] donations = new int[]{7, 7, 7, 7, 7, 7, 7};

        int expected = 21;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] donations = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        int expected = 16;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] donations = new int[]{94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};

        int expected = 2926;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

}
