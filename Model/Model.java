package Model;

public class Model
{

    public boolean next = false; //Signifies what player has a turn
    private char[][] board;
    private int[] C1 = new int[4];
    private int[] C2 = new int[4];

    public Model()
    {
        board = new char[6][6];
        for(int row=0;row<6;row++)
        {
            for (int col = 0; col < 6; col++)
            {
                board[row][col] = ' ';
            }
        }
    }

    public void makeMove(int row, int col)
    {
        char playerSymbol = ' ';
        if (!next)
        {
            playerSymbol = 'X';
            next=true;
        }
        else
        {
            playerSymbol = 'O';
            next = false;
        }
        board[row][col] = playerSymbol;
    }

    public boolean getNext() //returns the player turn
    {
        return next;
    }

    public void checkQ11()
    {
        if (board[1 - 1][1 - 1] == 'X' && board[1 - 1][3 - 1] == 'X' && board[2 - 1][2 - 1] == 'X' && board[3 - 1][1 - 1] == 'X' && board[3 - 1][3 - 1] == 'X') {
            C1[0] = 11;
            System.out.println("Put to C1. Captured by" + !next);
        } else if (board[1 - 1][1 - 1] == 'O' && board[1 - 1][3 - 1] == 'O' && board[2 - 1][2 - 1] == 'O' && board[3 - 1][1 - 1] == 'O' && board[3 - 1][3 - 1] == 'O') {
            C2[0] = 11;
            System.out.println("Put to C2. Captured by" + !next);
        }
    }

    public void checkQ12()
    {
        if (board[1 - 1][5 - 1] == 'X' && board[2 - 1][4 - 1] == 'X' && board[2 - 1][5 - 1] == 'X' && board[2 - 1][6 - 1] == 'X' && board[3 - 1][5 - 1] == 'X') {
            C1[1] = 12;
            System.out.println("Put to C1. Captured by" + !next);
        } else if (board[1 - 1][5 - 1] == 'O' && board[2 - 1][4 - 1] == 'O' && board[2 - 1][5 - 1] == 'O' && board[2 - 1][6 - 1] == 'O' && board[3 - 1][5 - 1] == 'O') {
            C2[1] = 12;
            System.out.println("Put to C2. Captured by" + !next);
        }
    }

    public void checkQ21()
    {
        if (board[4 - 1][1 - 1] == 'X' && board[4 - 1][3 - 1] == 'X' && board[5 - 1][3 - 1] == 'X' && board[6 - 1][3 - 1] == 'X' && board[6 - 1][3 - 1] == 'X')
        {
            C1[2] = 21;
            System.out.println("Put to C1. Captured by" + !next);
        }
        else if (board[4 - 1][1 - 1] == 'O' && board[4 - 1][3 - 1] == 'O' && board[5 - 1][3 - 1] == 'O' && board[6 - 1][1 - 1] == 'O' && board[6 - 1][3 - 1] == 'O')
        {
            C2[2] = 21;
            System.out.println("Put to C2. Captured by" + !next);
        }
    }

    public void checkQ22()
    {
        if (board[4 - 1][4 - 1] == 'X' && board[4 - 1][6 - 1] == 'X' && board[5 - 1][5 - 1] == 'X' && board[6 - 1][4 - 1] == 'X' && board[6 - 1][6 - 1] == 'X') {
            C1[3] = 22;
        }
        else if (board[4 - 1][4 - 1] == 'O' && board[4 - 1][6 - 1] == 'O' && board[5 - 1][5 - 1] == 'O' && board[6 - 1][4 - 1] == 'O' && board[6 - 1][6 - 1] == 'O') {
            C2[3] = 22;
        }
    }

    public int checkPlayerWin()
    {
        if(C1[0]==11&&C1[3]==22||C1[1]==12&&C1[2]==21)
        {
            System.out.println("Player 1 wins!");
            return 1;
        }
        else if((C2[0]==11&&C2[3]==22)||(C2[1]==12&&C1[2]==21))
        {
            System.out.println("Player 2 wins!");
            return 2;
        }
        return 0;
    }

    public void printArray()
    {
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<6;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

}
