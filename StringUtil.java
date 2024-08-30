public class StringUtil {

    /**
     * Capitalizes the first letter of the given string.
     * @param input the string to capitalize
     * @return the string with the first letter capitalized
     */

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true; // Flag to capitalize the first letter of each word

        for(char aChar : input.toCharArray()) {
            if(Character.isWhitespace(aChar)) {
                capitalizeNext = true;         // set the Flag
                result.append(aChar);
            }
            else if (capitalizeNext) {
                result.append(Character.toUpperCase(aChar));
                capitalizeNext = false;
            }
            else {
                result.append(Character.toLowerCase(aChar));
            }
        }
    

    return result.toString();

}
}

