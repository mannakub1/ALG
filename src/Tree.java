
public class Tree {
	private int Data ;
	private Tree Left;
	private Tree Right;
	
	public Tree(int data , Tree left , Tree right ){
		Data = data;
		Left = left;
		Right = right;
	}
	public Tree(int data){
		Data = data;
	}
	public Tree(){
		
	}
	
	public int getData(){
		return Data;
	}
	public void setData(int data){
		Data = data;
	}
	public Tree getLeft(){
		return Left;
	}
	public void setLeft(Tree left){
		Left = left;
	}
	public Tree getRight(){
		return Right;
	}
	public void setRight(Tree right){
		Right = right;
	}
	
}
