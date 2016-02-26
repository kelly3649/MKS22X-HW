import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Bronze{
    
    int numRow,numCol; //(R,C)
    int elevation;//(E)
    int numDir; // number of directions(N)
    int[][] landscape;
    int[] R_s,C_s,D_s;
    numRow = Integer.parseInt(input.substring(0,1));
    numCol = Integer.parseInt(input.substring(1,2));
    landscape = new int[numRow][numCol];

    public Bronze(String fileName){
	File file = new File(fileName);
	try{
	   Scanner sc = new Scanner(new File("makelake.in"))){
	while(sc.hasNext()){
	    input += sc.next();
	}
    }	
    }
    public void stomp(){
    }
    public void printBoard(){
	for(int i = 0; i<numRow;i++){
	    for(int index = 0;index<numCol;index++){
		System.out.print(landscape[i][index]);
	    }
	    System.out.print("\n");
	}
    }

    public static void main(String[]args){
	Bronze b1 = new Bronze();
	b1.printBoard();
    }
}
