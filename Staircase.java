public class Staircase {
    public static int countWaysDP(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1; // Base case: one way to climb zero steps (no further steps to climb)
        } else if (map[n] > -1) {
            return map[n]; // Return the cached result if available
        } else {
            // Calculate the number of ways by recursively summing up ways for 1, 2, and 3 steps
            map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map) + countWaysDP(n - 3, map);
            return map[n];
        }
    }

    public static void main(String[] args) {
        int n = 4; // Change this value to the number of steps you want to count ways for
        int[] map = new int[n + 1]; // Create an array for memoization

        // Initialize the map with -1 to indicate that results are not cached yet
        for (int i = 0; i <= n; i++) {
            map[i] = -1;
        }

        int ways = countWaysDP(n, map);
        System.out.println("Number of ways to climb " + n + " steps: " + ways);
    }
}

// javac Staircase.java
// java Staircase
