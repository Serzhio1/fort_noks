package com.serzhio_pet_projects;

import static com.serzhio_pet_projects.ByteArray.createByteArrayLengthInputData;
import static com.serzhio_pet_projects.ByteArray.mergeByteArrays;


public class HashUtils {

    final static byte ONE_BYTE = 1;
    final static int BLOCK_LENGTH = 128;
    final static int INPUT_DATA_LENGTH = 8;

    public static ByteArray convertStringToByteArray(String inputData) {

        ByteArray byteArrayInputData = new ByteArray(inputData);
        int lengthByteArrayInputData = byteArrayInputData.getLenght();
        System.out.println("Длина входного сообщения в байтах: " + lengthByteArrayInputData);
        byteArrayInputData.appendByte(ONE_BYTE);

        if (BLOCK_LENGTH - (lengthByteArrayInputData % BLOCK_LENGTH) < INPUT_DATA_LENGTH + ONE_BYTE) {
            int countZeroToFillPenultimateBlock = BLOCK_LENGTH - (lengthByteArrayInputData % 128);
            int countZeroToFillLastBlock = BLOCK_LENGTH - INPUT_DATA_LENGTH;
            ByteArray arrayZeroToFillPenultimateBlock = new ByteArray(countZeroToFillPenultimateBlock);
            ByteArray arrayZeroToFillLastBlock = new ByteArray(countZeroToFillLastBlock);
            byteArrayInputData = mergeByteArrays(byteArrayInputData, arrayZeroToFillPenultimateBlock);
            byteArrayInputData = mergeByteArrays(byteArrayInputData, arrayZeroToFillLastBlock); 
        } else {
            int requiredCountZeroBytes = getCountRequiredZeroBytes(lengthByteArrayInputData);
            ByteArray arrayZeroBytes = new ByteArray(requiredCountZeroBytes);
            byteArrayInputData = mergeByteArrays(byteArrayInputData, arrayZeroBytes);
        }
        ByteArray byteArrayLengthInputData =  createByteArrayLengthInputData(lengthByteArrayInputData);
        ByteArray resultByteArray = mergeByteArrays(byteArrayInputData, byteArrayLengthInputData);
        return resultByteArray;
    }   

    private static int getCountRequiredZeroBytes(int arrayBytesSize) {
        return BLOCK_LENGTH - (arrayBytesSize % BLOCK_LENGTH) - INPUT_DATA_LENGTH;
    } 
}
