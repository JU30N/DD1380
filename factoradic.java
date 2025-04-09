// 654320
// 25
// 
// 654320 från höger till vänster
// 0 2 3 4 5 6
// 1!*0 + 2!*2 + 3!*3 + 4!*4 + 5!*5 + 6!*6 = 5038
// 654320 -> 5038
// 
// 25 från höger till vänster
// hitta minsta fakturent till 25
// 1! = 1, 2! = 2, 3! = 6, 4! = 24, 5! = 120
// 4!
// 25/4! = 25/24 = 1 + 1/24 = 1 rest 1
// 25 - 1*24 = 1
// 1/3! = 0
// 1/2! = 0
// 1/1! = 1
// 25 -> 1001
import java.util.ArrayList;
import java.util.List;


public class factoradic {
    public static void main(String[] args){
        int test = to_factoradic("654320");
        System.out.println(test);

        List<Integer> test2 = from_factoradic(25);
        //System.out.println();
        for (int o = test2.size() - 1; o >= 0; o--) {
            System.out.print(test2.get(o));
        }

    }

    public static int get_factorial_sum(int j){
        int factorial_sum = 1;
        for(int i = 1; i <= j; i++){
            factorial_sum *= i;
        }
        return factorial_sum;
    }


// 654320 -> 5038
// 654320 -> read from right to left -> 0 -> for loop n = 1, total_sum = 0 -> 0 times n! + total_sum -> loop till last number
// read antal numbers 654320 -> 6 -> 6! is the last one
    public static int to_factoradic(String n){
        String input = n;
       // System.out.println("input: " + input);

        int number_of_digits = input.length();
        //System.out.println("number_of_digits: " + number_of_digits);
        int k = 1;
        int total_sum = 0;

        while(number_of_digits > (k-1)){
            int digit = Character.getNumericValue(input.charAt(((number_of_digits -(k - 1)) - 1)));
            //System.out.println("digit: " + digit);
            //System.out.println("k: " + k);
            int factorial = get_factorial_sum(k);
            //System.out.println("factorial: " + factorial);
            total_sum += digit * factorial;
            //System.out.println("total_sum: " + total_sum);
            k++;
        }
        return total_sum;
    }


    public static int get_min_factorial(int num){

        int f = 1;
        int factorial_divided_input_number = 100;
        int min_factorial = 0;

        while (factorial_divided_input_number > 1){
            int factorial = get_factorial_sum(f);
            //System.out.println("factorial: " + factorial);
            //System.out.println("input_number: " + num);
            factorial_divided_input_number = num / factorial;
            //System.out.println("factorial_divided_input_number: " + factorial_divided_input_number);
            min_factorial = factorial;
            f++;
        }
        return min_factorial;
    }

    public static int find_factorial_for_number(int num) {
        int f = 1; 
        int factorial = 1;
    
        
        while (factorial <= num) {
            f++;
            factorial = get_factorial_sum(f);
        }
    
        return f - 1;
    }


// 25 -> 1001
    public static List<Integer> from_factoradic(int input_number){
        List<Integer> numb_to_fac = new ArrayList<>();
        // hitta minsta fakturent till 25
        // 1! = 1, 2! = 2, 3! = 6, 4! = 24, 5! = 120
        // 25 från höger till vänster
        // hitta minsta fakturent till 25
        // 1! = 1, 2! = 2, 3! = 6, 4! = 24, 5! = 120
        // 4!
        // 25/4! = 25/24 = 1 + 1/24 = 1 rest 1
        // 25 - 1*24 = 1
        // 1/3! = 0
        // 1/2! = 0
        // 1/1! = 1
        // 25 -> 1001
        int minimum_factorial = get_min_factorial(input_number);//found the min factorial
        //System.out.println("minimum_factorial: " + minimum_factorial);//24
        int number_factorial = find_factorial_for_number(input_number);//factorial for the number
        


        int number = input_number;
        int remainder = 1;
        int result = 1;

        while (remainder > 0){
            result = number / minimum_factorial; // hitta mutilpel
            remainder = number % minimum_factorial; //hitta rest
            //System.out.println("result: " + result);
            //System.out.println("remainder: " + remainder);

            numb_to_fac.add(result);//add 1
            number_factorial--;//minska fakturent
            //System.out.println("number_factorial: " + number_factorial);

            minimum_factorial = get_factorial_sum(number_factorial);//fakturent summa
            //System.out.println("minimum_factorial: " + minimum_factorial);

            number = remainder;//remainder = number
            //System.out.println("number: " + number);
        }
        
        




        return numb_to_fac;
    }
}
