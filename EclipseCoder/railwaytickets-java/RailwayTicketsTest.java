import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RailwayTicketsTest {

    protected RailwayTickets solution;

    @Before
    public void setUp() {
        solution = new RailwayTickets();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] travel = new String[]{"1-3 3-5", "2-4 4-6", "1-2 2-3 3-4 4-5"};
        int seats = 2;

        int expected = 2;
        int actual = solution.minRejects(travel, seats);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] travel = new String[]{"1-10000", "2-10000", "1-9999", "2-9999", "5000-5001"};
        int seats = 3;

        int expected = 2;
        int actual = solution.minRejects(travel, seats);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] travel = new String[]{"1-2 2-5 2-8 234-236 56-878 6-34", "234-776 3242-8000 999-1000 3-14", "121-122 435-3455 123-987 77-999"};
        int seats = 1000;

        int expected = 0;
        int actual = solution.minRejects(travel, seats);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] travel = new String[]{"1-2 2-3 3-4 4-5 5-6 6-7 1-3 2-7 1-2 1-4"};
        int seats = 1;

        int expected = 4;
        int actual = solution.minRejects(travel, seats);

        Assert.assertEquals(expected, actual);
    }
    
    @Test(timeout = 2000)
    public void testCase4() {
        String[] travel = new String[]{"2-3 1-4 3-4 1-3 2-4 1-2"};
        int seats = 2;

        int expected = 2;
        int actual = solution.minRejects(travel, seats);

        Assert.assertEquals(expected, actual);
    }
    
    @Test(timeout = 2000)
    public void testCase5() {
        String[] travel = new String[]{
            "4015-9629 715-4523 3372-9490 3153-4325 7540-9928", 
            "2255-9111 2478-5347 1924-9563 1265-3567 6184-8565", 
            "5479-6742 1000-7908 685-5200 4982-9817 829-1723", 
            "5803-8285 7910-8202 7803-9589 1733-7443 8809-9522", 
            "3423-9072 923-4921 2264-6137 4957-6728 1772-2981", 
            "181-2995 4594-7896 6252-9329 3856-6257 5005-5957", 
            "7696-9852 4182-7193 4582-8169 6207-7773 3568-9696", 
            "321-3087 7077-7476 3177-4962 7109-7897 1344-8003", 
            "2954-4540 3322-5316 1088-2198 2408-5723 7272-8226", 
            "1637-5774 5059-7026 3706-9929 1774-7934 1910-8350", 
            "1544-7004 3834-8576 1176-1381 3733-9657 5170-7738", 
            "5365-6459 1647-2815 853-5072 837-5014 1719-4931", 
            "857-6457 1548-5903 7154-9138 3307-8218 7215-9298", 
            "1603-9467 3146-6742 1202-1424 4082-5032 108-7831", 
            "376-7885 2634-7907 9271-9437 6683-7881 2888-4477", 
            "1551-3207 362-1515 2418-4349 4983-8438 806-7583", 
            "115-7376 5247-5870 249-4618 3414-3547 558-7310", 
            "2311-6972 6680-7404 7420-8415 8939-9659 5557-8931", 
            "502-6048 2943-7645 1347-7469 1181-5687 367-8669", 
            "4063-9397 459-4050 1990-9033 1387-8601 2732-7452", 
            "6289-7924 3705-9647 5508-8250 2723-6559 26-1823", 
            "5215-9031 3280-8469 2241-9451 7155-9565 1909-8214", 
            "1948-8065 5182-5996 870-5767 2547-7496 6262-9331", 
            "299-6991 1670-3586 6562-6709 7170-8042 1935-7906", 
            "9434-9552 1361-3337 378-3450 3650-3672 5152-9741", 
            "3802-4601 4850-8260 123-2586 2495-8129 5718-8255", 
            "1364-9203 1182-5331 2089-2894 2753-3471 808-1574", 
            "3866-9943 1049-5080 5505-8614 3730-9271 1653-2448", 
            "829-8038 2465-6422 4889-8590 239-5715 3091-5084", 
            "3795-3877 3851-6676 3062-4129 4927-7035 1399-3833", 
            "1177-9528 8959-9989 3129-7410 8727-8949 1658-2217", 
            "541-6469 2495-4739 2430-9774 2045-2172 2901-3208", 
            "1209-8602 1887-3318 3479-7242 1444-7211 3681-4288", 
            "4131-8009 1419-2401 2017-2803 4153-5889 1409-3417", 
            "764-9456 3329-7048 350-5937 2029-3706 2189-9861", 
            "1611-4758 1286-5324 2113-4369 57-6027 1412-3573", 
            "682-684 22-2434 326-3338 4195-8554 2933-8732", 
            "4581-4672 2142-4238 2112-5882 6325-6723 7281-7758", 
            "3151-3710 569-7276 611-7005 615-8586 1077-9513", 
            "1876-7945 433-7675 6397-6470 4579-9758 2484-7673", 
            "57-2718 390-7466 4662-9103 3992-8695 1541-5918", 
            "64-5838 2904-6028 1110-8931 117-2715 701-9623", 
            "1095-8496 3607-5440 1934-7243 5189-6834 55-3241", 
            "5471-9652 2762-2817 934-7531 1850-8125 4337-8853", 
            "1907-8208 5537-7968 881-8924 2677-6925 1611-2760", 
            "6273-6517 2828-5258 5999-8316 1366-5760 4181-6234", 
            "172-3248 6526-6541 8852-9555 3957-4529 3332-4040", 
            "53-2205 1866-9897 4373-9837 2871-6037 3641-4605", 
            "2979-5009 757-4493 3696-6195 6320-8524 104-7416", 
            "2624-9626 8019-9008 4529-5453 1453-6674 413-5889"
            };
        int seats = 39;

        int expected = 102;
        int actual = solution.minRejects(travel, seats);

        Assert.assertEquals(expected, actual);
    }    
}