package Test;
import java.util.ArrayList;
import java.util.ListIterator;

import Rules.Action;
import Rules.Condition;
import Rules.Rule;
import datas.FactsData;
import datas.RulesData;
import facts.Facts;

public class Decision {
	
	private RulesData rulesData;
	
	private FactsData factsData;
	
	public Decision() {
		
		rulesData =new RulesData();
		factsData = new FactsData();
		rulesData.generateRules();
		factsData.generateFacts();
	}
	
	public boolean make_decision(String destination,String budget) {
		int taille =rulesData.rules.size();
		int cpt=1;
		if(factsData.isDataexistsBaseFacts(destination, budget)) {
			do {
				
				ListIterator<Facts> factIterator = factsData.getArrayfacts().listIterator();
				while(factIterator.hasNext()) {
					Facts facts =factIterator.next();
					ListIterator<Rule> ruleIterator = rulesData.rules.listIterator();
					
					while(ruleIterator.hasNext()) {
						Rule rule = ruleIterator.next();
						
						ListIterator<Condition> conditionsIterator =rule.getConditions().listIterator();	
						while(conditionsIterator.hasNext()) {
							Condition condition = conditionsIterator.next();
							if(condition.getName()==facts.getEtiquette() && condition.getValue()==facts.getValeur()) {
								conditionsIterator.remove();
							}
							
						}
						
						
						if(rule.getConditions().size()==0) {
							Facts f=new Facts(rule.getAction().getName(), rule.getAction().getValue());
							if(!factsData.aDoublon(f.getEtiquette(), f.getValeur())) {
						factIterator.add(f);
						ruleIterator.remove();
						}
						}
						ruleIterator.nextIndex();
						
					}
					
					
				}
			
				for(Facts facts:factsData.getArrayfacts()) {
					System.out.println(facts.getEtiquette()+":"+facts.getValeur());
				}
				
				System.out.println("size"+ rulesData.rules.size());
				for(Rule rule :rulesData.rules) {
					System.out.println(rule.getRuleNumber());
				}
				System.out.println("cpt="+cpt+" taille="+taille);
				cpt++;
			}
			while(!factsData.isFactExist("visiter", "yes"));
			
		}
		return factsData.isFactExist("visiter", "yes");
	
		
	}
}

		
	
	
