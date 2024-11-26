package com.serzhio_pet_projects;

import static com.serzhio_pet_projects.HashUtils.convertStringToByteArray;

public class Main {
    public static void main(String[] args) {
        String message = "00";
        ByteArray result = convertStringToByteArray(message);
        System.out.println(result.getLenght());
    }
}