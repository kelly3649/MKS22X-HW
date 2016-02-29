import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Bronze{
    
    
    

    
    public static String solve(){
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
		    elevation = Integer.parseInt(input.substring(4,5));		
		    numDir = Integer.parseInt(input.substring(6,7));		
	    }
	}catch(FileNotFoundException e){
	    System.out.println("NO FILE FOUND");
	}
	int vol = 0;
	/*landscape = new int[numRow][numCol];
	for(int i = 0; i<numRow;i++){
	    for(int index = 0;index<numCol;index++){
		System.out.print(landscape[i][index]);
	    }
	    System.out.print("\n");
	}
	
	*/
	return "" + vol + ",7,Wang,Kelly"; 
    }
    

    public static void main(String[]args){


	System.out.println(solve());
	
	
	//b1.printBoard();
    }
}
   
