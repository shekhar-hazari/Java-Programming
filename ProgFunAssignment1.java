//import whatever packages are needed here
import java.util.*;


public class ProgFunAssignment1 {

 
	public static void main(String[] args) {
		int row, column, input, pos_x, pos_y, row_span, column_span;
		boolean flag;
		
	    // Scanner object for input
		Scanner sc = new Scanner(System.in);
		
		// Loop to get acceptable values to create the block
		do{
			System.out.print("Enter the number of rows and columns for the block (should be greater than 2 and less than or equal to 10): ");
			row = sc.nextInt();
			column = sc.nextInt();
			if(row > 2 && row <= 10 && column > 2 && column <= 10){
				System.out.print("\nValues are valid, creating a block of size: " + row + " X " + column);
				}
			else{
				System.out.print("\nInvalid values, try again!!");
			}
		}while(row < 2 || row > 10 || column < 2 || column > 10);
		
		// An object of class MyBlock using the 'new' operator, calling on the MyBlock constructor.
		MyBlock block_obj = new MyBlock(row,column);
		// A loop to display the menu, prompt for input and process it as per requirements.
		do{
			System.out.print("\n\n---------------Menu---------------\n\t1. Add a house\n\t2. Display the block\n\t3. Clear the block\n\t4. Quit");
			input = sc.nextInt();
			if (input < 1 || input > 4){
				System.out.print("\nInvalid input!! displaying menu again");
				continue;
			}
			else{
				switch (input){
					case 1:
						System.out.print("\nPlease enter position (x,y) of house in the block: ");
						pos_x = sc.nextInt();
						pos_y = sc.nextInt();
						System.out.print("\nEnter the number of rows and columns over which house spans:");
						row_span = sc.nextInt();
						column_span = sc.nextInt();
						flag = block_obj.addHouse(pos_x, pos_y, row_span, column_span);
						//Error Message to be displayed;
						if(flag){
							System.out.print("\nHouse added successfully\n\n");
							block_obj.displayBlock();
						}
						else System.out.print("\nHouse not added");
						break;
					
					case 2:
						block_obj.displayBlock();
						break;
						
					case 3:
						block_obj.clearBlock();
						break;
						
					case 4:
						System.out.print("\nQuitting program.");
						break;
					
					default:
						System.out.print("\nMight be an error.");
				}
			}
		}while(input > 0 && input < 4);

     // Your program should quit gracefully
		sc.close();
		System.out.print("Hope you had fun! BYE!");

	}

}

//MyBlock class 

//It does NOT need to handle any input at all.  
//All the input should occur in the main method
//
//If you find yourself needing to do input here re-think your solution.

class MyBlock {
	private int[][] block;
	private boolean vacant;
	private int h_no;
	private int r_lim;
	private int c_lim;
	// you may need to add other variables.	

	// Constructor...
	// Assumption - rows and columns has been validated beforehand.
	// Initialize the block so that each cell is set to the character '0' 
	// (hint: use one of your methods!).
	// Set the initial value of any other variables
	public MyBlock(int maxRows, int maxColumns) {
		block = new int [maxRows][maxColumns];
		this.r_lim = maxRows-1;
		this.c_lim = maxColumns-1;
		System.out.print("\nBlock created.");
		this.clearBlock();
	}
	
	
	// Display the entry block as a matrix 
	public void displayBlock() {
		for (int i = 0; i <= r_lim; i++){
			for (int j = 0; j <= c_lim; j++){
				System.out.print(this.block[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\nBlock print complete...... going back to menu");
	}
	
	
	// Clear out the block. This involves setting each cell to be '0'
	public void clearBlock() {
		for (int i = 0; i <= r_lim; i++){
			for (int j = 0; j <= c_lim; j++){
				block[i][j] = 0;
			}
		}
		this.vacant = true;
		this.h_no = 0;
		System.out.print("\nBlock has all '0' values.");
	}
	
	
	// Build a house on the block
	
	// Ensure none of the other rules are violated
	// Return if any rule is violated
	// An error message should display when an error occurs
	// If all is OK "build" the house on the block 
	// Update relevant variable(s) and call on displayBlock().
	public boolean addHouse(int rowPos, int colPos, int rows, int columns) {
		
		boolean check_1 = false;
		boolean check_2 = false;
		boolean check_3 = false;
		boolean check_4 = false;
		
		//Check Rule 4
		if (rows > 0 && columns > 0) check_4 = true;
		else System.out.print("\nViolation of rule 4: The house should atleast have a size of 1X1!!");
		
		if (check_4){
			//Check rule 1 and 3
			if ( (rowPos > 0) && ( (rowPos + (rows-1)) < r_lim) && (colPos > 0) && ( (colPos + (columns-1)) < c_lim) ){
				check_1 = true;
				check_3 = true;
			}
			else System.out.print("\nViolation of Rule 1 or 3: The house should be within limits of block and should not span over edges.");
		}
		
		if (check_1 && check_3 && check_4){
			//Check rule 2
			check_2 = true;
			for(int i = rowPos-1; i <= rowPos + rows; i++){
				if( (this.block[i][colPos-1] != 0) || (this.block[i][colPos+columns] != 0) ){
					System.out.print("\nViolation of rule 2: New house should be atleast 1 column away from an existing house at both ends.");
					check_2 = false;
					break;
				}
			}
			for (int j = colPos-1; j <= colPos + columns; j++){
				if( (this.block[rowPos-1][j] != 0) || (this.block[rowPos+rows][j] != 0) ){
					System.out.print("\nViolation of rule 2: New house should be atleast 1 row away from an existing house at both ends.");
					check_2 = false;
					break;
				}
			}
			
		}
		
		
		// You may find the code snippet below useful
		if (check_1 && check_2 && check_3 && check_4){
			h_no = h_no+1;
			//Fill the house number in the block
			for(int x = rowPos; x < rowPos + rows; x++){
				for(int y = colPos; y < colPos+ columns; y++){
					this.block[x][y] = h_no;
				}
			}
			return true;
		}	
		else 
			return false;
	}
		
}