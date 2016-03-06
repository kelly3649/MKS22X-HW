public class Sorts{

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
    public static void insertionSort(int[] data){
	for(int nextI = 1;nextI<data.length;nextI++){
	    int nowI = nextI;
	    while(nowI > 0 && data[nowI] < data[nowI-1]){
		int copy = data[nowI-1];
		data[nowI-1]=data[nowI];
		data[nowI] = copy;
		nowI -= 1;	
	    }
	  
	}

    }
    
    public static void selectionSort(int[] data){
	for(int i = 0;i<data.length;i++){//places into right spot
	    	int min = data[i];
		int minIndex = i;
	    for(int index = i;index<data.length;index++){//set min
		if(min>data[index]){
		    min = data[index];
		    minIndex = index;
		}
	    }
	    int copy = data[i];
	    data[minIndex] = copy;
	    data[i] = min;
	}
    }
    public static void bubbleSort(int[] data){
	for(int i = 0;i<data.length;i++){
	    for(int index = 0;index<data.length-i-1;index++){
		if (data[index] > data[index+1]){
		    int copy = data[index];
		    data[index] = data[index+1];
		    data[index+1] = copy;
		}//printArray(data);
	    }printArray(data);
	}
    }
    public void merge(int[] data, int startA, int endA, int startB, int endB){
	int[] halfA = new int[endA-startA+1];
	int[] halfB = new int[endB-startB+1];
	ArrayList<Integer> newList = new ArrayList<Integer>();
	int cntrA = 0;
	int cntrB =0;
	while(cntrA < halfA.length && cntrB<halfB.length){
	    if(halfA[cntrA] <= halfB[cntrB]){
		newList.add(halfA[cntrA]);
		cntrA++;
	    }
	    else{
		newList.add(halfB[cntrB]);
		cntrB++;
	    }
	}
	if(cntrA == halfA.length()){
	    for(int i = cntrB;i<halfB.length;i++){
		newList.add(halfB[i]);
	    }
	}
	else{for(int i = cntrA;i<halfA.length;i++){
		newList.add(halfA[i]);
	    }
	}
	//copy it over
	for(int i = 0;i<newList.size();i++){
	    data[i] = newList.get(i);
	}
    }
    public static void mergeSortH(int[] data,int start, int end){
    }
    public static void mergeSort(int[] data){
	 mergeSortHelper(data,0,data.length-1);
    }
    public static void main(String[]args){
	int[] ary = {0,1,-12,4,5,2,-1};
	bubbleSort(ary);
	printArray(ary);
	int[] arey = {-1,3,-2,-2,-2};
	bubbleSort(arey);
	printArray(arey);
    }
}

