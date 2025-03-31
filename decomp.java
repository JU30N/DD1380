
//sju: 0 7; sjö: 4 13; ka: 10; män: 16"
//  0   4   7  10  13 16
//[sju sjö sju ka sjö män]

//[0 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10,11,12,13,14,15,16,17,18,19,20]
//[s ,j ,u ,  ,s ,j ,ö ,s ,j ,u ,k ,a ,  ,s ,j ,ö ,m ,ä ,n]

//input "sju: 0 7; sjö: 4 13; ka 10; män: 16"
//take each sju: 0 7; -> list
//add s, j ,u from 0 to 2 and 7 to 9
//print out the list

//second idea
//array [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
// sju put in in 0
// length of sju is 3 so on so 
//[sju,1,2,3,sjö,5,6,sju,8,9,ka,11,12,sjö,14,15,män,17,18,19,20]
// sju,1,2 is one word because sju is 3 letters 
// sjö,5,6
// sju,8,9
// ka,11
// sjö,14,15
// män,17,18
// thus 3, 12 doesnt have any letters therfore become spaces
// a = "              "
import java.util.*;

public class decomp {
    public static void main(String[] args ) {
        //var
        
        //String input = "sju: 0 7; sjö: 4 13; ka: 10; män: 16";
        String input = " h,: 18 24 51 57 84 90 96; h!: 30 63 102; She loves you,: 0 33 66; yea: 15 21 27 48 54 60 81 87 93 99;";

        Scanner scanner = new Scanner(System.in);
        System.out.print("");
        //String input = scanner.nextLine();
        scanner.close();

        List<Character> char_list = new ArrayList<>();

        //dela upp ;
        String[] input_parts = input.split(";");
        
        //["sju: 0 7", " sjö: 4 13"]
        //ta bort : 
        for(String words : input_parts ){
            String[] word_and_numbers = words.split(":");
            
            // ["sju", "0 7"]
            String word = word_and_numbers[0];
            word = word.trim();
            String[] numbers = word_and_numbers[1].trim().split(" ");
            //[0, 7]
            
            String[] split_word = word.split("");
            
            // [s, j, u] (length is 3)      [0, 7]
            for(String placement_number : numbers){
                
                int placement = Integer.parseInt(placement_number);
                for (int i = 0; i < word.length(); i++){
                    while(char_list.size() <= placement + i){
                        char_list.add(' ');
                    }
                    char_list.set(placement + i, split_word[i].charAt(0));
                }      
            }
            //[s ,j ,u ,  ,s ,j ,ö ,s ,j ,u ,k ,a ,  ,s ,j ,ö ,m ,ä ,n]
        }        
        //System.out.println(char_list);
        for(int i = 0; i < char_list.size(); i++){
            System.out.print(char_list.get(i));
        }
    }
}

