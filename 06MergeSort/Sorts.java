import java.util.*;
import java.io.*;
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
    public static void merge(int[] data, int startA, int endA, int startB, int endB){System.out.println("endB/startB" + endB + "/" + startB + endA + "/" + startA);
	
	int[] newAry = new int[data.length];
	int cntrA = startA;
	int cntrB = startB;
	int i = 0;
	while(i<endB-startA+1){
	    if(cntrA == endA+1){
		newAry[i+startA] = data[cntrB];
		cntrB++;
	    }
	    else if(cntrB == endB + 1){
		newAry[i+startA] = data[cntrA];
		cntrA++;
	    }
	    
	    else if(data[cntrA] <= data[cntrB]){
		newAry[i+startA] = data[cntrA];
		cntrA++;
	    }
	    else{
		newAry[i+startA] = data[cntrB];
		cntrB++;
	    }
	    printArray(newAry);
	    i++;
	}
	/*if(cntrA == endA+1){
	    for(int i = cntrB;i<endB+1;i++){
		newAry[i] = data[i];
	    }
	}
	else{for(int i = cntrA;i<endA+1;i++){
		newAry[i] = data[i];
	    }
	    }*/
	//copy it over
	printArray(newAry);
	for(int index = startA;index<endB+1;index++){
		//		System.out.println(newList.get(i));
	    data[index] = newAry[index];
	}
	printArray(data);
    }

    public static void mergesortH(int[] data,int start, int end){
	if(end==start){
	    return; //stops the function
	}
	else{
	    mergesortH(data,start,start + (end-start)/2);
	    mergesortH(data,1 + start + (end-start)/2,end);
	    merge(data,start,start + (end-start)/2,1 + start + (end-start)/2,end);
	}

	//System.out.println("data length is" + data.length + "start/end" + start + "/" + end);
	
    }

    public static String name(){
	return "7,Wang,Kelly";
    }
    public static void mergesort(int[] data){
	 mergesortH(data,0,data.length-1);
    }
    public static void main(String[]args){
	System.out.println(name());
	int[] ary = {0,1,-3,4};
	int[] ary2 = {-5,2,5,6};
		merge(ary2,0,1,2,3);
	
	//	mergesort(ary);
	printArray(ary2);
	int[] arey = {-1,-3,-2,-2,-2,5,10,1};
	int[] arey2 = {-5,3,1,4,6,-1};
	mergesort(arey2);
	printArray(arey2);
	//	System.out.println(1/2);
    }
}

