import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class islandsize {

    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine(); 
        if (x > 10000 || y > 10000) {
            return;
        }

       
        char[][] map = new char[x][y];
        for (int i = 0; i < x; i++) {
            map[i] = sc.nextLine().toCharArray();
            //~~~~~~~~~~ delar upp
        }

        // visited cells
        boolean[][] visited = new boolean[x][y];

        
        int largestIslandSize = 0;

        // gå igenom varje cell i kartan
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // om cell är lan och inte besökt
                if (map[i][j] == '@' && !visited[i][j]) {
                    //kolla land yta
                    int islandSize = search(map, visited, i, j, x, y);
                    // Uppdatera största ön om vi hittar en större
                    largestIslandSize = Math.max(largestIslandSize, islandSize);
                }
                
            }
        }

        // Skriv ut resultatet (den största öns storlek)
        System.out.println(largestIslandSize);
    }
    //~~~~~~~~~~
    //~@~~@@@@~~
    //~@@@@~~~~~
    //~~~~~~~~~~
    //~~~@~@@~~~

    // search för att hitta alla sammanhängande '@' och räkna dem
  
    private static int search(char[][] map, boolean[][] visited, int startX, int startY, int maxX, int maxY) {
        final int[] DIRECTIONS_X = {-1, 1, 0, 0}; // up, down
        final int[] DIRECTIONS_Y = {0, 0, -1, 1}; // left, right

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int size = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();//takes the first element and removes it from the queue
            int x = current[0];
            int y = current[1];
            size++;

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int newX = x + DIRECTIONS_X[i];//look around
                int newY = y + DIRECTIONS_Y[i];

                // Check if the new cell is within bounds, is land, and not visited
                if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY && map[newX][newY] == '@' && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});//add to queue to look further
                    visited[newX][newY] = true;
                }
            }
        }

        return size;
    }
}
