import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {

        // the question allows to assume 'array' is not null
        if (array.length == 0) {
            return array;
        }

        if (direction != 'R' && direction != 'L') {
            return array;
        }

        int n = array.length;

        if (direction == 'L') {
            move = -move;
        }

        move = move % n;
        if (move < 0) {
            move = (move + n) % n;
        }

        if (move == 0) {
            return array;
        }

        int[] temp = new int[move];
        for (int i = 0; i < move; i++) {
            temp[i] = array[n - move + i];
        }

        for (int i = n - 1; i >= move; i--) {
            array[i] = array[i - move];
        }

        for (int i = 0; i < move; i++) {
            array[i] = temp[i];
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 0, 8, 9, 5, 6 }, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] {}, 3, 'R'))); // []
    }
}