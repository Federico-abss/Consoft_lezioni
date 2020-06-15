package collections;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection implements Collection<String> {
	
	public String[] collection = new String[0]; 

	@Override
	public boolean addAll(Collection<? extends String> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		String[] temp = new String[0];
		collection = temp;		
	}

	@Override
	public boolean contains(Object o) {
		String s=(String)o;
		
		for(String x:collection) {
			if (x.equals(s)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean add(String e) {
		String[] temp = new String[collection.length + 1];
		for(int i = 0; i < collection.length; i++) {
			temp[i] = collection[i];
		}
		
		temp[temp.length-1] = e;
		collection = temp;
		
		return this.contains(e);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (collection.length == 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return collection.length;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
