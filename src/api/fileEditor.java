/**
 * Η συγκεκριμένη κλάση χρησιμοποιείται για διάφορες λειτουργίες στην επεξεργασία αρχείων
 */

package api;


import java.io.*;
import java.util.*;
import java.io.BufferedWriter;


/**
 * Η μέθοδος αυτή δέχεται το όνομα του μονοπατιού ενός αρχείου χρήστη , τα στοιχεία του χρήστη και τον ρόλο του και γράφει στο αρχείο αυτό τα προαναφερόμενα.
 *@author 4256
*/
public class fileEditor {
    public static void writeFile(String strFile, ArrayList strData, String role) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(strFile))) {

            Iterator<String> it = strData.iterator();
            while (it.hasNext()) {
                String index = it.next();
                buffer.write(index);
                buffer.newLine();
            }
            if (role.equals("Πάροχος")) {
                buffer.write("Πάροχος");
            } else if (role.equals("Χρήστης")) {
                buffer.write("Χρήστης");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Η μέθοδος αυτή δέχεται το όνομα του μονοπατιού ενός αρχείου καταλύματος, τα στοιχεία του καταλύματος και όνομα του πάροχου που το καταχώρησε
     * και γράφει στο αρχείο αυτό τα προαναφερόμενα.
     *@author 4109
     */
    public static void writeFileAccommodation(String strFile, ArrayList strData, ArrayList strfac, String user) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(strFile))) {
            buffer.write(user);
            buffer.newLine();

            Iterator<String> it = strData.iterator();
            while (it.hasNext()) {
                String index = it.next();
                buffer.write(index);
                buffer.newLine();
            }
            Iterator<String> it1 = strfac.iterator();
            while (it1.hasNext()) {
                String index1 = it1.next();
                buffer.write(index1);
                buffer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Η μέθοδος αυτή δέχεται το όνομα του μονοπατιού ενός αρχείου και σβήνει όλα τα στοιχεία που υπάρχουν σ αυτό.
     */
    public static void clearFile(String path) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter pw = new PrintWriter(fw, false);
        pw.flush();
        pw.close();
        try {
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String read(String path, Integer lineWanted) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File file=new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        try (LineNumberReader rdr = new LineNumberReader(new FileReader(file))) {
            for (String line = null; (line = rdr.readLine()) != null; ) {
                if (rdr.getLineNumber() == lineWanted) {
                    sb.append(line);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String contents = String.valueOf(sb);

        return contents;
    }

    public static ArrayList searchFiles(String name, String type, String location, String view, String bath, String wash, String fun,
                                        String heat, String internet, String kitchen, String outdoors, String parking) {
       ArrayList<String> results = new ArrayList<String>();
        File file = new File("Files\\Accommodations");
        File[] fileArray = file.listFiles();
        for (File f : fileArray) {
            Integer counter = 0;
            try {
                if(!name.equals("")){
                    if (read(String.valueOf(f), 2).equals(name.trim())) counter++;
                }else if(!type.equals("")){
                    if (read(String.valueOf(f), 3).equals(type.trim())) counter++;
                }else if(!location.equals("")){
                    if (read(String.valueOf(f), 5).equals(location.trim())) counter++;
                }else if(!view.equals("")){
                    if (read(String.valueOf(f), 8).equals(view.trim())) counter++;
                }else if(!bath.equals("")){
                    if (read(String.valueOf(f), 9).equals(bath.trim())) counter++;
                }else if(!wash.equals("")){
                    if (read(String.valueOf(f), 10).equals(wash.trim())) counter++;
                }else if(!fun.equals("")){
                    if (read(String.valueOf(f), 11).equals(fun.trim())) counter++;
                }else if(!heat.equals("")){
                    if (read(String.valueOf(f), 12).equals(heat.trim())) counter++;
                }else if(!internet.equals("")){
                    if (read(String.valueOf(f), 13).equals(internet.trim())) counter++;
                }else if(!kitchen.equals("")){
                    if (read(String.valueOf(f), 14).equals(kitchen.trim())) counter++;
                }else if(!outdoors.equals("")){
                    if (read(String.valueOf(f), 15).equals(outdoors.trim())) counter++;
                }else if(!parking.equals("")){
                    if (read(String.valueOf(f), 16).equals(parking.trim())) counter++;
                }
                if (counter >= 1) {
                    results.add(String.valueOf(f));
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return results;
    }

    public static void writeReviewFile(String path, String username, String AccName,String rating,String date,String Text) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(path))){
            buffer.write(username);
            buffer.newLine();

            buffer.write(AccName);
            buffer.newLine();

            buffer.write(rating);
            buffer.newLine();

            buffer.write(date);
            buffer.newLine();

            buffer.write(Text);
            buffer.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}