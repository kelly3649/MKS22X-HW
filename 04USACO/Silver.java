import java.io*;
import java.lang*;

public class Silver{
    private char[][] pasture = new char[numRow][numCol];
    private int startx=-1, starty=-1, endx=-1, endy=-1;
    private int numRow=0, numCol=0;
    private int time=0; //num of seconds taken

    public Silver(String filename){
	try{
	Scanner sc = new Scanner(new File(filename));
	numRow = sc.next();
	numCol = sc.next();
	time = sc.next();
	pasture = new char[numRow][numCol];
	for(int i = 0;i<numRow;i++){
	    for(int index = 0;index<numCol;index++){
		pasture[i][index] = sc.next();
	    }
	}
	}
}
