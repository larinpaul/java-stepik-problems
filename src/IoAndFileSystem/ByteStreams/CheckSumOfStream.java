package IoAndFileSystem.ByteStreams;

// Контрольная сумма - некоторое значение, расчитанное
// по набору данных путем применения определенного алгоритма
// и используемое для проверки целостности данных при их передаче и хранении

// Напишите метод, читающий входной поток
// и вычисляющий контрольную сумму прочитанных данных.

// Контрольная сумма данных вычисляется по следующему алгоритму:
// 1. Контрольная сумма представляет собой число типа int.
// Контрольна сумма пустого набора данных равна нулю.
// 2. Контрольная сумма непустого набора данных вычисляется
// по следующей рекуррентной формуле: Cn+1 = rotateLeft(Cn) xor bn+1,
// где Cn - контрольня сумма первых n байт данных,
// rotateLeft - циклический сдвиг бит числа на один бит влево
// (чтобы не изобретать велосипед, используйте Integer.rotateLeft),
// bn - n-ный байт данных.

// Поскольку метод не открывал данный InputStream, то и закрывать
// его он не должен. Выброшенное из методов InputStream
// исключение должно выбрасываться из метода.

import java.io.IOException;
import java.io.InputStream;

// Пример
// На вход подан InputStream, последовательно возвращающий три
// байта: 0x33 0x45 0x01. В качестве контрольной суммы должно
// быть возвращено число 71.
public class CheckSumOfStream {

    // The `checkSumOfStream` method takes an `InputStream` as input and calculates
    // the checksum of the data read from it. The method reads bytes from the input
    // stream and updates the checksum value using a bitwise XOR operation and a cyclic
    // left shift operation.
    // Here's a step-by-step explanation of how the checksum is calculated:
    // 1. The checksum is initialized to zero.
    // 2. For each byte read from the input stream, the checksum value is updates as follows:
    // a. The current checksum value is shifted one bit to the left using the
    // `Integer.rotateLeft` method
    // b. The resulting value is then XOR-ed with the current byte read from the input stream.
    // c. The resulting value becomes the new checksum value.
    // 3. After all bytes have been read from the input stream, the final checksum value is returned
    // Note that the method does not open or close the input stream. Any exceptions
    // thrown by the `InputStream` methods are propagated out of the method
    // without being caught.
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        // Initializes the checksum to zero
        int checksum = 0;

        // Declares a variable to hold the current type read from the stream
        int byteRead;
        // Reads from the input stream until there are no more bytes to read
        while ((byteRead = inputStream.read()) != -1) {
            // Updates the checksum using the current byte read and the previous checksum value
            checksum = Integer.rotateLeft(checksum, 1) ^ byteRead;
        }
        // Returns the final checksum value
        return checksum;
    }

}
