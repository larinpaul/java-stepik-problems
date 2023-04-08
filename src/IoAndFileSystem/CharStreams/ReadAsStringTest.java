package IoAndFileSystem.CharStreams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import static IoAndFileSystem.CharStreams.ReadAsString.readAsString;

public class ReadAsStringTest {

    // TODO Explain all
    public static void main(String[] args) throws IOException {
        byte[] buf = {48, 49, 50, 51};
        ByteArrayInputStream arr = new ByteArrayInputStream(buf);
        System.out.println(readAsString(arr, Charset.forName("US-ASCII")));
    }

}
