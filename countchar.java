

//uppgift att räkna saker i en sträng
//termineras om EOF eller radbyte mellan 1 och 10E8



//string input -> dictionary with the the first letter a and then b -> if it already exists 
//-> look for if key exits if not make a key -> a value
//-> if key doent exist make a key with a value 1 

//abfjgkdlfsa
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.TreeMap;

public class countchar {
    public static void main(String[] args) {
        //variables
        TreeMap<String,Integer> countAlfa;
        


        
        Scanner scanner = new Scanner(System.in);
        System.out.print("");
        String string_input = scanner.next();
        scanner.close(); 

        countAlfa = new TreeMap<String, Integer>();

        //filter
        String filterd_letters_string_input = string_input.replaceAll("[^a-zA-Z]","");
        String filterd_to_lower_case_string_input = filterd_letters_string_input.toLowerCase();
        System.out.println(filterd_letters_string_input);
        System.out.println(filterd_to_lower_case_string_input);


        //length
        int lenght_string_input = filterd_to_lower_case_string_input.length();
        System.out.println(lenght_string_input);
        
          
        insertLettersToDic(filterd_to_lower_case_string_input, countAlfa, lenght_string_input);

        System.out.println(countAlfa);
        for (String word : countAlfa.keySet()) {//word gets a to be a key from the countAlfa 
            System.out.println(word + " " + countAlfa.get(word));//thus for each key int countAlfa print the value of the corrispoding key
        }

    }

    public static void insertLettersToDic(String str, TreeMap<String, Integer> dict, Integer length){
        for (int i = 0; length > i; i++){
            String character = String.valueOf(str.charAt(i));//changes the char to a string
            
            if (dict.get(character) == null){
                dict.put(character, 1);
            } else {
                dict.put(character, dict.get(character) + 1);
            }
        }
    } 
}