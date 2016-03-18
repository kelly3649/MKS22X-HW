import java.util.Random;
import java.util.Arrays;
public class Quick{
    private static long startTime = System.currentTimeMillis();
    
    private static int partitionOld(int[]data, int left, int right){
	Random r = new Random();
	int aIndex = r.nextInt(right-left+1) + left;
	int a = data[aIndex];
	//System.out.println("a/index" + a +"/" + aIndex);
	int strtR = right;
	//put "a" in corner, like a problem child
	int copy = data[strtR];
	data[strtR] = a;
	data[aIndex] = copy;
	//printArray(data);
	right--;
	while(left!= right){
	    //System.out.println("left/right" + left +"/" + right);
	    if(data[left] <= a){
		left++;
	    }
	    else{
		int temp=data[left];
		data[left] = data[right];
		data[right] = temp;
		right--;
	    }
	    //printArray(data);
	    //	    System.out.println("left/right" + left + "/" + right);
	}
	//place "a" back, but remember to check that what it swapped with
	if(data[left] < a){
	    int temp2 = data[left+1];
	    data[left+1] = a;
	    data[strtR] = temp2;
	    //printArray(data);
	    return left+1;
	}
	else{
	    int temp3 = data[left];
	    data[left] = a;
	    data[strtR] = temp3;
	    //  printArray(data);
	    return left;
	}		
    }
    public static int quickselectOld(int[] data, int k){
	return quickselectOld(data,k,0,data.length-1);	
    }
    private static int quickselectOld(int[] data, int k, int left, int right){
	if(left==right){
	    return data[left];
	}
	int retNum = partitionOld(data,0,data.length-1);
	if(retNum == k){ //if you guessed correctly, and it happened to be k
	    return data[k];
	}
	else{
	    if(retNum < k){
		return quickselectOld(data,k,retNum+1,right);
	    }
	    else{
		return quickselectOld(data,k,left,retNum-1);
	    }
	}
    }
    public static void quickSortOld(int[] data){
	quickSortOld(data,0,data.length-1);
    }
    private static void quickSortOld(int[] data, int left, int right){
	//System.out.println("left/right" + left + "/" + right);
	if(right-left>=1){
	    int retNum = partitionOld(data,left,right);
	    //printArray(data);
	    if(retNum-1 > left){
	    quickSortOld(data,left,retNum-1);
	    }
	    if(retNum+1 < right){
	    quickSortOld(data,retNum+1,right);
	    }
	}
    }
    private static int[] partition(int[]data, int left, int right){
	Random r = new Random();
	int aIndex = r.nextInt(right-left+1) + left;
	int a = data[aIndex];
	//System.out.println("a/index" + a +"/" + aIndex);
	int[] temp = new int[right-left+1];
	int current = left;
	int end = right;
	int L = 0;
	int R = temp.length-1;
	while(current<=end){
	    if(data[current] > a){
		temp[R] = data[current];
		R--;
		current++;
	    }
	    else if (data[current] < a){
		temp[L] = data[current];
		L++;
		current++;
	    }
	    else{
		current++;
	    }
	}
	int[] indeces = {L+left,R+left};
	while(L<=R){
	    temp[L] = a;
	    L++;
	}
	for(int i = left;i<right+1;i++){//copying back array
	    data[i] = temp[i-left];
	}
	//printArray(data);
	//printArray(indeces);
	return indeces;
    }
        
    public static void quickSort(int[] data){
	quickSort(data,0,data.length-1);
    }
    private static void quickSort(int[] data, int left, int right){
	//System.out.println("left/right" + left + "/" + right);
	if(right-left>=1){
	    int[] indeces = partition(data,left,right);
	    //printArray(data);
	    quickSort(data,left,indeces[0]-1);
	    quickSort(data,indeces[1]+1,right);
	}
    }
    public static void printArray(int[] data){
	String retString = "[";
	int i = 0;
	while(i<data.length - 1){
	    retString += data[i] + ", ";
	    i++;
	}
        retString += data[data.length-1] + "]";
	System.out.println(retString);
    } 
    public static void main(String[]args){
	int[] ary = {20,15,9,-2,6,2,4,15,7};
      	//partition(ary,0,ary.length-1);
	//quickSortOld(ary);
	//printArray(ary);
	int[] ary2 = {2,15,9,9,-2,-4,6,20};
	//partition(ary2,0,ary2.length-1);
	//quickSort(ary2);
	//printArray(ary2);
	//System.out.println(quickselect(ary2,0));
	/* 4a
	int[] d = new int [4000000];
	int[] c = new int [d.length];
	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    c[i]= d[i];
	}
	quickSort(d); //or even your old quicksort!!!
	Arrays.sort(c);
	System.out.println("Done: Sorted=" + Arrays.equals(d,c));
	*/
	
	int[]a = new int [4000000];//fill with random values from 0 to 3 inclusive
	//Calculate the time it takes to do each of the following: (average 3 runs to be precise)
	//a1
	//Arrays.sort(a);
	//a2
	//Quick.quickSortOld(a);
	//a3
        //Quick.quickSort(a);
	int[]b = new int [4000000];//fill with random values from Integer.MIN_VALUE to Integer.MAX_VALUE inclusive.
	//Calculate the time it takes to do each of the following: (average 3 runs to be precise)
	//b1
	//Arrays.sort(b);
	//b2
	//Quick.quickSortOld(b);
        //b3
	//Quick.quickSort(b);
	long endTime = System.currentTimeMillis();
	//System.out.println("It took" + (endTime-startTime) + "milsec");
    }
}
