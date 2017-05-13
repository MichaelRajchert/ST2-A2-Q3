import java.util.ArrayList;

/**
 * Created by MichaelRajchert on 28/04/2017.
 */
public class main {
    public static BST_Node bstNode = new BST_Node();
    public static BST bst = new BST();

    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<>();
        array.add(50);
        array.add(30);
        array.add(55);
        array.add(25);
        array.add(35);
        array.add(52);
        array.add(60);
        array.add(10);
        array.add(32);
        array.add(37);
        array.add(65);
        array.add(15);

        bst.addRange(array);
        for (int i = 0; i <= 4; i++){
            System.out.println("Level " + i + ": " + bst.FindNodeValuesAtLevel(i));
        }
    }
}
