
public class StackImpl<T> implements Stack<T>{
	private Node<T> top;

    @Override
    public void push(T data) {
        Node<T> newNode = new Node<>(data, top);
        Stack<T> newStack=new StackImpl<>();
        Node<T> popped;
        boolean check=true;
        
        while(top!=null){
        	popped=this.top;
        	this.top=top.getNext();
        	newStack.push(popped.getData());
        	
        	if(popped.getData()==data){
        		System.out.println("The item "+data+" isn't added because it is already there!");
        		check=false;
        		break;
        	}
        }
        T newdata;
        
        while(!newStack.isEmpty()){
    		newdata=newStack.pop();
    		popped=new Node<>(newdata,top);
    		this.top = popped;
    	}
    	
        if(check){
        	this.top = newNode;
        }
    }

    @Override
    public T pop() {
        if (top != null) {
            Node<T> popped = this.top;
            this.top = top.getNext();
            return popped.getData();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }
}
