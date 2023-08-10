package UtilMethods;

import java.util.Random;

public class RandomNameGenerator
{
    private static final String[] FIRST_NAMES =
            {
            "Alice", "Bob", "Charlie", "David", "Ella", "Frank", "Grace",
            "Henry", "Isabella", "Jack", "Kate", "Liam", "Mia", "Noah", "Olivia" ,
                    "Anderson", "Brown", "Clark", "Davis", "Evans", "Foster", "Garcia",
                    "Harris", "Jackson", "Kelly", "Lee", "Martin", "Nelson", "O'Connor",
            // Add more first names as needed
    };

    private static final String[] LAST_NAMES =
            {
             "Ram", "Shyam", "Shiv",
            // Add more last names as neededbb
    };

    public static void main(String[] args)
    {
        String randomName = generateRandomName();
        System.out.println("Random Name: " + randomName);
    }

    public static String generateRandomName()
    {
        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }
}
