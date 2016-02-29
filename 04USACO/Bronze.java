import java.util.*;
import java.lang.Math;
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
	    System.out.println("FILE NOT FOUND");
	}
	int dir = 0; //the direction you're following RN
	while(dir < numDir){
	    int max=0;
	    for(int i = R_s.get(dir)-1;i<numRow && i<R_s.get(dir)+2;i++){
		for(int index = C_s.get(dir)-1;index<numCol && index<C_s.get(dir)+2;index++){
		    max=Math.max(max,landscape[i][index]); //there is a new max every dir
		}
	    }
	    max-=D_s.get(dir);
	    for(int i = R_s.get(dir)-1;i<numRow && i<R_s.get(dir)+2;i++){
		for(int index = C_s.get(dir)-1;index<numCol && index<C_s.get(dir)+2;index++){
		    if(landscape[i][index] > max){//if it was < but is > aftr the stomp
			landscape[i][index] = max; //make it equal 
 
		    }
		    //		    System.out.print(index + ": " + landscape[i][index] + " ");
		}
		//	System.out.print("\n");
	    }
	    // System.out.println("^DIR#" + dir);
	    dir++;
	}
	int ttlDepth = 0;
	//last for loop set
	for(int i = 0;i<numRow;i++){
	    for(int index = 0;index<numCol;index++){
		landscape[i][index] = elevation - landscape[i][index];
		if(landscape[i][index] > 0){ //neg values would still b abv land
		    ttlDepth += landscape[i][index];
		}
	    }
	}
	//System.out.println("depth: " + ttlDepth); //should be 66
	int vol = ttlDepth * 72 * 72; //dimensions are 6ft by 6ft
	return "" + vol + ",7,Wang,Kelly"; 
    }
    

    public static void main(String[]args){


	System.out.println(solve());
	
	
	//b1.printBoard();
    }
}
   
