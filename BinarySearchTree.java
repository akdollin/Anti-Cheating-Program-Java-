
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
	private BinaryNode<AnyType> root;
	public int nodeCounter;
	
	//constructor
	public BinarySearchTree( )
	{
		root = null;
		nodeCounter=0;
	}

	//subclass BINARYNODE
	private static class BinaryNode<AnyType>
	{
		//instance variable
		AnyType element;            // The data in the node
		BinaryNode<AnyType> left;   // Left child
		BinaryNode<AnyType> right;  // Right child
		Boolean deleted;  //for lazy deletion
		
		//constructor for root
		public BinaryNode( AnyType theElement, BinaryNode<AnyType> left, BinaryNode<AnyType> right, Boolean f)
		{
			element  = theElement;
			this.left     = left;
			this.right    = right;
			deleted = false;
		}
	}
	//public insert method
	public void insert( AnyType x )
	{
		root = insert( x, root );
	}
	
	//3rd written
	public int counter = 0;
	public int fullNode()
	{
		return fullNode(root);
	}
	
	public int fullNode( BinaryNode<AnyType> n) {
		  if (n==null){
		    return counter;
		  }

		  else if (n.left != null && n.right != null ){
		    counter++;
		  }
		  else if(n.right==null){
			  fullNode(n.left);
		  }
		  else if(n.left==null){
			  fullNode(n.right);
		  }		  
		  return counter;
		}
	
	
	//private insert method
	private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
	{
		nodeCounter++;
		if( t == null )
			return new BinaryNode<AnyType>( x, null, null,false);

		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			t.left = insert( x, t.left );
		else if( compareResult > 0 )
			t.right = insert( x, t.right );
		else if (compareResult==0)
			if(t.deleted=true)
				t.deleted=false;
			;  // Duplicate; do nothing
		return t;
	}
	
	public AnyType findMin( )
	{
		if( isEmpty( ) )
			System.out.println("Exception, Underflow");
			//System.exit(0);
		return findMin( root ).element;
	}
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) 
	{
		if (t == null) 
			return null;
		BinaryNode<AnyType> temp= findMin(t.left);

		if (temp != null) 
			return temp;
		if (!t.deleted) 
			return t;
		else
			return findMin(t.right);
	}

	public AnyType findMax( )
	{
		if( isEmpty( ) )
			throw new UnderflowException("Underflow" );
		return findMax( root ).element;
	}
	private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
	{
		if (t == null) 
			return null;
		BinaryNode<AnyType> temp= findMax(t.right);

		if (temp != null) 
			return temp;
		if (!t.deleted) 
			return t;
		else
			return findMax(t.left);
	}

	public boolean contains( AnyType x )
	{
		return contains( x, root );
	}

	private boolean contains( AnyType x, BinaryNode<AnyType> t )
	{
		if( t == null )
			return false;

		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			return contains( x, t.left );
		else if( compareResult > 0 )
			return contains( x, t.right );
		else 
			if(t.deleted=true)
				return false;
		return true;   
	}
	public void remove(AnyType x)
	{
		remove(x,root);
	}
	
	private void remove(AnyType x, BinaryNode<AnyType> t)
	{
		nodeCounter--;
		if(contains(x))
		{
			int compareResult = x.compareTo( t.element );

			if( compareResult < 0 )
				remove( x, t.left );
			else if( compareResult > 0 )
				remove( x, t.right );
			else
				t.deleted = true;
		}
	}
	
	public void makeEmpty( )
	{
		root = null;
	}

	public boolean isEmpty( )
	{
		if(nodeCounter==0)
			return true;
				
		return false;
	}
	
	public void printTree( )
	{
		if (! isEmpty( )) 
			printTree( root );
		else
			System.out.println("Exception, Underflow");
			//System.exit(0);
	}

	private void printTree( BinaryNode<AnyType> t )
	{
		if( t != null)
		{
			printTree( t.left );
			if(!t.deleted)
				System.out.print(t.element+" " );
			printTree( t.right );
		}
	}

	private int height(BinaryNode<AnyType> t)
	{
		if( t == null )
			return -1;

		else if (t!=null && !t.deleted)
			return 1 + Math.max(height(t.left), height( t.right)); 
		return 1;
	}
}