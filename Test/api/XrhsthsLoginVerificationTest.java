package api;

import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static api.XrhsthsLoginVerification.verified;
import static org.junit.Assert.*;

public class XrhsthsLoginVerificationTest {

    File file1;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        try {
            file1 = folder.newFile("testfile1.txt");
            try {
                FileWriter fw1 = new FileWriter(file1);
                BufferedWriter bw1 = new BufferedWriter(fw1);
                bw1.write("<html>username<br>password</html>");
                bw1.close();
            } catch (IOException ioe) {
                System.err.println("error creating temporary test file in " + this.getClass().getSimpleName());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


            @Test
            public void verify () throws FileNotFoundException {

            }


}