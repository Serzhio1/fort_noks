package com.serzhio_pet_projects;
import java.nio.ByteBuffer;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.Arrays;

public class ByteArray {

    private byte[] data;
    private final int length;

    public ByteArray(String inputData) {
        this.data = createByteArrayFromString(inputData);
        this.length = data.length;
    }

    public ByteArray(int lenghtArray) {
        this.data = new byte[lenghtArray];
        this.length = data.length;
    }

    public ByteArray(byte[] byteArray) {
        this.data = Arrays.copyOf(byteArray, byteArray.length);
        this.length = data.length;
    }

    public ByteArray() {
        this.data = new byte[0];
        this.length = data.length;
    }

    public static byte[] createByteArrayFromString(String inputData) {
        return inputData.getBytes(UTF_8);
    }

    public void appendByte(byte value) {
        byte[] result = Arrays.copyOf(data, length + 1);
        result[result.length - 1] = value;
        data = result;
    }

    public static ByteArray mergeByteArrays(ByteArray sourceArray, ByteArray additionalArray) {
        int lenghtResultArray = sourceArray.getLenght() + additionalArray.getLenght();
        ByteArray resultArray = new ByteArray(lenghtResultArray);
        System.arraycopy(sourceArray.getData(), 0, resultArray.getData(), 0, sourceArray.getLenght());
        System.arraycopy(additionalArray.getData(), 0, resultArray.getData(), sourceArray.getLenght(), additionalArray.getLenght());
        return resultArray;
    }

    public static ByteArray createByteArrayLengthInputData(int length) {  
        ByteBuffer buffer = ByteBuffer.allocate(8); 
        buffer.putLong(length); 
        byte[] lengthBytes = buffer.array(); 
        ByteArray byteArray = new ByteArray(lengthBytes);
        return byteArray;
    }

    public int getLenght() {
        return length;
    }

    public byte[] getData() {
        return data;
    }
}
