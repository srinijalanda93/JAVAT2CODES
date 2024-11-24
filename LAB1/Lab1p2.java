import java.util.*;
//scanner class changes
class AlphabetWarGame {

    private int w = 4, p = 3, b = 2, s = 1;
    private int m = 4, q = 3, d = 2, z = 1;

    // dconstructor with  strengths
    public AlphabetWarGame() {
        System.out.println("Alphabet War Game: Default Strengths Loaded");
    }

    // Pconstructor to allow custom strengths
    public AlphabetWarGame(int w, int p, int b, int s, int m, int q, int d, int z) {
        this.w = w;
        this.p = p;
        this.b = b;
        this.s = s;
        this.m = m;
        this.q = q;
        this.d = d;
        this.z = z;
        System.out.println("Alphabet War Game: Custom Strengths Loaded");
    }

    // Method to assign strength based on character (for both sides)
    private int getStrength(char ch) {
        switch (ch) {
            case 'w': return w;
            case 'p': return p;
            case 'b': return b;
            case 's': return s;
            case 'm': return m;
            case 'q': return q;
            case 'd': return d;
            case 'z': return z;
            default: return 0; // Characters that don't contribute to the battle
        }
    }

    // Method Overloading: Calculate the winner with a single input string
    public String calculateWinner(String input) {
        int n = input.length(); // length of the string
        int leftBattleSum = 0, rightBattleSum = 0; // Initialize sums to zero

        if (n % 2 == 0) { // If the length is even
            // Left side loop: From 0 to n/2 (excluding n/2)
            for (int i = 0; i < n / 2; i++) {
                leftBattleSum += getStrength(input.charAt(i));
            }

            // Right side loop: From n/2 to end of the string
            for (int j = n / 2; j <=n-1; j++) {
                rightBattleSum += getStrength(input.charAt(j));
            }
        } else { // If the length is odd
            // Left side loop: From 0 to n/2 (excluding the middle)
            for (int i = 0; i < n / 2; i++) {
                leftBattleSum += getStrength(input.charAt(i));
            }

            // Middle character
            char middleChar = input.charAt(n / 2);

            // Right side loop: From (n/2 + 1) to end of the string
            for (int j = (n / 2) + 1; j < n; j++) {
                rightBattleSum += getStrength(input.charAt(j));
            }

            // Check for a tie and resolve using the middle character
            if (leftBattleSum == rightBattleSum) {
                if (getStrength(middleChar) > 0) {
                    //found return the index of the character
                    if ("wpbs".indexOf(middleChar) != -1) {  // Middle character belongs to left team
                        leftBattleSum += getStrength(middleChar);
                    } else {  // Middle character belongs to right team
                        rightBattleSum += getStrength(middleChar);
                    }
                }
            }
        }

        // Determine the winner
        if (leftBattleSum > rightBattleSum) {
            return "Left side wins!";
        } else if (rightBattleSum > leftBattleSum) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    // Method Overloading: Calculate the winner with two separate left and right strings
    public String calculateWinner(String leftSide, String rightSide) {
        int leftBattleSum = 0, rightBattleSum = 0; // Initialize sums to zero

        // Loop through the left-side string and calculate left-side strength
        for (int i = 0; i < leftSide.length(); i++) {
            leftBattleSum += getStrength(leftSide.charAt(i));
        }

        // Loop through the right-side string and calculate right-side strength
        for (int i = 0; i < rightSide.length(); i++) {
            rightBattleSum += getStrength(rightSide.charAt(i));
        }

        // Determine the winner
        if (leftBattleSum > rightBattleSum) {
            return "Left side wins!";
        } else if (rightBattleSum > leftBattleSum) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }
}

public class Lab1p2 {
    public static void main(String[] args) {
        // Create a new AlphabetWarGame object with default strengths
        AlphabetWarGame defaultGame = new AlphabetWarGame();

        // Test cases with default strengths
        System.out.println(defaultGame.calculateWinner("zdqmwpbs")); // expected: Let's fight again!
        System.out.println(defaultGame.calculateWinner("wwwwwwz"));  // expected: Left side wins!
        System.out.println(defaultGame.calculateWinner("wbzzzspqds")); // expected: Left side wins!

        // Using method overloading with separate left and right strings
        System.out.println(defaultGame.calculateWinner("wpbs", "zmdq")); // expected: Let's fight again!

        // Custom strengths (customizing the constructor)
        AlphabetWarGame customGame = new AlphabetWarGame(5, 3, 2, 1, 6, 4, 2, 1);  // Custom strengths
        System.out.println(customGame.calculateWinner("zdqmwpbs")); // expected: (depends on custom strengths)

        // Using method overloading with custom strengths
        System.out.println(customGame.calculateWinner("wbb", "zqd")); // Custom outcome
    }
}



