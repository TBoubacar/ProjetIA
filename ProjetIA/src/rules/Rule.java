package rules;

import java.util.ArrayList;
import facts.Facts;
import utils.FactsData;

public class Rule {
	private String ruleNumber;
	private ArrayList<Condition> conditions;
	private Action action;
	public ArrayList<Boolean>  isconditionsverified;
	
	public Rule(String rule) {
		this.ruleNumber = rule;
		this.conditions = new ArrayList<Condition>();
		this.isconditionsverified = new ArrayList<Boolean>();	
		this.action=new Action("","");
	}
	
	public String toString() {
		return "Règle n°" + this.ruleNumber;
	}
	
	public void addCondition(Condition C) {
		conditions.add(C);
	}
	
	public void addaction (Action action) {
		this.action = action;
	}
	
	
	public void trouveCondition(FactsData data) {
		
			for(Condition condition : conditions) {
				for(Facts f :data.getArrayfacts())
			if((condition.name ==f.getEtiquette()) && (condition.value==f.getValeur())) {
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
