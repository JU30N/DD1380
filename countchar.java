import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



//uppgift att räkna saker i en sträng
//termineras om EOF eller radbyte mellan 1 och 10E8



public class countchar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("");
        String string_list = scanner.next();
        scanner.close();
        
        int length_string_list = string_list.length();
        int count_letters = 0;
        ArrayList<String> list_of_letters = new ArrayList<>();

        string_list = string_list.toLowerCase();//gör allt till små bokstäver
        
        for (int i = 0; i < length_string_list; i++){//loopar antal gånger som strängen
            char ch = string_list.charAt(i);
            //System.out.println(ch);
            boolean isAlphabet = (""+ch).matches("[a-z]");


            if (isAlphabet){//kollar om det är en bokstav
                list_of_letters.add(""+ch);
                count_letters++;
            }

        }      
        System.out.println(count_letters);
        System.out.println(list_of_letters);
    }
}
