package UtilMethods;

import java.util.Random;

public class RandomEmailGenerator
{

    public static String generateRandomEmail()
    {
        // Generate a random local part for the email
        String localPart = getRandomString(8); // You can adjust the length of the local part as desired

        // Domain name for the email
        String domain = "example.com"; // You can replace this with your desired domain

        // Combine local part and domain to form the email
        return localPart + "@" + domain;
    }

    private static String getRandomString(int length)
    {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        String randomEmail = generateRandomEmail();
        System.out.println("Random Email: " + randomEmail);
    }
}