public class Driver{
    public static void main(String[]args){
	Board b1;
	if(args.length > 0){
	    b1 = new Board(Integer.parseInt(args[0]));
	}
	else{
	    b1 = new Board();
	}
	Board b = new Board(1);
	Board b2 = new Board(2);
	Board b3 = new Board(3);
	
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
    }
}
