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
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class factoradic {
    public static void main(String[] args){
        //testing_function();
        main2();



    }
    public static void main2(){
        //testing_function();

        Scanner scanner = new Scanner(System.in);
        String first_string_number = scanner.nextLine();
        String second_string_number = scanner.nextLine();
        long first_num = to_factoradic(first_string_number);
        System.out.println(first_num);
        List<Long> test2 = from_factoradic(second_string_number);

        for (int o = test2.size() - 1; o >= 0; o--) {
            char c = number_to_ASCII(test2.get(o).intValue());
            
            //System.out.print("test2: " + test2.get(o));
            //System.out.println();
            System.out.print(c);
            //System.out.println();

        }
        //System.out.println("first_string_number: " + first_string_number);
        //System.out.println("second_string_number: " + second_string_number);
        scanner.close();

    }

    public static void testing_function(){
        //System.out.println("11 to ascii is " + number_to_ASCII(9));
        //long test = to_factoradic("32A40244706404200");
        //System.out.println(test);

        //List<Long> test2 = from_factoradic("1122334455667788");
        //System.out.println();
        //for (int o = test2.size() - 1; o >= 0; o--) {
        //    char c = number_to_ASCII(test2.get(o).intValue());
            
            //System.out.print("test2: " + test2.get(o));
            //System.out.println();
        //    System.out.print(c);
            //System.out.println();

        //}

    }

    public static char number_to_ASCII(int input_of_number){
        if (input_of_number >= 10){
            int result_of_ascii = (input_of_number + 55);
            return (char) result_of_ascii;
        }else{
            return (char) (input_of_number + 48);
        }
    }

    public static long get_factorial_sum(long j){
        long factorial_sum = 1;
        for(long i = 1; i <= j; i++){
            factorial_sum *= i;           
        }
        return factorial_sum;
    }


// 654320 -> 5038
// 654320 -> read from right to left -> 0 -> for loop n = 1, total_sum = 0 -> 0 times n! + total_sum -> loop till last number
// read antal numbers 654320 -> 6 -> 6! is the last one
    public static long to_factoradic(String n) {
        String input = n; // Input string
        //System.out.println("input: " + input);

        long number_of_digits = input.length();
        //System.out.println("number_of_digits: " + number_of_digits);
        //System.out.println("");

        long total_sum = 0;

        for (int k = 0; k < number_of_digits; k++) {
            char character = input.charAt((int) (number_of_digits - k - 1)); 
            int digit = Character.getNumericValue(character); 

            //System.out.println("Character: " + character + ", Numeric Value: " + digit);
            //System.out.println("k: " + (k + 1));

            long factorial_sum_1 = get_factorial_sum(k + 1); 
            total_sum += digit * factorial_sum_1;

            //System.out.println(digit + " * " + (k + 1) + "! = " + (digit * factorial_sum_1));
            //System.out.println("total_sum: " + total_sum);
        }

        return total_sum;
    }


    public static long get_min_factorial(long num_1){
        //x System.out.println("num: " + num_1);
        int f = 1;
        long factorial_divided_input_number = 100;
        long min_factorial = 0;

        while (factorial_divided_input_number > 1){
            long factorial_sum = get_factorial_sum(f);
            //System.out.println("factorial: " + factorial);
            //System.out.println("input_number: " + num);
            factorial_divided_input_number = num_1 / factorial_sum;// rounds down the result
            //System.out.println("factorial_divided_input_number: " + factorial_divided_input_number);
            min_factorial = factorial_sum;
            f++;
        }
        return min_factorial;
    }

    public static long find_factorial_for_number(long num_2) {

        long p = 1; 
        long factorial = 1;
    
        //System.out.println("num_2: " + num_2);
        while (factorial <= num_2) {
            //System.out.println("factorial: " + factorial);
            
            factorial = get_factorial_sum(p);
            p++;
            //System.out.println("p: " + p);
        }
    
        return p - 1;//it does one more iteration than needed
    }

   

// 25 -> 1001
    public static List<Long> from_factoradic(String string_number){
        List<Long> numb_to_fac = new ArrayList<>();
        long input_number = Long.parseLong(string_number);//string to long
        //System.out.println("input_number: " + input_number);

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
        long minimum_factorial = get_min_factorial(input_number);//found the min factorial
        //System.out.println("minimum_factorial: " + minimum_factorial);
        long number_factorial = find_factorial_for_number(input_number);//factorial for the number
        //System.out.println("number_factorial: " + number_factorial);

        long number = input_number;
        long remainder = 1;
        long result = 1;

        //System.out.println("min fac "+number_factorial);

        while (number_factorial > 1){
            
            number_factorial--;
            //System.out.println();
            //System.out.println(number_factorial);
            minimum_factorial = get_factorial_sum(number_factorial);
            result = number / minimum_factorial; // hitta mutilpel
            remainder = number % minimum_factorial; //hitta rest

           // System.out.println("dividing: " + number + " / " + minimum_factorial + " = " + result);
            //System.out.println("rest: " + number + " % " + minimum_factorial + " = " + remainder);
            //System.out.println("IMPORTNANT result: " + result);
            //System.out.println("remainder: " + remainder);
            
            //minska fakturent
            //System.out.println("number_factorial: " + number_factorial);

           //fakturent summa
            //System.out.println("minimum_factorial: " + minimum_factorial);

            number = remainder;//remainder = number
            //System.out.println("number: " + number);
            //for (int o = numb_to_fac.size() - 1; o >= 0; o--) {
            //    System.out.println();
            //    System.out.print(numb_to_fac.get(o));
            //    System.out.println();
            //}
            numb_to_fac.add(result);//addera mutipel till lista
        }
    
        //for (int o = numb_to_fac.size() - 1; o >= 0; o--) {
         //   System.out.print(numb_to_fac.get(o));      
        //}
        //System.out.println();
        // Remove leading zeros
        while (numb_to_fac.get(0) == 0) {
            numb_to_fac.remove(0); // Remove the first element if it's zero
        }
        //System.out.println();
        Collections.reverse(numb_to_fac);
        //or (int o = numb_to_fac.size() - 1; o >= 0; o--) {
        //    System.out.print(numb_to_fac.get(o));      
        //}
        //System.out.println();

        return numb_to_fac;
    }
}
