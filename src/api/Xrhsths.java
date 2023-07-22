/**
 * Αυτή η κλάση αναπαριστά ένα κατάλυμα και τα χαρακτηριστικά του.
 * @author 4256
 */

package api;

import java.util.ArrayList;

public class Xrhsths {
    /**
     * Χαρακτηριστικά χρήστη.
     */
    private String name;
    private String surname;
    private String username;
    private String password;
    private boolean paroxos;
    private boolean xrhsths;
    private ArrayList<String> stoixeia = new ArrayList<String>();

    /**Κατασκευαστής*/
   public Xrhsths(String name,String surname,String username,String password){
        this.name=name;
        this.surname=surname;
        this.username=username;
        this.password=password;

        stoixeia.add(name);
        stoixeia.add(surname);
        stoixeia.add(username);
        stoixeia.add(password);

    }
    /**Βασικές λειτουργίες*/
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getStoixeia() {
        return stoixeia;
    }

    public void setXrhsths(boolean xrhsths) {
        this.xrhsths = xrhsths;
    }

    public void setParoxos(boolean paroxos) {
        this.paroxos = paroxos;
    }
}

