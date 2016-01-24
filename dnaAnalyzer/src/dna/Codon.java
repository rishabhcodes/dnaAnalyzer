package dna;

import java.util.*;

/**
 * This class provides the methods to analyze the dna strands
 * Vocabulary used
 * Dna strand - A long string comprised of four symbols "C", "G", "T", "A". These symbols represent the 4 building blocks called
 * nucleotides
 * Codon - Codon is a combination of 3 consecutive symbols occuring consecutively in a dna strand. A dna strand can be decomposed 
 * into several codons (often repeating)
 * Reading Frame - A frame of reference to start breaking the dna strand into codons. To get unique set of codons, the start 
 * position can either be 0,1 or 2
 * * @author risshah
 *
 */

public class Codon {
	
	private HashMap<String, Integer> dna_map; //this map stores the details for the codons
	private static final int CODON_LENGTH = 3;
	
	public Codon(){
		dna_map = new HashMap<String, Integer>();
	}
	
	/**
	 * This method decomposes a dna_strand into individual codons. A hash map is populated with key as unique codons and value 
	 * as number of occurences of the codon
	 * @param dna_strand
	 * 						The dna strand to be decomposed
	 * @param start_position
	 * 						This sets up the reading frame
	 * 
	 */
	public void buildCodonMap(String dna_strand, int start_position){
		ArrayList<String> codon = new ArrayList<String>();
		
		//clear the map
		dna_map.clear();
		
		//create dna substring considering the start position
		String dna_substring = dna_strand.substring(start_position);
		
		//call the helper method that returns an arraylist of codons
		codon = stringlets(dna_substring, CODON_LENGTH);
		
		//Add codons to the map
		for (int i=0; i<codon.size();i++){
			if (!dna_map.containsKey(codon.get(i))){
				dna_map.put(codon.get(i), 1);
			} else {
				dna_map.put(codon.get(i), dna_map.get(codon.get(i))+1);
			}
		}
		
	}
	
	/**
	 * This is a private utility method. Takes a string and breaks it into chunks of specific length
	 * @param s
	 * 			The string that needs to be decomposed
	 * @param len
	 * 			Length of stringlets
	 * @return
	 * 			String array that holds the stringlets
	 */
	
	private ArrayList<String> stringlets(String s, int len){
		ArrayList<String> stringlets = new ArrayList<String>();
		int start_pos = 0;
		while ((start_pos+len)<=s.length()){
			String sub = s.substring(start_pos, start_pos+len);
			stringlets.add(sub);
			start_pos = start_pos+len;
		}
		return stringlets;
	}
	
    public void printCodonMap(){
    	for(String e: dna_map.keySet()){
    		System.out.println(e+"\t"+ dna_map.get(e));
    		
    	}
    }

}
