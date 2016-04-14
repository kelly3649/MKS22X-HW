public class Driver{
    public static void main(String[]args){
	BetterMaze b1 = new BetterMaze("data1.dat");
	System.out.println(b1.solveDFS());
    }
}
