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
    public static void main(String[]args){
	int[] ary = {0,1,-12,4,5,2,-1};
	bubbleSort(ary);
	printArray(ary);
	int[] arey = {-1,3,-2,-2,-2};
	bubbleSort(arey);
	printArray(arey);
    }
}

