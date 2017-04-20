import me.maeu.sorts.*;
import java.util.Arrays;

public class SortsRun {
    public static void main(String[] args) {
        Integer[] ints = new Integer[] {1, 5, 29, 3, 1, 7, 6, 16, 10};

        System.out.println(Arrays.toString(ints));
        Sorts.heapify(ints);
        System.out.println(Arrays.toString(ints));
        Sorts.heapSort(ints);
        System.out.println(Arrays.toString(ints));

    }
}
