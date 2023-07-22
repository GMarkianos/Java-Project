package api;

import org.junit.*;

import static org.junit.Assert.*;

public class XrhsthsTest {
    public XrhsthsTest(){

    }

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
    public void test() {
        Xrhsths xrhsths = new Xrhsths("giorgos","mk","ellhn","koufalia23");
        Assert.assertEquals("giorgos",xrhsths.getName());
        Assert.assertEquals("mk",xrhsths.getSurname());
        Assert.assertEquals("ellhn", xrhsths.getUsername());
        Assert.assertEquals("koufalia23", xrhsths.getPassword());
    }
}