import java.util.*;
public class ParenDemo{

    public static char matchParen(char openParen){
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
	MyStack<Character> openParens = new MyStack<Character>();
	for(int i = 0;i<s.length();i++){
	    if(isOpen(s.charAt(i))){
		openParens.push(s.charAt(i));
	    }
	    if(isClose(s.charAt(i))){
		if(openParens.isEmpty()){ //too many closing parens
		    return false;
		}
		else{
		    char expected = matchParen(s.charAt(i));
		    if(openParens.pop() != expected){ //if match,rmv top of stack too 
			return false; //mismatch
		    }
		}
	    }
	}
	return openParens.isEmpty(); // if openParens is empty, all were matched
	//if openParens still had elements, there are too many opening parens
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

