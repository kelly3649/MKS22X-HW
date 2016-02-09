import java.lang.Math;
public class Recursion{
    public String name(){
	return "Wang," + "Kelly";
    }
    public double sqrtH(double guess, double n){
	if((Math.abs(n - guess*guess) / ((guess*guess + n) / 2)) * 100 < 1){
	    return guess;
	}
	return sqrtH((n/guess + guess)/2,n);
    }
    public double sqrt(double n){
	return sqrtH(n/2,n);
    }
}
