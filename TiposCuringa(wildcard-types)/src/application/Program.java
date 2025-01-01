package application;

import java.util.Arrays;
import java.util.List;

public class Program {
	/*
	 * Generics são invariantes 
	 * List<Object> não é o supertipo de qualquer tipo de lista: 
	 * List<Object> myObjs = new ArrayList<Object>(); 
	 * List<Integer> myNumbers = new ArrayList<Integer>(); 
	 * myObjs = myNumbers; // erro de compilação 
	 * O supertipo de qualquer tipo de lista é List<?>. 
	 * Este é um tipo curinga:
	 * List<?> myObjs = new ArrayList<Object>(); 
	 * List<Integer> myNumbers = new ArrayList<Integer>(); 
	 * myObjs = myNumbers;
	 */
	public static void main(String[] args) {
		List<Integer> myInts = Arrays.asList(5, 2, 10);
		printList(myInts);
		
		List<String> myStrs = Arrays.asList("Maria", "Alex", "Bob");
		printList(myStrs);
	}

	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
}