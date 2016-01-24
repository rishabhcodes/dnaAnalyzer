package dna;

import java.util.*;
import edu.duke.*;

/**
 * This class enables execution of services provided by the codon class
 * @author risshah
 *
 */

public class CodonExecute {
	
		
	public static void main(String[] args){
		CodonExecute ce = new CodonExecute();
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please input the mode: ");
		
		int mode = in.nextInt();
		in.nextLine();
//		in.close();
		
		if (mode == 1){
			ce.simpleTestOne();
		} else if (mode == 2){
			ce.simpleTestTwo();
		}
	}
	
	/**
	 * Takes a dna strand as input and invokes the appropriate methods in Codon class to decompose it into codons
	 */
	public void simpleTestOne(){
		Scanner in = new Scanner(System.in);
		Codon co = new Codon();		
		
		System.out.println("Please enter the dna strand to analyze:");
		String s = in.nextLine();
		System.out.println();
		
//		String s = "CGTTCAAGTTCAA";
		
		System.out.print("Please enter start position: ");
		int i = in.nextInt();
		
		co.buildCodonMap(s,i);
		co.printCodonMap();
		
	}
	/**
	 * Takes a file as input and outputs codons with all 3 possible reading frames 0,1 and 2
	 */

	public void simpleTestTwo(){
		Scanner in = new Scanner(System.in);
		Codon co = new Codon();	
		
		System.out.println("Please select a file. It may take a moment...");
		
		FileResource fr = new FileResource();
		String s = fr.asString().trim();
		
		co.buildCodonMap(s,0);
		System.out.println("Start position 0");
		co.printCodonMap();

		co.buildCodonMap(s,1);
		System.out.println("Start position 1");
		co.printCodonMap();		
		
		co.buildCodonMap(s,2);
		System.out.println("Start position 2");
		co.printCodonMap();		
	}
}
