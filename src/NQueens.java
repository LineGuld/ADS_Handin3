public class NQueens
{
  int n;
  int[][] board;

  public NQueens(int n)
  {
    this.n = n;

    board = new int[n][n];
    printBoard(board);
  }

  public void printBoard(int[][] board)
  {
    for (int j = 0; j < n; j++)
    {
      System.out.print("col:" +  j + " ");
    }
    System.out.println();
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < n; j++)
      {
        System.out.print( "   " + board[i][j] + "  ");
      }
      System.out.println("row: " + i );
    }
  }

  public boolean isSafe(int[][] board, int col, int row)
  {
    int i, j;
    //Check row to the left
    for (i = 0; i < col; i++)
    {
      if (board[row][i] == 1)
        return false;
    }

    //check diagonal hen mod 0,0
    // i og j er plaveringen, vi rykker bagud på diagonalen indtil vi støder på en kant (0)
    for (i = row, j = col ; i >= 0 &&  j >= 0; i--, j--)
    {
        if (board[i][j] == 1)
          return false;
    }

    //Check diagonalen hen mod n,0
    for (i = row, j=col; j>= 0 && i < n; i++, j--)
    {
      if (board[i][j] ==1)
        return false;
    }

    // Hvis den ikke falder i nogen af fælderne er det sikkert!
    return true;
  }



  public static void main(String[] args)
  {
    NQueens queens = new NQueens(4);
  }
}
