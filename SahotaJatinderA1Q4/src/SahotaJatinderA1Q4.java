import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class SahotaJatinderA1Q4 {
    public static void main(String[] args) {
        int[] input = null;
        try{input = fileToArray(new File(args[0]));}
        catch(FileNotFoundException e){
            System.out.println("File not FOUND.");
        }

        String[] results = hasThreeSum(input);
        boolean foundSum = Boolean.parseBoolean(results[0]);
        if (foundSum){
            System.out.println("Yes, three elements of the array sum to 0.\nThe elements are: "
                    + Integer.parseInt(results[1]) + ", " + Integer.parseInt(results[2]) + ", "
                    + Integer.parseInt(results[3]));
        } else{
            System.out.println("No, there are no three integers that sum to 0.");
        }
    }

    public static int[] fileToArray(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        int[] sortedArr = new int[Integer.parseInt(sc.nextLine())];
        String[] tokens = sc.nextLine().split(" ");
        for (int i = 0; i < sortedArr.length; i++) {
            sortedArr[i] = Integer.parseInt(tokens[i]);
        }

        sc.close();

        return sortedArr;
    }

    public static String[] hasTargetSum(int[] A, int j, int k, int t){
        boolean answer = false;
        while ((j<k)&&(!answer)){
            if(A[j] + A[k] < t){
                j = j+1;
            } else if (A[j] + A[k] > t){
                k = k-1;
            } else {
                answer = true;
            }
        }

        String[] results = new String[4];
        results[0] = Boolean.toString(answer);
        if (answer){
            results[1] = Integer.toString(A[j]);
            results[2] = Integer.toString(A[k]);
            results[3] = Integer.toString(-t);
        }
        return results;
    }

    public static String[] hasThreeSum(int[] A){
        int n = A.length;
        int i = 0;
        boolean answer = false;
        String[] results = new String[4];

        while ((i < n-2) && (!answer)){
            results = hasTargetSum(A,i+1,n-1,-A[i]);
            answer = Boolean.parseBoolean(results[0]);
            i = i+1;
        }

        return results;
    }
}
