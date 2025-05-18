import java.util.Scanner;

public class mincirc {
    public static void main(String[] args) {

        long mincircumference = 2_000_000_000_000L;
        

        Scanner scanner = new Scanner(System.in);
        long amount_area_input = scanner.nextLong();
        scanner.close(); 
        
        long sqrt_amount_area_input =  Math.round((long)Math.sqrt(amount_area_input));// sqrt av area sedan round uppåt
        
        for (long x = 1; x <= sqrt_amount_area_input; x++){
            //System.out.println(amount_area_input/x);
            
            if (amount_area_input % x == 0){// modul division 
                //System.out.println(y_value);
                long circumference = 2*(x+(amount_area_input/x));//får omkrets 
                //System.out.println("y: "+(amount_area_input/x )+ " x: "+x+" cir: "+circumference);
                //System.out.println("mincir : "+mincircumference);

                if (circumference < mincircumference){//om omkretsen ökar stop om den minskar fortsätt
                    mincircumference = circumference;

                }
            }
            
        }
        System.out.println(mincircumference);
        
    }
}