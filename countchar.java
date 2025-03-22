
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.TreeMap;

public class countchar {
    public static void main(String[] args) {
        //variables
        TreeMap<Character,Integer> countAlfa;
        


        
        Scanner scanner = new Scanner(System.in);
        System.out.print("");
        countAlfa = new TreeMap<Character, Integer>();
        while (scanner.hasNextLine()){
            String string_input = scanner.nextLine();
            //System.out.println(string_input);
            if (string_input.isEmpty()){
                break;
            }
            String filterd_letters_string_input = string_input.replaceAll("[^a-zA-Z]","").toUpperCase().replaceAll(" ", "");
                
            int lenght_string_input = filterd_letters_string_input.length();
            //System.out.println(lenght_string_input);
            if (lenght_string_input == 0){
                System.out.println("0");
                break;
            }
            
            
            insertLettersToDic(filterd_letters_string_input, countAlfa, lenght_string_input);
            
        }
        scanner.close();
        
        for (Character word : countAlfa.keySet()) {//word gets a to be a key from the countAlfa 
            System.out.println(word + ":" + countAlfa.get(word));//thus for each key int countAlfa print the value of the corrispoding key
        }

    }

    public static void insertLettersToDic(String str, TreeMap<Character, Integer> dict, Integer length){
        for (int i = 0; length > i; i++){
            Character character = Character.valueOf(str.charAt(i));//changes the char to a string
            
            if (dict.get(character) == null){
                dict.put(character, 1);
            } else {
                dict.put(character, dict.get(character) + 1);
            }
        }
    } 
}