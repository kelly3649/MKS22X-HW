import java.io.*;
import java.util.*;

public class Silver{
    private int startx=-1, starty=-1, endx=-1, endy=-1;
    private int numRow=1, numCol=1;
    private int[][] pasture = new int[numRow][numCol];
    private int time=0; //num of seconds taken
    private int[][] copy = new int[numRow][numCol];
    public Silver(String filename){
	ArrayList<String> arylist = new ArrayList<String>();
	try{
	    Scanner sc = new Scanner(new File(filename));
	    numRow = sc.nextInt();
	    numCol = sc.nextInt();
	    time = sc.nextInt();
	    //	    System.out.println(numRow + " " + numCol + " " + time);
	    int cntr = 0;
	    while(cntr<numRow+1){ //bec first line is empty string
		arylist.add(sc.nextLine());
		cntr++;
	    }
	    
	    pasture = new int[numRow][numCol];
	    for(int i = 0;i<numRow;i++){
		for(int index = 0;index<numCol;index++){
		    if(arylist.get(i+1).charAt(index) == '*'){
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
	    pasture[startx][starty] = 1;
	}catch(FileNotFoundException e){
	    System.out.println("FILE NOT FOUND");
	}
    }
    public int sumOf(int row, int col){
	int retInt = 0;
	if(pasture[row][col] < 0){
	    return -1;
	}
	if(row+1<numRow && pasture[row+1][col] >= 0){    
	    retInt += pasture[row+1][col];
	}
	if(row-1>=0 && pasture[row-1][col] >= 0){    
	    retInt += pasture[row-1][col];
	    
	}
	if(col+1<numCol && pasture[row][col+1] >= 0){    
	    retInt += pasture[row][col+1];
	}
	if(col-1>=0 && pasture[row][col-1] >= 0){    
	    retInt += pasture[row][col-1];
	}
	return retInt;
    }
    public String solve(){
	//if time was == to 1, then there is only 1 way to get to the start
	int t = 1; 
	while(t<time+1){
	    int[][] newAry = new int[numRow][numCol];
	    //System.out.println(toString());
	    for(int i = 0;i<numRow;i++){
		for(int index = 0;index<numCol;index++){
		    newAry[i][index] = sumOf(i,index);
		}
	    }
	    pasture = newAry;
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
	System.out.println(s1);
	System.out.println(s1.solve());
	Silver s2 = new Silver("data2.dat");
	System.out.println(s2);
	System.out.println(s2.solve());
    }
}

