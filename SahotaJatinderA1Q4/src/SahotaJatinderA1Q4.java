import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class SahotaJatinderA1Q4 {

    /**
     * Takes a text file and checks if three elements of line 2 sum to 0.
     * Prints the values summing to 0 if they are present.
     *
     * @param args Array containing the filename
     */
    public static void main(String[] args) {

        int[] input = null;
        try {
            input = fileToArray(new File(args[0]));
        } catch(FileNotFoundException e) {
            System.out.println("Please ensure the file is located in the same folder as this file\n" +
                    "and double check that the filename is typed correctly.");
        }

        String[] results = hasThreeSum(input);

        //foundSum[0] will contain 'true' or 'false.'
        boolean foundSum = Boolean.parseBoolean(results[0]);
        if (foundSum){
            System.out.println("Yes, three elements of the array sum to 0.\nThe elements are: "
                    + Integer.parseInt(results[1]) + ", " + Integer.parseInt(results[2]) + ", "
                    + Integer.parseInt(results[3]));
        } else{
            System.out.println("No, there are no three integers that sum to 0.");
        }
    }

    /**
     * Reads a text file and outputs the characters of line 2 in an int array.
     * Size of the array is dictated by the character on line 1.
     *
     * @param file Name of the file to read.
     * @throws FileNotFoundException File misplaced or typed incorrectly.
     * @return The array of integers read from the file.
     */
    public static int[] fileToArray(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        //sc reads line 1 of the file to get the size of the array.
        //After, the scanner moves on to line 2.
        int[] arr = new int[Integer.parseInt(sc.nextLine())];

        //The characters on line 2 are placed into a String array 'tokens.'
        String[] tokens = sc.nextLine().split(" ");
        sc.close();

        //Each element of 'tokens' is parsed into an Integer and placed into 'arr.'
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        return arr;
    }

    /**
     * Checks if a sorted array contains two elements that sum to some integer.
     * Returns a string containing the result of the check and three numbers (as Strings).
     *
     * @param A Sorted array of possible candidates that may sum to t.
     * @param j Left pointer checking 'left-side' values of A.
     * @param k Right pointer checking 'right-side' values of A.
     * @param t Target integer to find values A[j] and A[k] that sum to it.
     * @return An array containing the result of the check and three numbers (all as Strings).
     *    If two integers sum to t, then 'true,' -t, and the two integers are returned.
     *    If not, then 'false,' -t, and two null Strings are returned.
     */
    public static String[] hasTargetSum(int[] A, int j, int k, int t){
        boolean answer = false;

        //While left pointer and right pointer have not crossed,
        //and an answer has not been found.
        while ((j<k)&&(!answer)){
            //If sum of current values is too small
            if (A[j] + A[k] < t){
                j = j+1;
            }
            //If sum of current values is too big
            else if (A[j] + A[k] > t){
                k = k-1;
            }
            //A[j] + A[k] = t
            else {
                answer = true;
            }
        }

        String[] results = new String[4];
        results[0] = Boolean.toString(answer);

        //If we found two integers, we return 'true'
        //and all three integers that sum to zero.
        if (answer){
            results[1] = Integer.toString(A[j]);
            results[2] = Integer.toString(A[k]);
            results[3] = Integer.toString(-t);
        }

        //We can leave null values when no integers sum to zero.
        return results;
    }

    /**
     * Checks if any two elements of a sorted array sum to some other integer in the array.
     * Returns an array containing the result of the check and three integers.
     * Calls hasTargetSum() to check if any element of the array is a sum of two other elements.
     *
     * @param A An array of integers.
     * @return An array containing the result of the check and three integers as Strings.
     *   If the result is 'true,' the three integers returned sum to zero.
     *   If not, then 'false,' A[n-3] and two "null" values are returned.
     */
    public static String[] hasThreeSum(int[] A){
        int n = A.length;
        int i = 0;
        boolean answer = false;
        String[] results = new String[4];

        while ((i < n-2) && (!answer)){
            //Check for -A[i] since A[j] + A[k} = -A[i] iff. A[j] + A[k] + A[i] = 0.
            results = hasTargetSum(A,i+1,n-1,-A[i]);

            //results[0] is the result of the check.
            answer = Boolean.parseBoolean(results[0]);
            i = i+1;
        }

        return results;
    }
}
