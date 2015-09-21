import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class BinarySearchTree extends Tree {
	private Tree root;
	
	
//------------------------------------ ReadFile -----------------------------------------------	
	public void ReadFile() throws IOException{
		FileReader read = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(read);
		 boolean status = true;
		 String input = br.readLine();
		 while(status == true){
			 status = Process(input);
			 input = br.readLine();
			 if(input == null){
				 status = false;
			 }
		 }
		 //Print();
	}
//--------------------------------------------------------------------------------------------------		
	
//------------------------------------ AddBinarySearchTree -----------------------------------------------		
	public void add(String msg){
		msg = msgSubString(msg,1, msg.length());
		int number = Integer.parseInt(msg);
		add(number);
	}
	public void add(int data ){
		Tree newItem = new Tree(data);
		if(isEmpty(root))
			root = newItem;
		else
			add(data,root);
	}
	public void add(int data, Tree tree){
		Tree newItem = new Tree(data);
		if(data == tree.getData()){
			return;
		}else if(data < tree.getData()){
			if(isEmpty(tree.getLeft())){
				tree.setLeft(newItem);
			}else
				add(data,tree.getLeft());
		}else if(data > tree.getData()){
			if(isEmpty(tree.getRight())){
				tree.setRight(newItem);
			}else
				add(data,tree.getRight());
		}
	}
//--------------------------------------------------------------------------------------------------	
	
	
//------------------------------------ DeleteBinarySearchTree -----------------------------------------------	
	public void delete(String msg){
		msg = msgSubString(msg,1, msg.length());
		int number = Integer.parseInt(msg);
		delete(number);
	}
	public void delete(int data){
		if(root != null){
			if(root.getData() == data){
				Tree tree = new Tree(0);
				tree.setLeft(root);
				delete(data,tree);
				root = root.getLeft();
				
			}else {
				delete(data,root);
			}
		}
	}	
	public Tree delete(int data, Tree tree  ){
		if(data < tree.getData()){
			if(!isEmpty(tree.getLeft())){
				tree.setLeft(delete(data,tree.getLeft()));	
			}
		}else if(data > tree.getData()){
			if(!isEmpty(tree.getRight())){
				tree.setRight(delete(data,tree.getRight()));
			}
		}else {
			if(!isEmpty(tree.getLeft())&&!isEmpty(tree.getRight())){
				tree.setData(minValue(tree.getRight()));
				tree.setRight(delete(tree.getData() , tree.getRight()) );
			}else if(isEmpty(tree.getRight())){
				return tree.getLeft();
			}else if(isEmpty(tree.getLeft())){
				return tree.getRight();
			}else {
				return null;
			}
		}
		return tree;
	}
//--------------------------------------------------------------------------------------------------		


//------------------------------------ Running --------------------------------------------------------------		
	public boolean Process(String msg){
		if(isLineEmpty(msg))
			return true;
		msg = msg.toUpperCase();
		if(msg.charAt(0) >= '0' && msg.charAt(0) <= '9'){
			int number = Integer.parseInt(msg);
			add(number);
		}else if(msg.charAt(0) != 'E' && msg.charAt(0) != 'e'){
			String[] msgArr = msg.split(" ");
			for(int index = 0 ; index < msgArr.length ; index++){
				if(msgArr[index].charAt(0) == 'A'){
					add(msgArr[index]);
				}else if(msgArr[index].charAt(0) == 'D'){
					delete(msgArr[index]);
				}else if(msgArr[index].charAt(0) == 'P'){
					Print();
				}
			}
		}else {
			System.out.println("EndProgram\nGood Bye ^^.");
			return false;
		}
		return true;
	}
	public void Input() throws IOException{
		Scanner input = new Scanner(System.in);
		boolean status = true;
		while(true){
			String msg = input.nextLine();
			status = Process(msg);
 		}
	}
	public void Start() throws IOException{
		ReadFile();
		//Input();	
	}
//--------------------------------------------------------------------------------------------------		
	
	
//----------------------------------- Method Support---------------------------------------------------------------	
	public int minValue(Tree tree) {
		if (isEmpty(tree.getLeft())) {
			return tree.getData();
		}
		return minValue(tree.getLeft());
	}

	public void printPreOrder(Tree tree) {
		if (tree == null) {
			System.out.print("-");
			return;
		}
		System.out.print(tree.getData());
		System.out.print("[");
		printPreOrder(tree.getLeft());
		printPreOrder(tree.getRight());
		System.out.print("]");
	}

	public void Print() {
		System.out.print("PrintPreOrder :: ");
		printPreOrder(root);
		System.out.println();
	}

	public void printAddComplete(int number) {
		System.out.println("Add number " + number + "Complete");
	}

	public void printAddError(int number) {
		System.out.println("Add number " + number + "Error");
	}

	public void printDeleteComplete(int number) {
		System.out.println("Delete number" + number + "Complete");
	}

	public void printDeleteError(int number) {
		System.out.println("Delete number " + number + "Error");
	}

	public boolean isEmpty(Tree tree) {
		if (tree == null)
			return true;
		return false;
	}
	
	public boolean isLineEmpty(String msg){
		if(msg.length() == 0)
			return true;
		else 
			return false;
	}
	public String msgSubString(String msg, int beginIndex, int endIndex) {
		return msg.substring(beginIndex, endIndex);
	}

	//--------------------------------------------------------------------------------------------------		
		
	public static void main(String []agrs) throws IOException{
		BinarySearchTree tree = new BinarySearchTree();
		System.out.println("Hello Everyone!!");
		tree.Start();
	}

}