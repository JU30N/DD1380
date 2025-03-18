

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

public class countchar {
    public static void main(String[] args) {
        Dictionary<String, Integer> dAlphabet = new Hashtable<>();
        

        //String keyToCheck = "Bob";

        
        Scanner scanner = new Scanner(System.in);
        System.out.print("");
        String string_input = scanner.next();
        scanner.close(); 

        //filter
        String filterd_letters_string_input = string_input.replaceAll("[^a-zA-Z]","");
        System.out.println(filterd_letters_string_input);


        //length
        int lenght_string_input = filterd_letters_string_input.length();
        System.out.println(lenght_string_input);
        
        //if (dictionary.get(keyToCheck) != null) {
          
        insertLettersToDic(filterd_letters_string_input, dAlphabet, lenght_string_input);

        int numberOfKeys = dAlphabet.size();
        for (int i = 0; numberOfKeys > i; i++){
            String key = dAlphabet.keys();
            System.out.println();
        }

    }

    public static void insertLettersToDic(String str, Dictionary<String, Integer> dict, Integer length){
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