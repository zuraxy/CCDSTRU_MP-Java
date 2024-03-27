package Model;

public class Model
{
    public boolean next = false; //Signifies what player has a turn
    private char[][] board;
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
        System.out.println(next);
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
}
