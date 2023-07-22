/**
 * Αυτή η κλάση αναπαριστά μια αξιολόγηση και τα χαρακτηριστικά της.
 * @author 4109
 */

package api;

public class Reviews {
    private String text;
    private String rate;
    public Reviews(String text, String rate){
        this.text = text ;
        this.rate = rate;
    }

    /**
     * Κατασκευαστής κλάσης.
     */

    public String getText(){ return text; }

    public String getRate() { return rate; }

    /**
     * Βασικές λειτουργίες κλάσης.
     */
}
