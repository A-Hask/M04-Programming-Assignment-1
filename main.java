import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if (file.exists()) {
            if (checkPairs(file)) {
                System.out.println("The pairs are correct");
            } else {
                System.out.println("The pairs are incorrect");
            }
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static Boolean checkPairs(File file) throws Exception {

        Scanner input = new Scanner(file);
        Stack<String> stack = new Stack<>();

        while (input.hasNext()){
            String line = input.nextLine();
            String[] words = line.split("");
            for (int i = 0; i < words.length; i++){
                if (words[i].equals("(")) {
                    stack.push("(");
                } else if (words[i].equals(")")) {
                  	// If the stack is empty, symbols are not balanced
                    if(stack.isEmpty()) {
                        return false;
                    }
                  	// If the symbol does not match, symbols are overlapped
                    if(!stack.pop().equals("(")) {
                        return false;
                    }
                } else if (words[i].equals("[")) {
                    stack.push("[");
                } else if (words[i].equals("]")) {
                    if(stack.isEmpty()) {
                        return false;
                    }
                  	if(!stack.pop().equals("[")) {
                        return false;
                    }
                } else if (words[i].equals("{")) {
                    stack.push("{");
                } else if (words[i].equals("}")) {
                    if(stack.isEmpty()) {
                        return false;
                    }
                  	if(!stack.pop().equals("{")) {
                        return false;
                    }
                }
            }
        }

      	// Check if stack is empty, if it isn't symbols are not balanced
        if(stack.isEmpty()) {
          	return true;
        } else {
          	return false;
        }
    }

}
