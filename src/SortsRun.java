import me.maeu.sorts.*;
import java.util.Arrays;

public class SortsRun {
    public static void main(String[] args) {
        Integer[] ints = new Integer[] {1, 5, 29, 3, 1, 7, 6, 16, 10};
        Integer[] stuff = new Integer[] {10, 3, 2, 29, 1, 15, 3};
        int[] ar = new int[] {5, 3, 2, 1, 10, 39, 5, 1, 7};

        System.out.println(Arrays.toString(ints));
        Sorts.heapify(ints);
        System.out.println(Arrays.toString(ints));
        Sorts.heapSort(ints);
        System.out.println(Arrays.toString(ints));

        System.out.println(Arrays.toString(stuff));
        Sorts.quickSort(stuff);
        System.out.println(Arrays.toString(stuff));

        System.out.println(Arrays.toString(ar));
        ar = Sorts.countingSort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
