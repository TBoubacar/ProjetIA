package utils;

import java.util.ArrayList;
import java.util.ListIterator;

import facts.Facts;

public class FactsData {

	private ArrayList<Facts> arrayfacts;
	private ArrayList<Facts> faitsFiltrer;
	
	public FactsData() {
		arrayfacts = new ArrayList<>();
		faitsFiltrer = new ArrayList<>();
	}

	public  ArrayList<Facts> generateFacts() {
		arrayfacts.clear();
		faitsFiltrer.clear();
		
		arrayfacts.add(new Facts("destination", "Angers"));
		arrayfacts.add(new Facts("destination","Nantes"));
		arrayfacts.add(new Facts("destination","Orleans"));
		arrayfacts.add(new Facts("destination","Paris"));
		
		
		
		arrayfacts.add(new Facts("valeur saisie","0-500"));
		arrayfacts.add(new Facts("valeur saisie","500-1000"));
		arrayfacts.add(new Facts("valeur saisie","plus de 1000"));

		return this.arrayfacts;
		
	}
	
	public int getNumberOfCountry() {
		int nb = 0;
		for(Facts v : arrayfacts) {
			if(v.getEtiquette().equals("destination")) {
				nb++;
			}
		} return nb;
	}
	
	public int getNumberOfBudget() {
		int nb = 0;
		for(Facts v : arrayfacts) {
			if(v.getEtiquette().equals("valeur saisie")) {
				nb++;
			}
		} return nb;
	}
	
	public String[] getVilles() {
		String[] villes = new String[this.getNumberOfCountry()];
		int i = 0;
		for(Facts v : arrayfacts) {
			if(v.getEtiquette().equals("destination")) {
				villes[i++] = v.getValeur();
			}
		}
		return villes;
	}
	
	public String[] getBudget() {
		String[] budget = new String[this.getNumberOfBudget()];
		int i = 0;
		for(Facts v : arrayfacts) {
			if(v.getEtiquette().equals("valeur saisie")) {
				budget[i++] = v.getValeur();
			}
		}
		return budget;
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
		if(trouver1 == trouver2 && trouver1 == true) {
			faitsFiltrer.add(new Facts("destination", ville_saisie));
			faitsFiltrer.add(new Facts("valeur saisie", budget_saisie));
			return true;
		}
		return false;
	}

	public ArrayList<Facts> getArrayfacts() {
		return arrayfacts;
	}

	public void setArrayfacts(ArrayList<Facts> arrayfacts) {
		this.arrayfacts = arrayfacts;
	}
	
	
	public boolean aDoublon(String a,String b) {
		for(Facts facts :faitsFiltrer) {
			if(facts.getEtiquette().equals(a) && facts.getValeur().equals(b)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Facts> getFaitsFiltrer() {
		return faitsFiltrer;
	}

	public void setFaitsFiltrer(ArrayList<Facts> faitsFiltrer) {
		this.faitsFiltrer = faitsFiltrer;
	}
	
}
