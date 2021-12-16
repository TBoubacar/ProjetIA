package utils;

import java.util.ArrayList;

import but.But;

public class ButData {

	private ArrayList<But> buts;
	
	public ButData() {
		this.buts = new ArrayList<>();
	}
	
	public void addBut(But b) {
		this.buts.add(b);
	}
	
	public ArrayList<But> getButs() {
		return buts;
	}

	public void setButs(ArrayList<But> buts) {
		this.buts = buts;
	}

}
