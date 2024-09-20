import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class SahotaJatinderA1Q4 {
    public static void main(String[] args) {
        int[] input = null;
        try{input = fileToArray(new File("TestThreeSum.txt"));}
        catch(FileNotFoundException e){
            System.out.println("File not FOUND.");
        }

        boolean foundSum = hasThreeSum(input);
        if (foundSum){
            System.out.println("Yes, three elements of the array sum to 0.\nThe elements are: ");
        } else{
            System.out.println("No");
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

    public static boolean hasTargetSum(int[] A, int j, int k, int t){
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
        return answer;
    }

    public static boolean hasThreeSum(int[] A){
        int n = A.length;
        int i = 0;
        boolean answer = false;

        while ((i < n-2) && (!answer)){
            answer = hasTargetSum(A,i+1,n-1,-A[i]);
            i = i+1;
        }

        return answer;
    }
}
