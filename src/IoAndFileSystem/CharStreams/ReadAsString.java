package IoAndFileSystem.CharStreams;

// https://stepik.org/lesson/12784/step/12?after_pass_reset=true&unit=3131

// Реализуйте метод, который зачитает данные из InputStream
// и преобразует их в строку, используя заданную кодировку.

// Пример

// InputStream последовательно возвращает четыре байна: 48 49 50 51.

// Метод, вызванный для такого InputStream и кодировки ASCII,
// должен вернуть строку "0123".


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class ReadAsString {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // Create a new ByteArrayOutputStream to hold the data read from the InputStream
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        // Create a bugger to hold the data read from the InputStream
        byte[] buffer = new byte[1024];
        int length;
        // Loop through the InputStream, reading data into the buffer
        while ((length = inputStream.read(buffer)) != -1) {
            // Write the data from the buffer to the ByteArrayOutputStream
            result.write(buffer, 0, length);
        }
        // Convert the data in the ByteArrayOutputStream
        return new String(result.toByteArray(), charset);
    }
}
