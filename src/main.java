import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MichaelRajchert on 28/04/2017.
 */
public class main {
    public static BST_Node bstNode = new BST_Node();
    public static BST bst = new BST();

    public static void main(String[] args){
        Scanner usrInput = new Scanner(System.in);
        String input = usrInput.nextLine();
        ArrayList<Integer> array = getUserInput(input);

        bst.addRange(array);
        for (int i = 0; i <= 4; i++){
            System.out.println("Level " + i + ": " + bst.FindNodeValuesAtLevel(i));
        }
    }

    public static ArrayList<Integer> getUserInput(String input){
        ArrayList<Integer> output = new ArrayList<>();
        String[] inputArray = input.split(" ");
        for (int i  = 0; i < inputArray.length; i++){
            output.add(Integer.parseInt(inputArray[i]));
        }
        return output;
    }
}
