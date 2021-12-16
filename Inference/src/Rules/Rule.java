package Rules;

import java.util.ArrayList;
import java.util.ListIterator;

import datas.FactsData;
import facts.Facts;

public class Rule {
	
	private String ruleNumber;
	private ArrayList<Condition> conditions;
	private Action action;
	public ArrayList<Boolean>  isconditionsverified;
	
	public Rule(String rule) {
		this.ruleNumber = rule;
		this.conditions = new ArrayList<Condition>();
		this.isconditionsverified = new ArrayList<>();	
		this.action=new Action("","");
	}
	
	
	public void addCondition(Condition C) {
		conditions.add(C);
	}
	
	public void addaction (Action action) {
		this.action =action;
	}
	
	
	public void trouveCondition(FactsData data) {
		
		
		
			for(Condition condition : conditions) {
				for(Facts f :data.getArrayfacts())
			if((condition.name ==f.getEtiquette()) && (condition.value==f.getValeur())) {
			
				System.out.println("toto");
				isconditionsverified.add(true);
				break;
			}
			
			
		}
		isconditionsverified.add(false);
		
	
	}
	public Action trouveAction() {
		if(isconditionsverified.size()!=conditions.size()) return null;
		else {
			for(boolean b :isconditionsverified) {
				if(b==false) {
					return null;
				}
			}
			return action;			
		}
	}


	public String getRuleNumber() {
		return ruleNumber;
	}


	public void setRuleNumber(String ruleNumber) {
		this.ruleNumber = ruleNumber;
	}


	public ArrayList<Condition> getConditions() {
		return conditions;
	}


	public void setConditions(ArrayList<Condition> conditions) {
		this.conditions = conditions;
	}


	public Action getAction() {
		return action;
	}


	public void setAction(Action action) {
		this.action = action;
	}


	public ArrayList<Boolean> getIsconditionsverified() {
		return isconditionsverified;
	}


	public void setIsconditionsverified(ArrayList<Boolean> isconditionsverified) {
		this.isconditionsverified = isconditionsverified;
	}
	
	
	

}
