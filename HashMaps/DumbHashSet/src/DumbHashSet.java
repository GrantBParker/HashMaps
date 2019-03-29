
public class DumbHashSet extends java.lang.Object {

	private MyArrayList<String>[] buckets = new MyArrayList[27];
	private java.util.Iterator<String> iterator = null;

	public DumbHashSet() {

	}

	public boolean add(java.lang.String s) {
		if (s == null) {
			throw new IllegalArgumentException(s + " is null and annot be added.");
		} else {
			int position = hashCode(s);
			if (buckets[position] == null) {
				MyArrayList<String> bucket = new MyArrayList<String>();
				buckets[position] = bucket;
			}
			buckets[position].add(s);
			return true;
		}
	}

	public boolean remove(java.lang.String s) {
		if (s == null) {
			throw new IllegalArgumentException(s + " is not found in this set. Cannot be removed.");
		} else {
			this.remove(s);
			return true;
		}
	}

	public boolean contains(java.lang.String s) {
		if (s == null) {
			throw new IllegalArgumentException(s + " is not found in this set.");
		}
		return false;
	}

	public int size() {
		return this.size();
	}

	// For the iterator, have another MyList instance variable. When iterator() is
	// called,
	// walk the entire set adding every element to this extra MyList. Then set up
	// and return
	// an iterator on this instance variable. (MyArrayList already has an iterator.)
	// Be sure to invalidate this iterator support MyList if add or remove are
	// called.
	// I did this by setting the instance variable to null.

	public java.util.Iterator<String> iterator() {
		return new DumbHashSetIterator();
	}

	private class DumbHashSetIterator implements java.util.Iterator<String> {
		private MyList<String> collection = new MyArrayList<String>();
		private int currentBucketsIndex = 0; // Current buckets index
		private int currentListIndex = 0; // Current index

		DumbHashSetIterator() {
			listSetUp();
		}

		public void listSetUp() {
			for (int i = 0; i < 27; i++) {
				MyArrayList<String> currentList = buckets[currentBucketsIndex];
				for (String elements : currentList) {
					collection.add(elements);
				}
				currentBucketsIndex = currentBucketsIndex++;
			}
		}

		@Override
		public boolean hasNext() {
			return (currentListIndex < collection.size());
		}

		@Override
		public String next() {
			return collection.get(currentListIndex++);
		}
	}

	public int hashCode(String s) {
		int lastBucket = 26;
		int code = s.toLowerCase().charAt(0) - 'a';
		if (code < lastBucket && code >= 0) {
			return code;
			}
		else {
			return lastBucket;
			}
	}


	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("DumbHashSet : \n");

		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null){
				result.append("**Bucket " + i + "** \n");
			}
			MyArrayList<String> list = buckets[i];
			if (buckets[i] != null) {
				for (String elements : list) {
					result.append(elements);
					result.append("\n");
					}
				}
			}
		return result.toString();
	}
}
