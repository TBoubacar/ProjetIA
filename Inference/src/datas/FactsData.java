package datas;

import java.util.ArrayList;
import java.util.ListIterator;

import Rules.Action;
import facts.Facts;

public class FactsData {
	
	
	private ArrayList<Facts> arrayfacts = new ArrayList<>();
	
	public FactsData() {
		arrayfacts = new ArrayList<>();
	}

	public  ArrayList<Facts> generateFacts() {
	
		
		arrayfacts.add(new Facts("destination", "Angers"));
		arrayfacts.add(new Facts("destination","Nantes"));
		arrayfacts.add(new Facts("destination","Orleans"));
		arrayfacts.add(new Facts("destination","Paris"));
		
		
		
		arrayfacts.add(new Facts("valeur saisie","0-500"));
		arrayfacts.add(new Facts("valeur saisie","500-1000"));
		arrayfacts.add(new Facts("valeur saisie","plus de 1000"));

		return this.arrayfacts;
		
	}
	
	public boolean isFactExist(String etiquette,String valeur) {
		
		ListIterator<Facts> factIterator = arrayfacts.listIterator();
		while(factIterator.hasNext()) {
			Facts facts = factIterator.next();
			if(facts.getEtiquette().equals(etiquette) && facts.getValeur().equals(valeur)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean isDataexistsBaseFacts(String ville_saisie,String budget_saisie) {
		ListIterator<Facts> factIterator = arrayfacts.listIterator();
		Boolean trouver1 = false;
		Boolean trouver2 = false;
		
		while(factIterator.hasNext()) {
			
			Facts facts = factIterator.next();
			if((facts.getEtiquette().equals("destination") && facts.getValeur().equals(ville_saisie))) {
				trouver1=true;
			}
			if((facts.getEtiquette().equals("valeur saisie") && facts.getValeur().equals(budget_saisie))) {
				trouver2=true;
			}
		}
		return trouver1 == trouver2 && trouver1 == true;
	}

	public ArrayList<Facts> getArrayfacts() {
		return arrayfacts;
	}

	public void setArrayfacts(ArrayList<Facts> arrayfacts) {
		this.arrayfacts = arrayfacts;
	}
	
	
	public boolean aDoublon(String a,String b) {
		for(Facts facts :arrayfacts) {
			if(facts.getEtiquette().equals(a) && facts.getValeur().equals(b)) {
				return true;
			}
		}
		return false;
	}
}
