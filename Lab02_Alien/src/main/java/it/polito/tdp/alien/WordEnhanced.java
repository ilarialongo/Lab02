package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	private String alienWord;
	private List<String> traduzioni;
	
	public WordEnhanced(String alienWord, List<String> traduzioni) {
		super();
		this.alienWord = alienWord;
		this.traduzioni =new ArrayList<String>();
	}
	public String getAlienWord() {
		return alienWord;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	public List<String> getTraduzioni() {
		return traduzioni;
	}
	public void setTraduzioni(List<String> traduzioni) {
		this.traduzioni = traduzioni;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	public void addTraduzione(String traduzione) {
		traduzioni.add(traduzione);
	}
	
	

}
