package ObjectOrientedProgramming.AbstractClassesAndInterfaces;

// A class that implements the CharSequence interface and stores ASCII characters in a byte array
public class AsciiCharSequence implements CharSequence {

    // A field that holds the byte array
    private byte[] data;

    // A constructor that clones a byte array as an argument and assigns it to the field
    public AsciiCharSequence(byte[] data) {
        this.data = (byte[])data.clone();
    }

    // A method that returns the length of the sequence
    @Override
    public int length() {
        // The length of the sequence is the same as the length of the byte array
        return data.length;
    }

    // A method that returns the character at a given index
    @Override
    public char charAt(int index) {
        // The character at a given index is the ASCII code of the byte at that index
        // We need to cast the byte to char to return it as a character
        return (char) data[index];
    }

    // A method that returns a subsequence of the sequence
    @Override
    public CharSequence subSequence(int start, int end) {
        // The subsequence is a new AsciiCharSequence object that contains a copy of the byte array from start to end
        // We need to create a new byte array of size end-start
        // and copy the bytes from data to it using System.arraycopy
        byte[] subData = new byte[end - start];
        // data - the source array from which to copy elements
        // start - the starting position in the source array from where to copy
        // subData - the destination array into which to copy elements
        // 0 - the starting position in the destination array, where to copy in
        // end-start - the total number of elements to be copied
        System.arraycopy(data, start, subData, 0, end - start);
        // Create a new AsciiCharSequence object with a byte[] array subData, that contains
        // the subsequence of bytes from the original `data` array between the `start` and `end` indices
        // The newly crated object is then returned as a `CharSequence` instance representing the subsequence
        return new AsciiCharSequence(subData);
    }

    // A method that returns a String representation of the sequence
    @Override
    public String toString() {
        // The String representation is created by converting the byte array
        // to a String using the String constructor
        return new String(data);
    }
}




//public class AsciiCharSequence implements CharSequence {
//
//    private byte[] data;
//
//    public AsciiCharSequence(byte[] data) {
//        this.data = data;
//    }
//
//    @Override
//    public int length() {
//        return data.length;
//    }
//
//    @Override
//    public char charAt(int index) {
////        return (char) (data[index] & Oxff);
//        return (char) (data[index] & 255);
//    }
//
//    @Override
//    public CharSequence subSequence(int start, int end) {
//        int length = end - start;
//        byte[] bytes = new byte[length];
//        for (int i = 0, j = start; i < length; i++, j++) {
//            bytes[i] = data[j];
//        }
//        return new AsciiCharSequence(bytes);
//    }
//
//    @Override
//    public String toString() {
//        return new String(data);
//    }
//}





