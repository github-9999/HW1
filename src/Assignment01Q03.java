public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");

        int[] fibNums = new int[x];
        int numOdd = 0;

        for (int i = 0; i < x; i++) {
            if (i == 0 || i == 1) {
                fibNums[i] = 1;
            } else {
                fibNums[i] = fibNums[i - 1] + fibNums[i - 2];
            }

            if (fibNums[i] % 2 != 0) {
                numOdd++;
            }
        }

        for (int i = 0; i < x - 1; i++) {
            System.out.print(fibNums[i] + " ");
        }

        // the assumption in this question is x>=3 so verifying x > 0 is not required
        System.out.print(fibNums[x - 1]);

        System.out.println();

        //////////////////////////////////////////////////////////////

        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
