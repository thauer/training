import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlowerGardenTest {

    protected FlowerGarden solution;

    @Before
    public void setUp() {
        solution = new FlowerGarden();
    }

    @Test(timeout = 2000)
    public void testCase99() {
        int[] height = new int[]{
            401, 267, 259, 760, 846, 105, 126, 717, 669, 864, 
            449,  87, 276, 670, 861,  60, 660,  28,  94, 788, 
            111, 305, 580, 848, 163, 112, 355};

        int[] bloom = new int[]{
            219, 345,  30, 234,  14, 338, 301,  69,  50, 204, 
             33,  85, 137, 293,  50, 304, 227, 330, 309, 286, 
            349, 185, 291, 339, 339, 157, 290};
        
        int[] wilt = new int[]{
            343, 358, 365, 336, 295, 350, 351,  84,  52, 324, 
            363, 356, 183, 350, 222, 329, 362, 342, 358, 305, 
            356, 363, 365, 343, 350, 311, 353};

        int[] expected = new int[]{
             60,  28,  87,  94, 112, 105, 111, 126, 163, 259, 
            276, 267, 305, 355, 401, 449, 717, 669, 580, 660, 
            670, 848, 760, 788, 846, 861, 864};
        
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }
    
    @Test(timeout = 2000)
    public void testCase0() {
        int[] height = new int[]{5, 4, 3, 2, 1};
        int[] bloom = new int[]{1, 1, 1, 1, 1};
        int[] wilt = new int[]{365, 365, 365, 365, 365};

        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] height = new int[]{5, 4, 3, 2, 1};
        int[] bloom = new int[]{1, 5, 10, 15, 20};
        int[] wilt = new int[]{4, 9, 14, 19, 24};

        int[] expected = new int[]{5, 4, 3, 2, 1};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] height = new int[]{5, 4, 3, 2, 1};
        int[] bloom = new int[]{1, 5, 10, 15, 20};
        int[] wilt = new int[]{5, 10, 15, 20, 25};

        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] height = new int[]{5, 4, 3, 2, 1};
        int[] bloom = new int[]{1, 5, 10, 15, 20};
        int[] wilt = new int[]{5, 10, 14, 20, 25};

        int[] expected = new int[]{3, 4, 5, 1, 2};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] height = new int[]{1, 2, 3, 4, 5, 6};
        int[] bloom = new int[]{1, 3, 1, 3, 1, 3};
        int[] wilt = new int[]{2, 4, 2, 4, 2, 4};

        int[] expected = new int[]{2, 4, 6, 1, 3, 5};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] height = new int[]{3, 2, 5, 4};
        int[] bloom = new int[]{1, 2, 11, 10};
        int[] wilt = new int[]{4, 3, 12, 13};

        int[] expected = new int[]{4, 5, 2, 3};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

}
