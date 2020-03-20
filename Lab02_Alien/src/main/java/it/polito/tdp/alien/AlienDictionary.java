package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	List <Word> dizionario;
	
	
	public AlienDictionary() {
		this.dizionario = new ArrayList <Word>();
	}
	
		
	public void addWord (String alienWord, String translation) {
		Word pTemp= new Word (alienWord, translation);
	/*	if (dizionario.isEmpty()==true) {
		dizionario.add(pTemp);
	}
		for (Word parola: this.dizionario) {
			if(parola!=null) {
		if (parola.getAlienWord().compareTo(pTemp.getAlienWord())==0) {
			parola.setTranslation(translation);
		}	
			}*/
		int posizione= this.dizionario.indexOf(pTemp);
			if (posizione !=-1) {
				this.dizionario.get(posizione).setTranslation(translation);
			}
			else {
		dizionario.add(pTemp);
			}
	}
	
	public String translateWord(String alienWord) {
		/*for (Word parola: dizionario) {
			if (parola!=null) {
			if (parola.getAlienWord().compareTo(alienWord)==0) {
				return parola.getTranslation();	
			}	
			}
			}
		return null; */
		int posizione= this.dizionario.indexOf(new Word (alienWord, ""));
		if (posizione !=-1) {
			return this.dizionario.get(posizione).getTranslation();
		}
			return null;
		
	}

	public List<Word> getDizionario() {
		return dizionario;
	}
}
