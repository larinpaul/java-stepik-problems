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



    // TODO Explain all
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return new String(result.toByteArray(), charset);

    }


}
