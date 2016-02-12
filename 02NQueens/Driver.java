public class Driver{
    public static void main(String[]args){
	QueenBoard b1;
	if(args.length > 0){
	    b1 = new QueenBoard(Integer.parseInt(args[0]));
	}
	else{
	    b1 = new QueenBoard();
	}
	QueenBoard b = new QueenBoard(1);
	QueenBoard b2 = new QueenBoard(2);
	QueenBoard b3 = new QueenBoard(3);
	QueenBoard b4 = new QueenBoard(4);
	
	/*	b1.printBoard();
	b1.addQueen(0,0);
	b1.printBoard();
	b1.addQueen(2,1);
	b1.printBoard();
	b1.addQueen(3,3);
	b1.printBoard();
	b1.rmvQueen(2,1);
	b1.printBoard();*/
	b.solve();//works!
	b.printSolution();
        b2.solve(); //works!
	b2.printSolution();
	b3.solve();
	b3.printSolution();
	b4.solve();
	b4.printSolution();
    }
}
