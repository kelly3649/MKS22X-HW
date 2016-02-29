import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Bronze{
    
    
    

    
    public static String solve(){
	int numRow=1,numCol=1; //(R,C)
	int elevation=0;//(E)
	int numDir=0; // number of directions(N)
	int[][] landscape = new int[numRow][numCol];
	ArrayList<Integer> R_s = new ArrayList<Integer>()
	    ,C_s= new ArrayList<Integer>(),
	    D_s= new ArrayList<Integer>(); //easier to be ArrayList bc can add onto later
	String input = "";
	try{
	    Scanner sc = new Scanner(new File("makelake.in"));
	    numRow = sc.nextInt();
	    numCol = sc.nextInt();
	    elevation = sc.nextInt();
	    numDir = sc.nextInt();;
	    landscape = new int[numRow][numCol];
	    for(int i = 0; i<numRow;i++){
		for(int index = 0;index<numCol;index++){
		    landscape[i][index] = sc.nextInt();
		    //System.out.print(landscape[i][index] + " ");
		}
		//System.out.print("\n");
	    }			     
	    for(int i = 0;i<numDir;i++){
		while(sc.hasNextInt()){
		    R_s.add(sc.nextInt());
		    C_s.add(sc.nextInt());
		    D_s.add(sc.nextInt()); //how much you push it down
		}
		i++;
	    }

	    
	}catch(FileNotFoundException e){
	    System.out.println("NO FILE FOUND");
	}
	int vol = 0;
	
	return "" + vol + ",7,Wang,Kelly" + numRow + numCol + elevation + numDir + input; 
    }
    

    public static void main(String[]args){


	System.out.println(solve());
	
	
	//b1.printBoard();
    }
}
   
