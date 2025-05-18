import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
/*
(02, 023, 023, 03)
(0, 03, 03, 03)
(0, 0, 0, 0)
(0, 0, 0, 0)

2
0 0 2 2
1 1 3 3
 */





public class kth_javap_windows {

   
    
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); 

        boolean[][] visited = new boolean[10001][10001];

        for (int i = 0; i < n; i++) {
            String[] x1x2y1y2 = scanner.nextLine().split(" ");
            int x1 = Integer.parseInt(x1x2y1y2[0]);
            int y1 = Integer.parseInt(x1x2y1y2[1]);
            int x2 = Integer.parseInt(x1x2y1y2[2]);
            int y2 = Integer.parseInt(x1x2y1y2[3]);
            // System.out.println("x1: " + x1 + " y1: " + y1 + " x2: " + x2 + " y2: " + y2);
        
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    // System.out.println("this is the new");
                    // System.out.println("x: " + x + " y: " + y);
                    visited[x][y] = true;
                    }
                }
            }   

        int area = 0;
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (visited[x][y]) {
                    area++;
                }
            }
        }

        System.out.println(area);

        
        

    }
}   