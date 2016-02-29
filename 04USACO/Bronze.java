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
		}
		
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
	int dir = 0; //the direction you're following RN
	while(dir < numDir){
	    for(int i = R_s.get(dir);i<numRow && i<R_s.get(dir)+3;i++){
		for(int index = C_s.get(dir);index<numCol && index<C_s.get(dir)+3;index++){
		    landscape[i][index] -= D_s.get(dir);
		    if(dir == numDir-1){
			landscape[i][index] = elevation - landscape[i][index];
		    }//if last instr, go onto next step, final val:depth undrwtr
		    System.out.print(index + ": " + landscape[i][index] + " ");
		}
		System.out.print("\n");
	    }
	    System.out.println("^DIR#" + dir);
	    dir++;
	}
	//last for loop set
	//for(int i = 0;i<numRow;i++){
	    
	int vol = 0;
	
	return "" + vol + ",7,Wang,Kelly" + numRow + numCol + elevation + numDir + input; 
    }
    

    public static void main(String[]args){


	System.out.println(solve());
	
	
	//b1.printBoard();
    }
}
   
