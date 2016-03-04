import java.io.*;
import java.util.Scanner;

public class Silver{
    private int startx=-1, starty=-1, endx=-1, endy=-1;
    private int numRow=0, numCol=0;
    private int[][] pasture = new int[numRow][numCol];
    private int time=0; //num of seconds taken

    public Silver(String filename){
	try{
	    Scanner sc = new Scanner(new File(filename));
	    numRow = sc.nextInt();
	    numCol = sc.nextInt();
	    time = sc.nextInt();
	    pasture = new int[numRow][numCol];
	    for(int i = 0;i<numRow;i++){
		for(int index = 0;index<numCol;index++){
		    if(sc.next().equals("*"){
			pasture[i][index] = -1;
		    }
		    else{
			pasture[i][index] = 0;
		    }
		}
	    }
	    startx = sc.nextInt()-1;
	    starty = sc.nextInt()-1;
	    endx = sc.nextInt()-1;
	    endy = sc.nextInt()-1;
	}catch(FileNotFoundException e){
	    System.out.println("FILE NOT FOUND");
	}
    }
    public void sumOf(int row, int col){
	if(pasture[row+1][col] >= 0){    
	    pasture[row][col] += pasture[row+1][col];
	}
	if(pasture[row-1][col] >= 0){    
	    pasture[row][col] += pasture[row-1][col];
	}
	if(pasture[row][col+1] >= 0){    
	    pasture[row][col] += pasture[row][col+1];
	}
	if(pasture[row][col-1] >= 0){    
	    pasture[row][col] += pasture[row][col-1];
	}
	
    }
    public String solve(){
	pasture[startx][starty] = 1;
	//if time was == to 1, then there is only 1 way to get to the start
	int t = 1; 
	while(t<time+1){
	    for(int i = 0;i<numRow;i++){
		for(int index = 0;index<numCol;index++){
		    sumOf(i,index);
		}
	    }
	    t++;
	}
	return "" + pasture[endx][endy] + ",7,Wang,Kelly";
    }
    public String toString(){
	String retString = "";
	for(int i = 0;i<pasture.length;i++){
	    for(int index = 0;index<pasture[0].length;index++){
		retString += (pasture[i][index]);
	    }
	    retString += ("\n");
	}
	return retString;
    }
    
    public static void main(String[]args){
	Silver s1 = new Silver("data1.dat");
	System.out.println(s1.solve());
    }
}

