//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        }

    public int[] readFile(){
        return null;
    }

    public boolean hasTargetSum(int[] A, int j, int k, int t){
        boolean answer = false;
        while ((j<k)&&(!answer)){
            if(A[j] + A[k] < 1){
                j = j+1;
            } else if (A[j] + A[k] > 1){
                k = k-1;
            } else {
                answer = true;
            }
        }
        return answer;
    }

    public boolean hasThreeSum(int[] A){
        int n = A.length;
        int i = 0;
        boolean answer = false;

        while ((i < n-2)^(!answer)){
            answer = hasTargetSum(A,i+1,n-1,-A[i]);
            i = i+1;
        }

        return answer;
    }
}
