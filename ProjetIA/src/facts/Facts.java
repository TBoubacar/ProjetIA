package facts;

public class Facts {
	String etiquette;
	String valeur;
	
	public Facts(String etiquette,String valeur) {
		this.etiquette=etiquette;
		this.valeur = valeur;
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
		this.valeur = valeur;
	}

}
