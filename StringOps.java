public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {

    }

    public static String capVowelsLowRest (String string) {
        String newString1 = "";
        String newString2 = "";

        // Make everything lower case
        newString1 = toLowerCase (string);
        
        // Second iteration handles the vowels
        for (int j=0; j<newString1.length(); j++) {
            switch(newString1.charAt(j)) {
                case 'a':
                    newString2 += "A";
                    break;
                case 'e':
                    newString2 += "E";
                    break;
                case 'i':
                    newString2 += "I";
                    break;
                case 'o':
                    newString2 += "O";
                    break;
                case 'u': 
                    newString2 += "U";
                    break;
                default:
                    newString2 += newString1.charAt(j);
            }
        }

        return newString2;
    }

    public static String camelCase (String string) {
        String allLower = "";
        String camelCased = "";
        int indexOfFirstChar = 0;
        char currentChar;

        // Make everything lower case first
        allLower = toLowerCase(string);

        // Run over every space before the string starts
        while (allLower.charAt(indexOfFirstChar) == ' ') {
            indexOfFirstChar++;
        }

        int flags[] = new int[allLower.length() - indexOfFirstChar];

        // Run over the string, starting from the first char
        for (int i=indexOfFirstChar; i<allLower.length(); i++) {
            currentChar = allLower.charAt(i);

            // If the character is a space and the next one is any letter
            if (currentChar == ' ') {
                flags[i-indexOfFirstChar] = 1;
            }
        }

        for (int j=0; j<flags.length; j++) {
            if (flags[j] == 0) {
                if (j>0 && flags[j-1] == 1) {
                    camelCased += (char)(allLower.charAt(j + indexOfFirstChar) - 32);
                }
                else {
                    camelCased += allLower.charAt(j + indexOfFirstChar);
                }
            }
        }
        return camelCased;
    }

    public static int[] allIndexOf (String string, char chr) {
        int indexesCounter = 0;
        for (int i=0; i<string.length(); i++) {
            if (string.charAt(i) == chr) {
                indexesCounter++;
            }
        }
        int[] indexes  = new int [indexesCounter];
        indexesCounter = 0;
        for (int i=0; i<string.length(); i++) {
            if (string.charAt(i) == chr) {
                indexes[indexesCounter] = i;
                indexesCounter++;
            }
        }
        return indexes;
    }

    public static String toLowerCase(String s) {
        // Replace the following statement with your code
        String allLower = "";
        for (int i=0; i<s.length(); i++) {
            if (64 < s.charAt(i) && s.charAt(i) < 91) 
                allLower += (char)(s.charAt(i) + 32);
            else
                allLower += (char)(s.charAt(i));
        }
        return allLower;
    }
}
