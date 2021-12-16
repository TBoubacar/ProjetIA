package utils;

import java.util.ArrayList;
import java.util.ListIterator;

import but.But;
import facts.Facts;
import rules.Condition;
import rules.Rule;

public class Decision {
	private RulesData rulesData;
	private FactsData factsData;
	private ButData butsData;
	public ArrayList<Rule> ruletables;
	
	public Decision() {
		rulesData = new RulesData();
		factsData = new FactsData();	
		setButsData(new ButData());
		ruletables = new ArrayList<>();
	}
	
	public boolean make_decision(String destination,String budget) {
		int mult =0;
		int cpt=0;

		rulesData.generateRules();
		factsData.generateFacts();
		
		if(factsData.isDataexistsBaseFacts(destination, budget)) {
			do {
				mult = factsData.getFaitsFiltrer().size()*rulesData.rules.size();
				ListIterator<Facts> factIterator = factsData.getFaitsFiltrer().listIterator();
				while(factIterator.hasNext()) {
					Facts facts =factIterator.next();
					ListIterator<Rule> ruleIterator = rulesData.rules.listIterator();
					
					while(ruleIterator.hasNext()) {
						Rule rule = ruleIterator.next();
						
						ListIterator<Condition> conditionsIterator =rule.getConditions().listIterator();	
						while(conditionsIterator.hasNext()) {
							Condition condition = conditionsIterator.next();
							if(condition.getName().equals(facts.getEtiquette()) && condition.getValue().equals(facts.getValeur())) {
								conditionsIterator.remove();
							}
							
						}
						
						
						if(rule.getConditions().size()==0) {
							Facts f = new Facts(rule.getAction().getName(), rule.getAction().getValue());
							if(!factsData.aDoublon(f.getEtiquette(), f.getValeur())) {
								factIterator.add(f);
								factsData.getArrayfacts().add(f);
								ruleIterator.remove();
							}
						}
						
					}
					
					
				}
				
				
				cpt++;
			}
			while(!factsData.isFactExist("visiter", "yes") && cpt < mult);
			
			for(Facts facts:factsData.getFaitsFiltrer()) {
				Test.getjTextArea().setText(Test.getjTextArea().getText() + "\n \t# " + facts.getEtiquette() + " : " + facts.getValeur());
			}
			
			
		}
		return factsData.isFactExist("visiter", "yes");
	}
	
	/*----		CHAINAGE ARRIERE		---*/
	
	public ArrayList<Rule> chainageArriere(But b) {
		butsData.addBut(b);
		int cpt=0;
		do {
			ListIterator<But>butIterator = butsData.getButs().listIterator();
			
			while(butIterator.hasNext()) {
				But but = butIterator.next();
				
				ListIterator<Rule>ruleIterator = rulesData.rules.listIterator();
				while(ruleIterator.hasNext()) {
					Rule rule = ruleIterator.next();
					
					if(rule.getAction().getName().equals(but.getEtiquette()) && rule.getAction().getValue().equals(but.getValeur())) {
						this.ruletables.add(rule);
						ruleIterator.remove();
						for(Condition condition :rule.getConditions()) {
							butIterator.add(new But(condition.getName(), condition.getValue()));
						}
					}
					
				}
				
			}
			cpt++;
		} while(cpt < 10);
		return ruletables;
	}
	
	
	public void printRulesTable() {
		for(Rule rule : this.ruletables) {
			ListIterator<Condition>rulesconditionsIterator = rule.getConditions().listIterator();
			while(rulesconditionsIterator.hasNext()) {
				Condition condition = rulesconditionsIterator.next();
				if(!inBaseFacts(condition)) {
					System.out.println("condition " + condition.getName() + " " + condition.getValue());
				}
				else {
					System.out.println("fait " + condition.getName() + " " + condition.getValue());
				}
			}
		}
	}
	
	public boolean inBaseFacts(Condition condition) {
		ListIterator<Facts> factIterator = factsData.getArrayfacts().listIterator();
		while(factIterator.hasNext()) {
			Facts facts = factIterator.next();
			if(facts.getEtiquette() == condition.getName() && facts.getValeur() == condition.getValue()) {
				return true;
			}
		}
		return false;
	}

	
	public ButData getButsData() {
		return butsData;
	}

	public void setButsData(ButData butsData) {
		this.butsData = butsData;
	}

}
