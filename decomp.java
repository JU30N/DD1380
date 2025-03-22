
//sju: 0 7; sjö: 4 13; ka 10; män: 16"
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
        String input = "sju: 0 7; sjö: 4 13; ka: 10; män: 16";

        List<Character> char_list = new ArrayList<>();

        //dela upp ;
        String[] input_parts = input.split("; ");


        //for(int i = 0; i < input_parts.length; i++){
        //    System.out.println(input_parts[i]);
        //}
        
        //ta bort : 
        for(String words : input_parts){
            String[] word_and_numbers = words.split(": ");
            //for(String word : word_and_numbers){
            //    System.out.println(word); 
            //}
            // ["sju","0 7"]
            for(int i=0; i < word_and_numbers.length;){
                String the_word = word_and_numbers[i];
                String the_numbers = word_and_numbers[(i+1)];
                System.out.println(the_word +" " + the_numbers);
                i = i + 2;
                //cut sju
                for(){
                    String[] cut_the_word = 
                }



            //[s ,j ,u ,  ,s ,j ,ö ,s ,j ,u ,k ,a ,  ,s ,j ,ö ,m ,ä ,n]

            }
        }        



        

    }
}

