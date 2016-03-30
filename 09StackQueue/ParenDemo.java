import java.util.*;
public class ParenDemo{

    public static char closeParen(char openParen){
	if(openParen == '}'){
	    return '{';
	}
	if(openParen == ']'){
	    return '[';
	}
	if(openParen == '>'){
	    return '>';
	}
	else{
	    return '(';
	}
    }
    public static boolean isOpen(char c){
	if(c == '<' || c=='{' || c=='[' || c=='('){
	    return true;
	}
	return false;
    }

    public static boolean isClose(char c){
	if(c == '>' || c=='}' || c==']' || c==')'){
	    return true;
	}
	return false;
    }
    
    public static boolean isMatching(String s){
	MyStack<Character> pStack = new MyStack();
	for(int i = 0;i<s.length();i++){
	    if(isOpen()){
		pStack.push(s.charAt(i));
	    }
	    if(isClose()){
		char expected = 
	ArrayList<Character> pList = new ArrayList<Character>(); //not char
	char[] pAry = {'{','<','(','[','}','>',')',']'}; //8 beg and end paren
	//first, make an ArrayList, with ONLY the paren, exluding all other char
	for(int i = 0;i<s.length();i++){
	    for(int index = 0;index<pAry.length;index++){
		if(s.charAt(i) == pAry[index]){
		    pList.add(s.charAt(i));
		}
	    }
	}
	int i = 0; //should never incrs
	while(i<pList.size()){ //will stop when list is empty or ret false
	    int index = 1; //also should never change
	    //System.out.println("i/index/open" + i +  "/" + index + "/" + pList.get(i));
	    if(isOpen(pList.get(i))){
		while(index < pList.size() && closeParen(pList.get(i)) != pList.get(index)){
		  index++;
		}
	    }
	    else{ // is a closing bracket, check if is right one
		if(
	    }
	    //System.out.println("after while loop, index is:" + index);
	    if(index < pList.size()){ //stopped bc found end paren
		pList.remove(index);//remove that pair
		pList.remove(i);
	    }
	    else{ //reached end w/o finding end paren
		return false;
	    }
	}
	return true;
    }
    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println(isMatching(input));
	    System.out.println(isMatching("([])"));
	    System.out.println(isMatching("({})(]"));
	    System.out.println(isMatching("({)}") + "may have a problem");
	    System.out.println(isMatching(")[({})]"));
	    System.out.println(isMatching("[FISH(I)ES]"));
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
 
    }

}
