package com.myPractice.java;

class CustomHashMap<K,V> {
	private Entry[] table;
	private int size=4;
	
	static class Entry<K,V> {
		K key;
		V value;
		Entry<K,V> next;
		
		public Entry(K key, V value, Entry<K, V> next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
	}
	
	 public CustomHashMap() {
		this.table = new Entry[size];
	}
	 
	 @SuppressWarnings("unused")
	public void put(K key, V value) {
		 int hash=hash(key);
		 if(key==null) {
			 return;
		 }
		 
		 Entry newEntry = new Entry(key,value,null);
		 
		 if(table[hash]==null) {
			 table[hash]= newEntry;
		 }else {
			 Entry prev = null;
			 Entry curr = table[hash];
			 while(curr!=null) {
				 if(curr.key.equals(key)) {
					 if(prev==null) {
						 newEntry.next=curr.next;
						 table[hash]=newEntry;
						 return;
					 }else {
						 prev.next=newEntry;
						 newEntry.next=curr.next;
						 return;
					 }
				 }
				 prev=curr;
				 curr=curr.next;
			 }
			 prev.next=newEntry;
		 }
		 
	 }
	 
	 public int hash(K key) {
		 return Math.abs(key.hashCode()%size);
	 }
	 
	 public V get(K key) {
		 int hash = hash(key);
		 if(table[hash]==null) {
			 return null;
		 }else{
			 Entry<K,V> temp = table[hash];
			 while(temp!=null) {
				 if(temp.key.equals(key)) {
					 return temp.value;
				 }
				 temp=temp.next;
			 }
			 return null;
		 }
		 
	 }

}

