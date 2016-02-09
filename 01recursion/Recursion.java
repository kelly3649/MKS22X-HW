import java.lang.Math;
public class Recursion implements hw01{
    public String name(){
	return "Wang," + "Kelly";
    }
    public double sqrtH(double guess, double n){
	if(n==0){
	    return n;
	}
	if((Math.abs(n - guess*guess) / ((guess*guess + n) / 2)) * 100 < 0.0000000000001){
	    return guess;
	}
	return sqrtH((n/guess + guess)/2,n);
    }
    public double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return sqrtH(n/2,n);
    }
}
