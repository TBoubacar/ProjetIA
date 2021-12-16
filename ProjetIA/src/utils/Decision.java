package utils;

import java.util.ListIterator;

import facts.Facts;
import rules.Condition;
import rules.Rule;

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
		int mult =0;
		int cpt=0;
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
							Facts f=new Facts(rule.getAction().getName(), rule.getAction().getValue());
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
			while(!factsData.isFactExist("visiter", "yes") && cpt<mult);
			
			for(Facts facts:factsData.getFaitsFiltrer()) {
				System.out.println(facts.getEtiquette()+":"+facts.getValeur());
			}
			
			
		}
		return factsData.isFactExist("visiter", "yes");
	
		
	}

}
