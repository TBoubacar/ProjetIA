package utils;

public interface Observable {
	public void notifyObserver();
	public void addObserver(Observer observer);
	public void removeObserver(Observer observer);
}
