package Minesweeper;

import java.util.Random;

public class extra {
	private char [][] bombGrid;
	private int [][] countGrid;
	private int numRows, numColumns;
	private int numBombs;
	
	
	public extra()
	{
		numRows = 10;
		numColumns = 10;
		bombGrid = new char[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		numBombs = 25;
		this.createBombGrid();
		this.createCountGrid();
	}
	/*public Grid(int rows, int columns)
	{
		numRows = rows;
		numColumns = columns;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		numBombs = 25;
		this.createBombGrid();
		this.createCountGrid();
	}
	public Grid(int rows, int columns, int numBombs) 
	{
		numRows = rows;
		numColumns = columns;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		this.numBombs = numBombs;
		this.createBombGrid();
		this.createCountGrid();
	}
	*/
	public int getNumRows() {
		return this.numRows;
	}
	public int getNumColumns() {
		return this.numColumns;
	}
	public int getNumBombs() {
		return this.numBombs;
	}
	/*public boolean [][] getBombGrid() {
		return bombGrid;
	}
	public int [][] getCountGrid(){
		return countGrid;
	}
	public boolean isBombAtLocation(int row, int column) {
		if(bombGrid[row][column] == true)
		{
			return true;
		}
		return false;
	}
	*/
	public int getCountAtLocation(int row, int column) {
		int count = countGrid[row][column];
	    return count;
	}
	
	public void createBombGrid() {          //make it private
		for(int i = 0; i<bombGrid.length; i++)
		{
			for(int j=0; j<bombGrid[i].length; j++)
			{
				bombGrid[i][j] = 'F';
				
			}
		}
		
		int bombNumbers = this.numBombs;
		while(bombNumbers > 0) {
				
					Random rand_num1 = new Random();
					Random rand_num2 = new Random();
					int row = rand_num1.nextInt(10);
					int col = rand_num2.nextInt(10);
					
					if(bombGrid[row][col] == 'F' && bombNumbers > 0)
					{
						bombGrid[row][col] = 'T';
						bombNumbers--;
					}
	}
			
}
	
  public void createCountGrid() 
  {
		
	
	for(int rows =0; rows< numRows; rows++)
	{
	  for(int cols = 0 ; cols<numColumns; cols++)
	   {
	     int count = 0;
		if(bombGrid[rows][cols] == 'T')       //self
		{  
			count++;
			countGrid[rows][cols] = count;
		}
		if( (rows >0) && bombGrid[rows-1][cols] == 'T')         //up
		{
			
			count++;
			countGrid[rows][cols] = count;
		}
	    if(((rows+1 ) <numRows )&&bombGrid[rows+1][cols] == 'T')                 //down
	    {
	    	
	    	count++;
			countGrid[rows][cols] = count;
	    }
		if(((cols+1) < numColumns) && bombGrid[rows][cols+1] == 'T')   // right
		{
			
			count++;
			countGrid[rows][cols] = count;
		}
		if((cols > 0) && bombGrid[rows][cols-1] == 'T')
		{
			
			count++;
			countGrid[rows][cols] = count;                                      //left
		}
		
		
		if((rows > 0 && cols > 0) && bombGrid[rows-1][cols-1] == 'T') // main dia left corner
		{
			
			count++;
			countGrid[rows][cols] = count;
		}
		
		if(((rows + 1) < numRows ) && ((cols + 1) < numColumns ) && bombGrid[rows+1][cols+1] == 'T') //main dia right corner
		{
			count++;
			countGrid[rows][cols] = count;
		}
		
		if( ((rows + 1) < numRows ) && (cols > 0 ) && bombGrid[rows+1][cols-1] == 'T') // 2nd dia left corner
		{
			count++;
			countGrid[rows][cols] = count;
		}
		if((rows > 0  ) && ((cols + 1) < numColumns ) && bombGrid[rows-1][cols+1] == 'T') //2nd dia right corner
		{
			count++;
			countGrid[rows][cols] = count;
		}
		
	     
	     
	     
		}
	}
			
			
			
 }
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	public void display_bomb() {              // NOT NEEDED
		for(int i = 0 ; i <bombGrid.length; i++)
		{
			for(int j=0; j<bombGrid[i].length; j++)
			{
				System.out.print(bombGrid[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public void display_count() {              // NOT NEEDED
		for(int i = 0 ; i <countGrid.length; i++)
		{
			for(int j=0; j<countGrid[i].length; j++)
			{
				System.out.print(countGrid[i][j]+"  ");
			}
			System.out.println();
		}
	}
	/*public void reveal_zero_cell(int r, int c)
	{
	
		if(myGrid.getCountAtLocation(r, c) == 0)              // if zero thn check its adjacent
		{
			
			board[r][c].setText(Integer.toString(myGrid.getCountAtLocation(r, c)));
			if(board[r][c].isEnabled()) {
				cell_checked++;
				board[r][c].setEnabled(false);
				}
			
			
			if( (r>0) && myGrid.getCountAtLocation(r-1, c) == 0)
			{
				board[r-1][c].setText(Integer.toString(myGrid.getCountAtLocation(r-1, c)));  //up
				
				if(board[r-1][c].isEnabled()) {
					cell_checked++;
					board[r-1][c].setEnabled(false);
					}
				
				if(myGrid.getCountAtLocation(r-1, c) == 0) {
				reveal_adjacentzeroCell(r-1,c);
					
				}
			}
			if((r+1 < NUM_ROWS) && myGrid.getCountAtLocation(r+1, c) == 0)
			{
				board[r+1][c].setText(Integer.toString(myGrid.getCountAtLocation(r+1, c)));   //down
				
				if(board[r+1][c].isEnabled()) {
					cell_checked++;
					board[r+1][c].setEnabled(false);
					}
		
				if(myGrid.getCountAtLocation(r+1, c) == 0) {
					reveal_adjacentzeroCell(r+1,c);
					
				}
				
			}
			if((c+1 <NUM_COLS) && myGrid.getCountAtLocation(r, c+1) == 0)
			{
				board[r][c+1].setText(Integer.toString(myGrid.getCountAtLocation(r, c+1))); //right
				if(board[r][c+1].isEnabled()) {
					cell_checked++;
					board[r][c+1].setEnabled(false);
					}
			
				if(myGrid.getCountAtLocation(r, c+1) == 0) {
			 	reveal_adjacentzeroCell(r,c+1);
				
				}
			}
			if((c >0 ) && myGrid.getCountAtLocation(r, c-1) == 0)
			{
				board[r][c-1].setText(Integer.toString(myGrid.getCountAtLocation(r, c-1))); //left
				
				if(board[r][c-1].isEnabled()) {
					cell_checked++;
					board[r][c-1].setEnabled(false);
					}
			
				if(myGrid.getCountAtLocation(r, c-1) == 0) {
				reveal_adjacentzeroCell(r,c-1);
					
			}
			}
			if((r > 0 &&  c>0) && myGrid.getCountAtLocation(r-1, c-1) == 0) 
			{
				board[r-1][c-1].setText(Integer.toString(myGrid.getCountAtLocation(r-1, c-1))); // main dia left corner
				
				if(board[r-1][c-1].isEnabled()) {
					cell_checked++;
					board[r-1][c-1].setEnabled(false);
					}
				
				if(myGrid.getCountAtLocation(r-1, c-1) == 0) {
				 reveal_adjacentzeroCell(r-1,c-1);
					
				}
			}
			if((r + 1 < NUM_ROWS) && (c +1 < NUM_COLS) && myGrid.getCountAtLocation(r+1, c+1) == 0 )
			{
				board[r+1][c+1].setText(Integer.toString(myGrid.getCountAtLocation(r+1, c+1))); //main dia right corner
				
				if(board[r+1][c+1].isEnabled()) {
					cell_checked++;
					board[r+1][c+1].setEnabled(false);
					}
				
				if(myGrid.getCountAtLocation(r+1, c+1) == 0) {
				reveal_adjacentzeroCell(r+1,c+1);
					
				}
			}
			if((r + 1 < NUM_ROWS) &&(c > 0) && myGrid.getCountAtLocation(r+1, c-1) == 0)
			{
				board[r+1][c-1].setText(Integer.toString(myGrid.getCountAtLocation(r+1, c-1))); //2nd dia left corner
				
				if(board[r+1][c-1].isEnabled()) {
					cell_checked++;
					board[r+1][c-1].setEnabled(false);
					}
			
				if(myGrid.getCountAtLocation(r+1, c-1) == 0) {
				reveal_adjacentzeroCell(r+1,c-1);
					
				}
			}
			if((r > 0 ) &&(c +1 < NUM_COLS) && myGrid.getCountAtLocation(r-1, c+1) == 0)
			{
				board[r-1][c+1].setText(Integer.toString(myGrid.getCountAtLocation(r-1, c+1))); //2nd dia right corner
				
				if(board[r-1][c+1].isEnabled()) {
					cell_checked++;
					board[r-1][c+1].setEnabled(false);
				}
				
				if(myGrid.getCountAtLocation(r-1, c+1) == 0) {
				reveal_adjacentzeroCell(r-1,c+1);
					
				}
			}
			
		}

		else //non zero
		{
			//System.out.println(r +" "+c);
			board[r][c].setText(Integer.toString(myGrid.getCountAtLocation(r, c)));
			if(board[r][c].isEnabled()) {
				cell_checked++;
				board[r][c].setEnabled(false);
				}
			
			
		
		}
		
		
}*/

}
