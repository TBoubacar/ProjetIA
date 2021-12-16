package utils;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import but.But;
import rules.Rule;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Test extends JFrame implements Observable, Observer {
	private static final long serialVersionUID = 1L;
	private ArrayList<Observer> observers;
	private static JTextField jtextField;
	private static JTextArea jTextArea;
	private static JComboBox<String> jListVille;
	private static JComboBox<String> jListBudget;
	private static Decision decision;
	private FactsData factsData;
	
	/*____________________________________________________CONSTRUCTEUR__________________________________________________________*/
	public Test () {
		super ( "Système Expert" );
		this.pack();
		
		this.observers = new ArrayList<Observer>();
		this.observers.add(this);
		
		this.setLayout( new GridLayout(1,2));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize( 1200, 500);
		this.setLocationRelativeTo( null );
		
		decision = new Decision();
		
		jtextField = new JTextField();
		jtextField.setHorizontalAlignment(JTextField.CENTER); 
	    jtextField.setForeground( Color.WHITE);
		jtextField.setBackground( Color.RED);
		jtextField.setPreferredSize( new Dimension(145,45) );
		jtextField.setFont(new Font("Serif", Font.BOLD, 40));
		
		jTextArea = new JTextArea(20, 30);
		jTextArea.setText("\t LES DONNÉES DU SYSTÈME EXPERT :\n"
				+ "*******************************************\n"
				+ "On veut aider les touristes à trouver une très belle ville\n"
				+ "historique qu'ils pourront visiter sans avoir à trop dépenser \n"
				+ "durant leur séjour (Pas Cher).\n"
				+ "*******************************************\n");
		
		jTextArea.setPreferredSize( new Dimension(20,35) );
		jTextArea.setAlignmentX(CENTER_ALIGNMENT);
		jTextArea.setAlignmentY(CENTER_ALIGNMENT);
		jTextArea.setForeground(Color.WHITE);
		jTextArea.setBackground(Color.BLACK);
		jTextArea.setFont(new Font("Serif", Font.BOLD, 15));
		
		factsData = new FactsData();
		factsData.generateFacts();
		jListVille = new JComboBox<String>(factsData.getVilles());
		jListBudget = new JComboBox<String>(factsData.getBudget());
		jListVille.setBounds(241, 33, 150, 20);
		jListBudget.setBounds(241, 33, 150, 20);
		
		jListVille.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				notifyObserver();
			}
		});
		jListBudget.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				notifyObserver();
			}
		});
	}

	@Override
	public void update(String ville, String budget) {
		jTextArea.setText("\t LES DONNÉES DU SYSTÈME EXPERT :\n"
				+ "*******************************************\n"
				+ "On veut aider les touristes à trouver une très belle ville\n"
				+ "historique qu'ils pourront visiter sans avoir à trop dépenser \n"
				+ "durant leur séjour (Pas Cher).\n"
				+ "*******************************************\n");
		if(decision.make_decision(ville, budget)) {
			jtextField.setBackground( Color.GREEN );
			jtextField.setText(ville + " est Visitable");
		} else {
			jtextField.setBackground( Color.RED );
			jtextField.setText(ville + " n'est pas Visitable");
		}
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	public static JTextField getJtextField() {
		return jtextField;
	}

	public static void setJtextField(JTextField jtextField) {
		Test.jtextField = jtextField;
	}

	public static JTextArea getjTextArea() {
		return jTextArea;
	}

	public static void setjTextArea(JTextArea jTextArea) {
		Test.jTextArea = jTextArea;
	}

	public static JComboBox<String> getjListVille() {
		return jListVille;
	}

	public static void setjListVille(JComboBox<String> jListVille) {
		Test.jListVille = jListVille;
	}

	public static JComboBox<String> getjListBudget() {
		return jListBudget;
	}

	public static void setjListBudget(JComboBox<String> jListBudget) {
		Test.jListBudget = jListBudget;
	}

	public static Decision getDecision() {
		return decision;
	}

	public static void setDecision(Decision decision) {
		Test.decision = decision;
	}

	public FactsData getFactsData() {
		return factsData;
	}

	public void setFactsData(FactsData factsData) {
		this.factsData = factsData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void notifyObserver() {
		for(Observer o : this.observers)
			o.update((String)jListVille.getSelectedItem(),(String)jListBudget.getSelectedItem());		
	}

	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);		
	}

	/*____________________________________________________PROGRAMME PRINCIPAL__________________________________________________________*/
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		Test test = new Test();
		/*------------------------TEST POUR LE CHAINAGE AVANT------------------------*/
		System.out.println("------------------------TEST POUR LE CHAINAGE AVANT------------------------\n"
				+ "\t**************VOIR SUR L'INTERFACE GRAPHIQUE**************\n"
				+ "\t \t \t \t(^_^)");
		JPanel jPanelQuestion = new JPanel(new GridLayout(2,1));
		JPanel jPanelQ1 = new JPanel(new GridLayout(2,1));
		JPanel jPanelQ2 = new JPanel(new GridLayout(2,1));
		
		JLabel jLabelQ1 = new JLabel("Veuillez choisir la ville à visiter : ", JLabel.CENTER);
		JLabel jLabelQ2 = new JLabel("Quel est votre budjet (en Euros) : ", JLabel.CENTER);

		jLabelQ1.setFont(new Font("Serif", Font.BOLD, 20));
		jLabelQ2.setFont(new Font("Serif", Font.BOLD, 20));
		
		jPanelQ1.add(jLabelQ1);
		jPanelQ1.add(jListVille);
		
		jPanelQ2.add(jLabelQ2);
		jPanelQ2.add(jListBudget);
		
		jPanelQuestion.add(jPanelQ1);
		jPanelQuestion.add(jPanelQ2);
		
		jtextField.setText("Visitable : " + decision.make_decision((String)jListVille.getSelectedItem(),(String)jListBudget.getSelectedItem()));
		JScrollPane jScrollPane = new JScrollPane(jTextArea);
		JPanel panelText = new JPanel(new GridLayout(2,1));
		
		panelText.add(jtextField);
		panelText.add(jScrollPane);

		test.add(jPanelQuestion);
		test.add(panelText);
		UIManager.setLookAndFeel( new NimbusLookAndFeel() );
		test.setVisible( true );
		
		/*------------------------TEST POUR LE CHAINAGE ARRIÈRE------------------------*/
		System.out.println("\n------------------------TEST POUR LE CHAINAGE ARRIÈRE------------------------\n"
				+ "\t********ENSEMBLE DES REGLES ET CONDITIONS LUS POUR OBTENIR UN RESULTAT********\n"
				+ "# Règles : ");
		
		for(Rule r : decision.chainageArriere(new But("visiter","yes"))) {
			System.out.println(r);
		}
		System.out.println("# Conditions : ");
		decision.printRulesTable();
		System.out.println("\n\n_____________________FIN DE NOTRE ALGO DE SYSTÈME EXPERT_____________________\n"
				+ "DÉVELOPPEUR : SYLLA Mohamed ET TOURE Boubacar\n"
				+ "UNIVERSITÉ DE SCIENCE D'ANGERS (INFORMATIQUE)\n"
				+ "DATE : 16/12/2021 À 07 H 58 MIN\n"
				+ "MATIÈRE : INTELLIGENCE ARTIFICIELLE\n"
				+ "\t PROJET DISPONIBLE SUR NOTRE COMPTE GITHUB.\n");
	}
	
	

}
