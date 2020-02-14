/*
Giacomo Usai 14/02/20

Unlock the door Problem:
card is an nxn 0/1 matrix, with n>=1
door is an mxm 0/1 matrix, with m>=n
Solution the card unlocks the door if it aligns with the pad: it appears as a submatrix
of the pad up to rotations.

In this example the solution is
the coordinates (1, 2) of the door and the rotation 270=90+90+90

 */


public class DoorKeyProblem {
    public static int si=0, sj=0, rot=0;

    public static boolean engine(int[][] card, int[][] door, int n, int m) {
        if(m<n) return false;
        int range = m-n;
        for(int x=0; x <= range; x++)
            for(int y=0; y <= range; y++)
                if(card[0][0] == door [x][y]) {
                    if(checkIfareEqual(card, door, n, m, x, y)) {
                        si = x;
                        sj = y;
                        return true;
                    }
                }
        return false;
    }

    public static boolean checkIfareEqual(int[][] card, int[][] door, int n, int m, int x, int y) {
        for (int i = x, a=0; i < x+n && a<n; i++, a++)
            for (int j = y, b=0; j < y+n && b<n; j++, b++)
                if (!(card[a][b] == door[i][j]))
                    return false;
        System.out.println("A Solution is found!");
        return true;
    }

    // Function to rotate the matrix 90 degree clockwise
    static void rotate90Clockwise(int a[][], int n) {
        // Traverse each cycle
        rot += 90;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // Swap elements of each cycle
                // in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[n - 1 - j][i];
                a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
                a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
                a[j][n - 1 - i] = temp;
            }
        }
    }

    // Function for print matrix
    static void printMatrix(int arr[][], int n) {
        for (int i = 0; i < n; i++){
           for (int j = 0; j < n; j++)
                System.out.print( arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String [] args){
        final int n=3, m=5;
        // Initialization
        int[][] card = new int [][]{
                {0, 1, 0},
                {0, 1, 1},
                {0, 1, 0}
        };

        int[][] door = new int [][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        printMatrix(card, n);
        printMatrix(door, m);
        System.out.println("START:");


        for(int i=0; i<4; i++){
            if(engine(card, door, n, m)) break;
            rotate90Clockwise(card, n);
            printMatrix(card, n);
        }

        System.out.println("Solution is: (" +si+ ", " +sj+ ") and "+ rot);
    }

}
