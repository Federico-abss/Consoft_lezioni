package main;
import collections.MyCollection;

public class Main {

	public static void main(String[] args) {
		
		MyCollection coll = new MyCollection();
		coll.add("String");
		System.out.println(coll.collection[0]);
		System.out.println(coll.contains("String"));
		System.out.println(coll.isEmpty());
		coll.clear();
		System.out.println(coll.isEmpty());
	}

}
