import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if (file.exists()) {
           checkPairs(file);
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static Boolean checkPairs(File file) throws Exception {
        int openParentheses = 0;
        int openBrackets = 0;
        int closeParentheses = 0;
        int closeBrackets = 0;
        int openBraces = 0;
        int closeBraces = 0;
    
        Scanner input = new Scanner(file);
    
        Boolean correct = false;
        while (input.hasNext()){
            String line = input.nextLine();
            String[] words = line.split("");
            for (int i = 0; i <= words.length; i++){
                if (words[i].contains("(")) {
                    openParentheses++;
                } else if (words[i].contains(")")) {
                    closeParentheses++;
                } else if (words[i].contains("[")) {
                    openBrackets++;
                } else if (words[i].contains("]")) {
                    closeBrackets++;
                } else if (words[i].contains("{")) {
                    openBraces++;
                } else if (words[i].contains("}")) {
                    closeBraces++;
                } 
            }
            if (openParentheses == closeParentheses && openBrackets == closeBrackets && openBraces == closeBraces) {
                correct = true;
            }
        }

        return correct;
    }
        
}
