package iterator;

public class NameCollection implements IteratorCollection {
	public String names[];
	public NameCollection(String names[]) {
		this.names = names;
	}
	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}
	
	public class NameIterator implements Iterator {
		
	    int index;

	    @Override
	    public boolean hasMore() {
	    
	       if(index < names.length){
	          return true;
	       }
	       return false;
	    }

	    @Override
	    public Object getNext() {
	    
	       if(this.hasMore()){
	          return names[index++];
	       }
	       return null;
	    }		
	 }
			
}
