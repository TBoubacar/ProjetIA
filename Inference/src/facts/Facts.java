package facts;

public class Facts {
	String etiquette;
	String valeur;
	int valInt;
	public Facts(String etiquette,String valeur) {
		
		this.etiquette=etiquette;
	this.valeur = valeur;
	}
	
	public Facts(String etiquette,int val) {
	this.etiquette = etiquette;
	this.valInt =val;
	}

	public String getEtiquette() {
		return etiquette;
	}

	public void setEtiquette(String etiquette) {
		this.etiquette = etiquette;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		valeur = valeur;
	}
	

}
