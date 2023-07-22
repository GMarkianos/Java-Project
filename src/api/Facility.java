package api;

import java.util.ArrayList;

/**
 * Αυτή η κλάση αναπαριστά τις παροχές ενός καταλύματος.
 * @author 4109
 */
public class Facility {
     private static String view;
     private static String bathroom;
     private static String clothes;
     private static String fun;
     private static String heat;
     private static String internet;
     private static String kitchen;
     private static String exterior;
     private static String parking;


     public Facility(String view, String bathroom,String clothes,String fun,String heat, String internet, String kitchen,String exterior,String parking){
         this.view = view;
         this.bathroom = bathroom;
         this.clothes = clothes;
         this.fun = fun;
         this.heat = heat;
         this.internet = internet;
         this.kitchen = kitchen;
         this.exterior = exterior;
         this.parking = parking;
     }
    /**
     * Κατασκευαστής κλάσης
     */

    public static String getView() { return view; }

    public static String getBathroom() { return bathroom; }

    public static String getClothes() { return clothes; }

    public static String getFun() { return fun; }

    public static String getHeat() { return heat; }

    public static String getInternet() { return internet; }

    public static String getKitchen() { return kitchen; }

    public static String getExterior() { return exterior; }

    public static String getParking() { return parking; }


}
