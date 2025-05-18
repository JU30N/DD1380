
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeMap;

public class countchar {
    public static void main(String[] args) {
        //variables
        TreeMap<Character, Integer> countAlfa = new TreeMap<>();//treemap sorts everything in order from beginning 
        
        Scanner scanner = new Scanner(System.in);
        
        



        while (scanner.hasNextLine()){
            String string_input = scanner.nextLine();
            //System.out.println(string_input);
            if (string_input.isEmpty()){//break if scanner is empty
                break;
            }
            String filterd_letters_string_input = string_input.replaceAll("[^a-zA-Z]","").toUpperCase().replaceAll(" ", "");//filter
                
            int lenght_string_input = filterd_letters_string_input.length();
            //System.out.println(lenght_string_input);
            if (lenght_string_input == 0){
                System.out.println("0");
                break;
            }
            
            
            insert_letters_to_dic(filterd_letters_string_input, countAlfa, lenght_string_input);//inputed TreeMap and filtered letter and lenght 
            
        }
        scanner.close();
        
        for (Character word : countAlfa.keySet()) {//word gets a to be a key from the countAlfa 
            System.out.println(word + ":" + countAlfa.get(word));//thus for each key int countAlfa print the value of the corrispoding key
        }

    }

    public static void insert_letters_to_dic(String str, TreeMap<Character, Integer> dict, Integer length){
        for (int i = 0; length > i; i++){
            Character character = Character.valueOf(str.charAt(i));//changes the char to a string example hello take h and change to character
            
            if (dict.get(character) == null){
                dict.put(character, 1);
            } else {
                dict.put(character, dict.get(character) + 1);
            }
        }
    } 
}