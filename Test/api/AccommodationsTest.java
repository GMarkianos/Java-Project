package api;

import org.junit.*;

import java.util.ArrayList;


public class AccommodationsTest {
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
       Accommodations spiti = new Accommodations("aiglion","diamerisma","solonos 19","metsovo","66666","para poly wraio paidia");
       Assert.assertEquals("aiglion", spiti.getName());
       Assert.assertEquals("diamerisma", spiti.getType());
       Assert.assertEquals("solonos 19", spiti.getAddress());
       Assert.assertEquals("metsovo", spiti.getTown());
       Assert.assertEquals("66666", spiti.getTaCode());
       Assert.assertEquals("para poly wraio paidia", spiti.getDescription());
       Accommodations spiti2 = new Accommodations("anesis","jenodoxeio", "niovis 7", "bansko", "12345", "fovero");
       Assert.assertEquals("anesis", spiti2.getName());
       Assert.assertEquals("jenodoxeio", spiti2.getType());
       Assert.assertEquals("niovis 7", spiti2.getAddress());
       Assert.assertEquals("bansko", spiti2.getTown());
       Assert.assertEquals("12345", spiti2.getTaCode());
       Assert.assertEquals("fovero", spiti2.getDescription());
       Assert.assertEquals(new ArrayList<Facility>(), spiti2.getFacilities());
   }

    @Test
    public void addFacility() {
        Accommodations spiti2 = new Accommodations("anesis","jenodoxeio","niovis 7", "bansko", "12345", "fovero");
        spiti2.addFacility("paralia","petsetes", "plunthrio", "parko", "kalorifer", "wifi", "foyrnos", "mpalkoni", "dipla");
        Assert.assertEquals("paralia", spiti2.getFacilities().get(0).getView());
        Assert.assertEquals("petsetes", spiti2.getFacilities().get(0).getBathroom());
        Assert.assertEquals("plunthrio", spiti2.getFacilities().get(0).getClothes());
        Assert.assertEquals("parko", spiti2.getFacilities().get(0).getFun());
        Assert.assertEquals("kalorifer", spiti2.getFacilities().get(0).getHeat());
        Assert.assertEquals("wifi", spiti2.getFacilities().get(0).getInternet());
        Assert.assertEquals("foyrnos", spiti2.getFacilities().get(0).getKitchen());
        Assert.assertEquals("mpalkoni", spiti2.getFacilities().get(0).getExterior());
        Assert.assertEquals("dipla", spiti2.getFacilities().get(0).getParking());
    }


}