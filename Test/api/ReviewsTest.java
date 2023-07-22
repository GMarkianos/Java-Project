package api;

import org.junit.*;

import static org.junit.Assert.*;

public class ReviewsTest {
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void Test() {
        Reviews review = new Reviews("Πολυ καλο ξενοδοχείο", "9");
        Assert.assertEquals("Πολυ καλο ξενοδοχείο", review.getText());
        Assert.assertEquals("9", review.getRate());
    }

}