package com.nit.hk.collection;
public class NITCollection {
	
	private Object[] 	elementData;
	private int 		elementCount;   
	
	public NITCollection() {
		this(10);
	}
	
	public NITCollection(int capacity) {
		elementData 	= new Object[capacity];
		elementCount 	= 0;
	}

	public void add(Object obj) {
		if(size() == capacity()){
			grow();
		}
		elementData[elementCount] = obj;
		elementCount++;
	}

	private void grow() {
		//creating new array object with double capacity
		Object[] nextArray = new Object[capacity()*2];
		
		//copying elements from old array into this new array
		for(int i=0; i<elementData.length; i++) {
			nextArray[i] = elementData[i];
		}
		
		//assigning new array reference to old array referenced variable
		elementData = nextArray;
	}

	public int capacity() {
		return elementData.length;
	}

	public int  size() {
		return elementCount;
	}
	
	@Override
	public String toString() {
		if(this.size()==0)
			return "[]";
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0; i<size(); i++) {
			sb.append( elementData[i] );
			sb.append( ", " );
		}
		
		int lastIndex = sb.lastIndexOf(", ");
		sb.delete(lastIndex, lastIndex+2);
		sb.append("]");
		
		return sb.toString();
	}

	public boolean contains(Object obj) { //col.contains(new Sa(5,6));
//		
//		for(int i=0; i<elementCount; i++) {
//			if(obj.equals(elementData[i])) {
//				return true;
//			}
//		}
//		
		return indexOf(obj)>=  0;
	}
	
	// index of method 
	public int indexOf(Object obj) {
		Object[] ed = elementData;
		if(obj == null) {	
			for(int i=0; i<elementCount; i++) {
				if(null == ed[i]) {
					return i;
				}
			}
		}	
		
			 for(int i=0; i<elementCount; i++) {
					if(obj.equals(ed[i])) {
						return i;
					}
			 }
		
		return -1;
	
		
	}
	
	//lastIndexOf method  (last occurrence)
	
	public int lastIndexOf(Object obj) {
		Object[] ed = elementData;
		if(obj == null) {	
			for(int i=elementCount-1; i>=0; i--) {
				if(null == ed[i]) {
					return i;
				}
			}
		}	
		
			 for(int i=elementCount-1; i>=0; i--) {
					if(obj.equals(ed[i])) {
						return i;
					}
			 }
		
		return -1;
	
		
	}
	
	// get index method
	
	public Object get(int index) {
		if(index<0 || index>=elementCount){
			throw new IndexOutOfBoundsException(index);
		}
		
		return elementData[index];
		
		
	}
	
	// remove(int index) method
	
	public Object remove(int index) {
		
		if(index<0 || index>elementCount) {
			throw new IndexOutOfBoundsException(index);
		}
		// retrieving index object and store into the obj to print
		Object obj = elementData[index];
		
		for(int i=index ; i<elementCount-1 ; i++) {
			
			elementData[i] = elementData[i++];
			
		}
		elementData[elementCount-1]=null;
		elementCount--; 
		
		return obj;
	}
	
	//remove(object obj )
	
	public boolean remove(Object obj ) {
		
	int index =  indexOf(obj);
	if(index>=0) {
		remove(index);
		return true;
	}
		return false;
	}
	
}

