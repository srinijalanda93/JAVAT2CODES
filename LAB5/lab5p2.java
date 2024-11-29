package LAB5;

//interface
interface WaterConservationSystem {
   //abstract method without body
    int calculateTrappedWater(int[] blockHeights);
}

// A_Class with implements of the interface
abstract class RainySeasonConservation implements WaterConservationSystem {
    public void some(){
        System.out.println("its raining season");
    }
}

// sub class extending the abstract class
class CityBlockConservation extends RainySeasonConservation {
 //it's overriding
    public int calculateTrappedWater(int[] blockHeights) {
        int n = blockHeights.length;
        if (n == 0) return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left <= right) {
            if (blockHeights[left] <= blockHeights[right]) {
                if (blockHeights[left] >= leftMax) {
                    leftMax = blockHeights[left]; // Update the max height on the left
                } else {
                    totalWater += leftMax - blockHeights[left]; // Calculate trapped water
                }
                left++;
            } else {
                if (blockHeights[right] >= rightMax) {
                    rightMax = blockHeights[right]; // Update the max height on the right
                } else {
                    totalWater += rightMax - blockHeights[right]; // Calculate trapped water
                }
                right--;
            }
        }

        return totalWater;
    }
}

// Main class to test the implementation
public class lab5p2 {
    public static void main(String[] args) {
        // Create an instance of CityBlockConservation
        CityBlockConservation conservation = new CityBlockConservation();

        // Test Case 1
        int[] blockHeights1 = {3, 0, 0, 2, 0, 4};
        System.out.println("Trapped Water (Test Case 1): " + conservation.calculateTrappedWater(blockHeights1));
        // Expected Output: 10

        // Test Case 2
        int[] blockHeights2 = {3, 0, 2, 0, 4};
        System.out.println("Trapped Water (Test Case 2): " + conservation.calculateTrappedWater(blockHeights2));
        // Expected Output: 7

        // Additional Test Case (optional)
        int[] blockHeights3 = {1, 2, 3, 4, 5};
        System.out.println("Trapped Water (Test Case 3): " + conservation.calculateTrappedWater(blockHeights3));
        // Expected Output: 0 (No water trapped as the heights are non-decreasing)
    }
}

