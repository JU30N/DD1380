import java.util.Scanner;

public class LargestIsland {

    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine(); 

       
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
    private static int search(char[][] map, boolean[][] visited, int x, int y, int maxX, int maxY) {
        final int[] DIRECTIONS_X = {-1, 1, 0, 0}; // konstant
        final int[] DIRECTIONS_Y = {0, 0, -1, 1}; 
        visited[x][y] = true;
        int size = 1;  

        // kolla up ner v h 
        for (int i = 0; i < 4; i++) {
            int newX = x + DIRECTIONS_X[i];
            int newY = y + DIRECTIONS_Y[i];

            // kollar inom map och besökt eller inte samt om land
            if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY && map[newX][newY] == '@' && !visited[newX][newY]) {
                //om nytt land kolla den och addera storlek
                size += search(map, visited, newX, newY, maxX, maxY);
            }
        }

        return size;
    }
}
