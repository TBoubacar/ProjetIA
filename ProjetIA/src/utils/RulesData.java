package utils;

import java.util.ArrayList;

import but.But;
import rules.Action;
import rules.Condition;
import rules.Rule;

public class RulesData {
	public ArrayList<Rule> rules;
	public ArrayList<But> buts;
	
	public RulesData() {
		this.rules = new ArrayList<Rule>();
		this.buts = new ArrayList<But>();
	}
	
	public ArrayList<Rule> generateRules() {
		rules.clear();
		
		//condition acceptante
		
		Rule rule0 = new Rule("0");
		rule0.addCondition(new Condition("belle ville","yes"));
		rule0.addCondition(new Condition("ville historique","yes"));
		rule0.addCondition(new Condition("pas cher", "yes"));
		rule0.addaction(new Action("visiter", "yes"));
		rules.add(rule0);
		
		// règle sur  la ville 
		
		Rule rule1 = new Rule("1");
		rule1.addCondition(new Condition("valeur saisie","0-500"));
		rule1.addaction(new Action("budget", "petit"));
		rules.add(rule1);
		buts.add(new But("budget", "petit"));
		
		
		Rule rule1_1 = new Rule("1_1");
		rule1_1.addCondition(new Condition("valeur saisie","500-1000"));
		rule1_1.addaction(new Action("budget", "moyen"));
		rules.add(rule1_1);
		
		
		Rule rule1_2 = new Rule("1_2");
		rule1_2.addCondition(new Condition("valeur saisie","plus de 1000"));
		rule1_2.addaction(new Action("budget", "grand"));
		rules.add(rule1_2);
		buts.add(new But("ville", "yes"));
		
		Rule rule2 = new Rule("2");
		rule2.addCondition(new Condition("destination","Angers"));
		rule2.addaction(new Action("ville", "yes"));
		rules.add(rule2);
		buts.add(new But("ville", "yes"));
		
		Rule rule3 = new Rule("3");
		rule3.addCondition(new Condition("destination","Nantes"));
		rule3.addaction(new Action("ville", "yes"));
		rules.add(rule3);
		
		Rule rule4 = new Rule("4");
		rule4.addCondition(new Condition("destination","Bordeaux"));
		rule4.addaction(new Action("ville", "yes"));
		rules.add(rule4);
		buts.add(new But("ville", "yes"));
		
		Rule rule5= new Rule("5");
		rule5.addCondition(new Condition("destination","Paris"));
		rule5.addaction(new Action("ville", "yes"));
		rules.add(rule5);
		
		
		Rule rule6 = new Rule("6");
		rule6.addCondition(new Condition("destination", "Angers"));
		rule6.addaction(new Action("taille", "petite"));
		rules.add(rule6);
		buts.add(new But("taille", "petite"));
		
		Rule rule7 = new Rule("7");
		rule7.addCondition(new Condition("destination", "Nantes"));
		rule7.addaction(new Action("taille", "moyenne"));
		rules.add(rule7);
		buts.add(new But("taille", "moyenne"));
		
		Rule rule8 = new Rule("8");
		rule8.addCondition(new Condition("destination", "Bordeaux"));
		rule8.addaction(new Action("taille", "grande"));
		rules.add(rule8);
		buts.add(new But("taille", "grande"));
		
		Rule rule9 = new Rule("9");
		rule9.addCondition(new Condition("destination", "Paris"));
		rule9.addaction(new Action("taille", "grande"));
		rules.add(rule9);
		
		//règle sur la chereté de la ville
		
		
		Rule rule10 = new Rule("10");
		rule10.addCondition(new Condition("taille", "petite"));
		rule10.addCondition(new Condition("budget", "petit"));
		rule10.addaction(new Action("moyennement cher", "yes"));
		rules.add(rule10);
		buts.add(new But("moyennement cher", "yes"));

		Rule rule10_1 = new Rule("10_1");
		rule10_1.addCondition(new Condition("taille", "moyenne"));
		rule10_1.addCondition(new Condition("budget", "moyen"));
		rule10_1.addaction(new Action("moyennement cher", "yes"));
		rules.add(rule10_1);
		
		Rule rule13 = new Rule("13");
		rule13.addCondition(new Condition("taille", "grande"));
		rule13.addCondition(new Condition("budget", "grand"));
		rule13.addaction(new Action("moyennement cher", "yes"));
		rules.add(rule13);
		
		Rule rule11 = new Rule("11");
		rule11.addCondition(new Condition("taille", "petite"));
		rule11.addCondition(new Condition("budget", "moyen"));
		rule11.addaction(new Action("pas cher", "yes"));
		rules.add(rule11);
		buts.add(new But("pas cher", "yes"));
		
		Rule rule12 = new Rule("12");
		rule12.addCondition(new Condition("taille", "petite"));
		rule12.addCondition(new Condition("budget", "grand"));
		rule12.addaction(new Action("pas cher", "yes"));
			rules.add(rule12);
		Rule rule12_1 = new Rule("12_1");
		rule12_1.addCondition(new Condition("taille", "moyenne"));
		rule12_1.addCondition(new Condition("budget", "petit"));
		rule12_1.addaction(new Action("tres cher", "yes"));
		rules.add(rule12_1);
		buts.add(new But("tres cher", "yes"));
		
		Rule rule12_2 = new Rule("12_2");
		rule12_2.addCondition(new Condition("taille", "moyenne"));
		rule12_2.addCondition(new Condition("budget", "grand"));
		rule12_2.addaction(new Action("pas cher", "yes"));		
		rules.add(rule12_2);
		
		Rule rule13_1 = new Rule("13_1");
		rule13_1.addCondition(new Condition("taille", "grande"));
		rule13_1.addCondition(new Condition("budget", "petit"));
		rule13_1.addaction(new Action("tres cher", "yes"));
		rules.add(rule13_1);

		Rule rule13_2 = new Rule("13_2");
		rule13_2.addCondition(new Condition("taille", "grande"));
		rule13_2.addCondition(new Condition("budget", "moyen"));
		rule13_2.addaction(new Action("tres cher", "yes"));
		rules.add(rule13_2);
		
		Rule rule14 = new Rule("14");
		rule14.addCondition(new Condition("taille", "grande"));
		rule14.addCondition(new Condition("budget", "petit"));
		rule14.addaction(new Action("tres cher", "yes"));
		rules.add(rule14);
		
		Rule rule14_1 = new Rule("14_1");
		rule14_1.addCondition(new Condition("taille", "grande"));
		rule14_1.addCondition(new Condition("budget", "grand"));
		rule14_1.addaction(new Action("pas cher", "yes"));
		rules.add(rule14);
		
		//règle sur  les batiments historiques
		
		Rule rule15 = new Rule("15");
		rule15.addCondition(new Condition("destination", "Angers"));
		rule15.addaction(new Action("monument", "chateau d'angers"));
		rules.add(rule15);
		buts.add(new But("monument", "chateau d'angers"));
		
		Rule rule15_1 = new Rule("15_1");
		rule15_1.addCondition(new Condition("destination", "Angers"));
		rule15_1.addaction(new Action("monument", "terrabotanica"));
		rules.add(rule15_1);
		buts.add(new But("monument", "terrabotanica"));
		
		Rule rule16 = new Rule("16");
		rule16.addCondition(new Condition("destination", "Paris"));
		rule16.addaction(new Action("monument", "tour eiffel"));
		rules.add(rule16);
		buts.add(new But("monument", "tour eiffel"));
		
		Rule rule17 = new Rule("17");
		rule17.addCondition(new Condition("", "Paris"));
		rule17.addaction(new Action("monument", "Louvre"));
		rules.add(rule17);
		buts.add(new But("monument", "louvre"));
		
		Rule rule18 = new Rule("18");
		rule18.addCondition(new Condition("destination", "Nantes"));
		rule18.addaction(new Action("monument", "chateau des ducs de bretagne"));
		rules.add(rule18);
		buts.add(new But("monument", "chateau des ducs de bretagne"));
		
		//règle sur les batiments historiques
		
		Rule rule19 = new Rule("19");
		rule19.addCondition(new Condition("monument", "louvre"));
		rule19.addaction(new Action("batiment historique", "yes"));
		rules.add(rule19);
		buts.add(new But("batiment historique", "yes"));
		
		Rule rule21= new Rule("21");
		rule21.addCondition(new Condition("monument", "chateau d'angers"));
		rule21.addaction(new Action("batiment historique", "yes"));
		rules.add(rule21);
		
		Rule rule20= new Rule("20");
		rule20.addCondition(new Condition("monument", "tour eiffel"));
		rule20.addaction(new Action("belle ville", "yes"));
		rules.add(rule20);
		buts.add(new But("belle ville", "yes"));
		
		Rule rule20_1= new Rule("20_1");
		rule20_1.addCondition(new Condition("monument", "terrabotanica"));
		rule20_1.addaction(new Action("belle ville", "yes"));
		rules.add(rule20_1);
		
		Rule rule22= new Rule("22");
		rule22.addCondition(new Condition("batiment historique", "yes"));
		rule22.addaction(new Action("ville historique", "yes"));
		rules.add(rule22);
		buts.add(new But("ville historique", "yes"));
		
				
		return rules;
	}
}
