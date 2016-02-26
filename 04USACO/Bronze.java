import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Bronze{
    
    
    

    
    public void solve(){
    }
    

    public static void main(String[]args){
	int numRow=0,numCol=0; //(R,C)
	int elevation;//(E)
	int numDir; // number of directions(N)
	int[][] landscape;
	int[] R_s,C_s,D_s;
	String input = "";
	try{
	    Scanner sc = new Scanner(new File("makelake.in"));
	 
	    while(sc.hasNextLine()){
		
		input += sc.nextLine() + "\n";
		    numRow = Integer.parseInt(input.substring(0,1));
		    numCol = Integer.parseInt(input.substring(2,3));		

	    }
	}catch(FileNotFoundException e){
	    System.out.println("NO FILE FOUND");
	}

	System.out.print(input);
	//numRow = Integer.parseInt(input.substring(0,1));
    //numCol = Integer.parseInt(input.substring(1,2));
    //landscape = new int[numRow][numCol];
	/*	for(int i = 0; i<numRow;i++){
	    for(int index = 0;index<numCol;index++){
		System.out.print(landscape[i][index]);
	    }
	    System.out.print("\n");
	}
	
	*/
	
	//b1.printBoard();
    }
}
   
