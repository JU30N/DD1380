import java.util.Scanner;

public class LargestIsland {

    // Riktningar för att navigera upp, ner, vänster, höger (inga diagonaler)
    private static final int[] DIRECTIONS_X = {-1, 1, 0, 0}; // upp, ner
    private static final int[] DIRECTIONS_Y = {0, 0, -1, 1}; // vänster, höger

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Läs in kartans dimensioner
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine(); // För att läsa nästa rad

        // Läs in sjökortet
        char[][] map = new char[x][y];
        for (int i = 0; i < x; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        // Besökta celler
        boolean[][] visited = new boolean[x][y];

        // Variabel för att hålla reda på största ön
        int largestIslandSize = 0;

        // Gå igenom varje cell i kartan
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // Om cellen är '@' och vi inte har besökt den
                if (map[i][j] == '@' && !visited[i][j]) {
                    // Hitta storleken på den ön som börjar på denna cell
                    int islandSize = dfs(map, visited, i, j, x, y);
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

    // DFS för att hitta alla sammanhängande '@' och räkna dem
    private static int dfs(char[][] map, boolean[][] visited, int x, int y, int maxX, int maxY) {
        // Markera denna cell som besökt
        visited[x][y] = true;
        int size = 1;  // Den aktuella cellen räknas som en del av ön

        // Gå igenom alla 4 riktningar (upp, ner, vänster, höger)
        for (int i = 0; i < 4; i++) {
            int newX = x + DIRECTIONS_X[i];
            int newY = y + DIRECTIONS_Y[i];

            // Kolla om den nya cellen är inom kartan och om den är ett '@' och inte är besökt
            if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY && map[newX][newY] == '@' && !visited[newX][newY]) {
                // Recursivt kalla DFS på den nya cellen och lägg till storleken
                size += dfs(map, visited, newX, newY, maxX, maxY);
            }
        }

        return size;
    }
}
