package util;

import java.util.AbstractSet;
import java.util.Iterator;

public class UnbalancedTreeSet<T> extends AbstractSet<T> {
	private static Object PRESENT = new Object();
	private UnbalancedTreeMap<T, Object> mMap;
	
	
	public final class SetBSFIterator implements BSFIterator<T> {
		private UnbalancedTreeSet. mapIterator;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getLevel() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new SetBSFIterator();
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mMap.size();
	}
}
