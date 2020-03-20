package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	List <WordEnhanced> dizionario;
	
	
	public AlienDictionary() {
		this.dizionario = new ArrayList <WordEnhanced>();
	}
	
		
	public void addWord (String alienWord, String translation) {
		//WordEnhanced pTemp= new WordEnhanced (alienWord, translation);
		/*List <String> lTemp= new ArrayList<>();
		lTemp.add(translation);
		WordEnhanced pTemp=new WordEnhanced(alienWord,lTemp);
		if (dizionario.isEmpty()==true) {
		dizionario.add(pTemp);
	}
		for (WordEnhanced parola: this.dizionario) {
			if(parola!=null) {
		if (parola.getAlienWord().compareTo(alienWord)==0) {
			parola.addTraduzione(translation);;
		}	
			}
		}
		dizionario.add(pTemp);*/
		
		
		
		int posizione= this.dizionario.indexOf(new WordEnhanced(alienWord,null));
			if (posizione !=-1) {
				WordEnhanced pTemp=this.dizionario.get(posizione);
				
				for (String sTemp: pTemp.getTraduzioni()) {
					if(sTemp.compareTo(translation)==0) {
						return;
					}
				}
				this.dizionario.get(posizione).addTraduzione(translation);
			}
			else {
		
		WordEnhanced pTemp= new WordEnhanced(alienWord,null);
		pTemp.addTraduzione(translation);
		dizionario.add(pTemp);
			}
	}
	
	public String translateWord(String alienWord) {
		/*List <WordEnhanced> lTemp=new ArrayList<>();
		
		for (WordEnhanced parola: dizionario) {
			if (parola!=null) {
			if (parola.getAlienWord().compareTo(alienWord)==0) {
				lTemp.add(parola);		
			}	
			}
			}
		return null; */
		
		
		
		String testo="";
		int posizione= this.dizionario.indexOf(new WordEnhanced (alienWord, null));
		if (posizione !=-1) {
		 List <String> lTemp= this.dizionario.get(posizione).getTraduzioni();
		 for(String s: lTemp) {
			 if(testo=="") {
 				testo=s;
 				}
 				else {
 					testo+="\n"+s;
 				}
		 }
		 return testo;
		}
			return null;
		
	}

	public List<WordEnhanced> getDizionario() {
		return dizionario;
	}
}
