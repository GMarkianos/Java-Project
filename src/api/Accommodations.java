/**
 * Αυτή η κλάση αναπαριστά ένα κατάλυμα και τα χαρακτηριστικά του.
 * @author 4109
 */

package api;

import java.util.ArrayList;
import api.Facility;

public class Accommodations {
    private String name;
    private String type;
    private String address;
    private String town;
    private String TaCode;
    private String description;
    private ArrayList<Facility> facilities;
    private ArrayList<String> stoixeiaAcc = new ArrayList<String>();
    private ArrayList<String> stoixeiaFac = new ArrayList<String>();



    public Accommodations(String name, String type, String address, String town, String TaCode, String description) {
        this.name = name ;
        this.type = type ;
        this.address = address;
        this.town = town;
        this.TaCode = TaCode;
        this.description = description;
        this.facilities = new ArrayList<>();
        stoixeiaAcc.add(name);
        stoixeiaAcc.add(type);
        stoixeiaAcc.add(address);
        stoixeiaAcc.add(town);
        stoixeiaAcc.add(TaCode);
        stoixeiaAcc.add(description);
    }
    /**
     * Κατασκευαστής κλάσης.
     */

    public String getName(){ return name; }

    public String getType(){ return type; }

    public String getAddress(){ return address; }

    public String getTown(){ return town; }

    public String getTaCode(){ return TaCode; }

    public String getDescription(){ return description;}

    public void addFacility(String view, String bathroom, String clothes, String fun, String heat, String internet, String kitchen, String exterior , String parking) {

        this.facilities.add(new Facility(view, bathroom, clothes, fun, heat, internet, kitchen , exterior , parking ));
    }

    public ArrayList<Facility> getFacilities(){ return this.facilities; }

    public ArrayList<String> getStoixeiaFac() {
        stoixeiaFac.add(Facility.getView());
        stoixeiaFac.add(Facility.getBathroom());
        stoixeiaFac.add(Facility.getClothes());
        stoixeiaFac.add(Facility.getFun());
        stoixeiaFac.add(Facility.getHeat());
        stoixeiaFac.add(Facility.getInternet());
        stoixeiaFac.add(Facility.getKitchen());
        stoixeiaFac.add(Facility.getExterior());
        stoixeiaFac.add(Facility.getParking());
        return stoixeiaFac;
    }
    public ArrayList<String> getStoixeiaAcc() { return stoixeiaAcc; }


    /**
     * Βασικές λειτουργίες κλάσης.
     */
}
