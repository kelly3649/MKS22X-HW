import java.util.Random;

public class Quick{
    private static int partition(int[]data, int left, int right){
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
    public static int quickselect(int[] data, int k){
	return quickselect(data,k,0,data.length-1);	
    }
    private static int quickselect(int[] data, int k, int left, int right){
	if(left==right){
	    return data[left];
	}
	int retNum = partition(data,0,data.length-1);
	if(retNum == k){ //if you guessed correctly, and it happened to be k
	    return data[k];
	}
	else{
	    if(retNum < k){
		return quickselect(data,k,retNum+1,right);
	    }
	    else{
		return quickselect(data,k,left,retNum-1);
	    }
	}
    }
    public static void quickSort(int[] data){
	quickSort(data,0,data.length-1);
    }
    private static void quickSort(int[] data, int left, int right){
	//System.out.println("left/right" + left + "/" + right);
	if(right-left>=1){
	    int retNum = partition(data,left,right);
	    //printArray(data);
	    quickSort(data,left,retNum-1);
	    quickSort(data,retNum+1,right);
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
	int[] ary = {20,15,9,-2,6,7};
	//System.out.println(partition(ary,0,ary.length-1));
	//quickSort(ary);
	//printArray(ary);
	int[] ary2 = {2,15,9,9,-2,-4,6,20};
	//System.out.println(partition(ary2,0,ary2.length-1));
	//quickSort(ary2);
	//printArray(ary2);
	//System.out.println(quickselect(ary2,0));
    }
}
