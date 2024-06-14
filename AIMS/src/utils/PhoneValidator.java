package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    // Define the regular expression for a valid phone number
    // This regex matches phone numbers like:
    // +1234567890, 123-456-7890, (123) 456-7890, 123 456 7890, 123.456.7890, +91 (123) 456-7890
    private static final String PHONE_REGEX = "^(\\+\\d{1,3}[- ]?)?\\(?\\d{1,4}\\)?[- ]?\\d{1,4}[- ]?\\d{1,4}[- ]?\\d{1,9}$";

    // Compile the regex into a pattern
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    // Function to validate phone number
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false; // Null phone numbers are not valid
        }
        Matcher matcher = PHONE_PATTERN.matcher(phoneNumber);
        return matcher.matches();
    }
}
