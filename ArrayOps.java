public class ArrayOps {
    public static void main(String[] args) {

    }
    
    public static int findMissingInt (int [] array) {
        int missingNum = -999;
        int helperArray[] = new int[array.length + 1];
        for (int i=0; i<array.length; i++) {
            helperArray[array[i]] = 1;
        }
        
        for (int j=0; j<helperArray.length; j++) {
            if (helperArray[j] == 0)
                missingNum = j;
        }
        return missingNum;
    }

    public static int secondMaxValue(int [] array) {
        int tempMax = array[0];
        int secondMaxValue = array[0];
        int maxIndex = 0;

        // Find the index and vlaue of the maximal value in the array
        for (int i=0; i<array.length; i++) {
            if (array[i] > tempMax) {
                tempMax = array[i];
                maxIndex = i;
            }
        }

        // Re run over the array and do the same, but skip the index of the maximal value
        for (int j=0; j<array.length; j++) {
            if (j != maxIndex && array[j] > secondMaxValue) {
                secondMaxValue = array[j];
            }
        }
        return secondMaxValue;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean trueHelper = false;
        for (int i=0; i<array1.length; i++) {
            trueHelper = false;
            for (int j=0; j<array2.length; j++) {
                if (array1[i] == array2[j] || trueHelper)
                    trueHelper = true;
            }
            if (!trueHelper)
                return false;
        }
        return true;
    }

    public static boolean isSorted(int [] array) {
        boolean isSortedUp = true;
        boolean isSortedDown = true;
        int firstIndex = 0;

        // Run on the array until you reach the first integer that is different than the last one.
        // Save the index of the said integer
        for (int k=0; k<array.length; k++) {
            if (array[k+1] != array[k]) {
                break;
            }
            firstIndex = k;
        }

        // Check if sorted downwards
        for (int i=firstIndex; i<array.length; i++) {
            if (i != ((array.length) - 1)) {
                if (array[i] < array [i+1]) {
                    isSortedDown = false;
                }
            }
        }

        // Check if sorted upwards
        for (int j=firstIndex; j<array.length; j++) {
            if (j != ((array.length) - 1)) {
                if (array[j] > array [j+1]) {
                    isSortedUp = false;
                }
            }
    }

    if (isSortedDown || isSortedUp)
        return true;
    return false;
}
}