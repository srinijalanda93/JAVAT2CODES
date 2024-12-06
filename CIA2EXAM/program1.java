package CIA2EXAM;
import java.util.Arrays;
import java.util.*;

interface TransactionAnalyzer {
    //method of abstract which implements the target sum alignments
    int countpairs(int[] arrprices, int target);
}
class RetailTransactionAnalyzer implements TransactionAnalyzer {
    public int countpairs(int[] arr, int target) {
        int paircount = 0;
        //here its compare each element with every other element
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // If we find a pair that sums to target, increment the counter
                if (arr[i] + arr[j] == target) {
                    System.out.println("so these are number paris(" +arr[i]+","+arr[j]+") whose target is "+target);
                    paircount++;
                }
            }
        }

        return paircount;
    }
}

public class program1 {
    public static void main(String[] args) {
        TransactionAnalyzer analyzer = new RetailTransactionAnalyzer();
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the size of the array: ");
        int size = sc.nextInt();

        // Create and read array elements
        int[] prices = new int[size];
        System.out.println("enter " + size + " array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("enter the element at index"+i+": ");
            prices[i] = sc.nextInt();
        }

        // read target sum
        System.out.print("enter the target sum: ");
        int target = sc.nextInt();

        // final print the result
        System.out.println("no of pairs with sum " + target + ": " + analyzer.countpairs(prices, target));



        //e2
//        int[] prices1 = {1, 5, 7, -1, 5};
//        int target1 = 6;
//        System.out.println("Example 1 Output: " + analyzer.countpairs(prices1, target1));
//
//        //e1
//        int[] prices2 = {2, 4, 3, 5, 6};
//        int target2 = 8;
//        System.out.println("Example 2 Output: " + analyzer.countpairs(prices2, target2));
    }
}
