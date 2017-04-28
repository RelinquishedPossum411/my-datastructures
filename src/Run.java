import me.maeu.structures.*;

public class Run {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(10);
        bst.add(7);
        bst.add(20);
        bst.add(9);
        bst.add(8);
        bst.add(3);
        bst.add(15);

        System.out.println(bst.leafCount());

        ArrayTreeHeap<Integer> ah = new ArrayTreeHeap<>();
        ah.add(80);
        ah.add(62);
        ah.add(70);
        ah.add(59);
        ah.add(20);
        ah.add(15);
        ah.add(39);
        ah.add(52);
        ah.add(89);

        ah.inOrder(0);

        ListArray<Integer> ar = new ListArray<>();
        ar.add(5);
        ar.add(5);
        ar.add(5);
        ar.insert(2, 3);
        ListArray<Integer> as = ar.sublist(0, 2);
        System.out.println(ar);
        System.out.println(as + " " + as.size());
    }
}