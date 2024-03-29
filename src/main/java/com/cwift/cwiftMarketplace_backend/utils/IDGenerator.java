package com.cwift.cwiftMarketplace_backend.utils;

import java.util.Random;

public class IDGenerator {

    private static long lastTimestamp = 0;
    private static int counter = 0;

    public static String userIDGenerator() {
        StringBuilder sb = new StringBuilder("USI-");  //This code stands for user id
        Random random = new Random();

        // Append timestamp to the unique id to ensure uniqueness
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp == lastTimestamp) {
            counter++;
        } else {
            lastTimestamp = currentTimestamp;
            counter = random.nextInt(10); // Reset counter for new timestamp
        }

        // Append random number and counter to the unique id
        sb.append(currentTimestamp).append(counter);

        // Generate the remaining digits
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }


    public static String itemIDGenerator() {
        StringBuilder sb = new StringBuilder("sku-");  //This code stands for cwift item sku
        Random random = new Random();

        // Append timestamp to the unique id to ensure uniqueness
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp == lastTimestamp) {
            counter++;
        } else {
            lastTimestamp = currentTimestamp;
            counter = random.nextInt(10); // Reset counter for new timestamp
        }

        // Append random number and counter to the unique id
        sb.append(currentTimestamp).append(counter);

        // Generate the remaining digits
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    public static String customItemSkuGenerator() {
        StringBuilder sb = new StringBuilder("CI-sku-");  //This code stands for cwift custom item sku
        Random random = new Random();

        // Append timestamp to the unique id to ensure uniqueness
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp == lastTimestamp) {
            counter++;
        } else {
            lastTimestamp = currentTimestamp;
            counter = random.nextInt(10); // Reset counter for new timestamp
        }

        // Append random number and counter to the unique id
        sb.append(currentTimestamp).append(counter);

        // Generate the remaining digits
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    public static String orderIDGenerator() {
        StringBuilder sb = new StringBuilder("NFO");  //This code stands for cwift marketplace order id
        Random random = new Random();

        // Append timestamp to the unique id to ensure uniqueness
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp == lastTimestamp) {
            counter++;
        } else {
            lastTimestamp = currentTimestamp;
            counter = random.nextInt(10); // Reset counter for new timestamp
        }

        // Append random number and counter to the unique id
        sb.append(currentTimestamp).append(counter);

        // Generate the remaining digits
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String cartIDGenerator() {
        StringBuilder sb = new StringBuilder("CAT");  //This code stands for Catalogue item
        Random random = new Random();

        // Append timestamp to the unique id to ensure uniqueness
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp == lastTimestamp) {
            counter++;
        } else {
            lastTimestamp = currentTimestamp;
            counter = random.nextInt(10); // Reset counter for new timestamp
        }

        // Append random number and counter to the unique id
        sb.append(currentTimestamp).append(counter);

        // Generate the remaining digits
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    public static String transIDGenerator() {
        StringBuilder sb = new StringBuilder("TRANS-ID");  //This code stands for translation ID
        Random random = new Random();

        // Append timestamp to the unique id to ensure uniqueness
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp == lastTimestamp) {
            counter++;
        } else {
            lastTimestamp = currentTimestamp;
            counter = random.nextInt(10); // Reset counter for new timestamp
        }

        // Append random number and counter to the unique id
        sb.append(currentTimestamp).append(counter);

        // Generate the remaining digits
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    public static String accountNumber() {
        StringBuilder sb = new StringBuilder("015");  //This code stands for transaction ID
        Random random = new Random();

        // Append timestamp to the unique id to ensure uniqueness
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp == lastTimestamp) {
            counter++;
        } else {
            lastTimestamp = currentTimestamp;
            counter = random.nextInt(10); // Reset counter for new timestamp
        }

        // Append random number and counter to the unique id
        sb.append(currentTimestamp).append ( counter );
//        sb.append(counter);

        // Generate the remaining digits
//        for (int i = 0; i < 7; i++) {
//            sb.append(random.nextInt(10));
//        }

        return sb.toString();
    }

    public static String otpGenerator () {
        StringBuilder sb = new StringBuilder();  //This code stands for transaction ID
        Random random = new Random ();

        for (int i = 0; i < 5; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString ();
    }
}
