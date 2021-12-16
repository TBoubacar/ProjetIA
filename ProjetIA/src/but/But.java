package but;

public class But {

	private String etiquette;
	private String valeur;
	
	public But(String etiq,String val) {
		this.etiquette = etiq;
		this.valeur= val;
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
