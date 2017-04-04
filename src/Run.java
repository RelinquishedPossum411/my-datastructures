import me.maeu.structures.*;

public class Run {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);

        System.out.println(bst.inOrder());
    }
}