/**
 * Η κλάση αυτή χρησιμοποιείται για την επαλήθευση του username και password του χρήστη .
 * @author 4256
 */

package api;
import gui.Errors.LoginERROR1;
import gui.Errors.LoginERROR2;
import gui.GUIlogin;
import java.io.*;
import java.util.Scanner;


public class XrhsthsLoginVerification {
    private static Scanner scan;

    public static boolean verified;
    //public static boolean getVerified(){return verified;}

    public static void Verify(String name, String password, String filePath) throws IOException {
        verified = false;
        String tempPassword = "";
        try{
            scan = new Scanner(new File(filePath));
            scan.useDelimiter("[\n]");

            while (scan.hasNext() && !verified){
                tempPassword = scan.next();
                if(tempPassword.trim().equals(password.trim())){
                    verified = true;
                }
            }
            if(verified==true){

            }else{
                LoginERROR2 error2 = new LoginERROR2();
            }
        }catch (Exception e){
            LoginERROR1 error1 = new LoginERROR1();
        }
    }
}


