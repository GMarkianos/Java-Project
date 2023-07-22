package api;

import org.junit.*;

import static org.junit.Assert.*;

public class FacilityTest {
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
    public void test(){
        Facility facility1 = new Facility("thalassa", "pistolaki", "plunthrio","thleorash", "tzaki","wifi", "kafeteria", "mpalkoni","idiokthsia");
        Assert.assertEquals("thalassa",facility1.getView());
        Assert.assertEquals("pistolaki",facility1.getBathroom());
        Assert.assertEquals("plunthrio",facility1.getClothes());
        Assert.assertEquals("thleorash",facility1.getFun());
        Assert.assertEquals("tzaki", facility1.getHeat());
        Assert.assertEquals("wifi",facility1.getInternet());
        Assert.assertEquals("kafeteria",facility1.getKitchen());
        Assert.assertEquals("mpalkoni",facility1.getExterior());
        Assert.assertEquals("idiokthsia",facility1.getParking());
    }
}