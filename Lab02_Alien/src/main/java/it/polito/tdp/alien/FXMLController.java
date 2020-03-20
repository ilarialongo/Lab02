package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private String parolaInserita;
	private String parolaAliena;
	private String traduzione;
	private AlienDictionary dizionario1;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtResult.clear();
    }
    
    @FXML
    public boolean check (String p) {
 		boolean flag=true;
 		for (int i=0; i<p.length();i++) {
 			if ((!Character.isLetter(p.charAt(i)) && (p.charAt(i)!=' '))) {
 				flag=false;
 			}
 		}
 		return flag;
 	}
   
    @FXML
    void doTranslate(ActionEvent event) {
    	this.parolaInserita=txtParola.getText().toLowerCase();
 
    	
    	if (parolaInserita.length()==0) {
    		txtResult.clear();
    		txtResult.setText("Inserire una parola \n");
    		txtParola.clear();
    		return ;
    	}
    	
    	if (this.check(parolaInserita)==false) {
    		txtResult.clear();
    		txtResult.setText("Inserire parola valida \n");
    		txtParola.clear();
    		return ;
    	} 
    	
    	/* if (parolaInserita.matches("[a-zA-Z]")==false && flag!=true ) {
    		txtResult.clear();
    		txtResult.appendText("Inserire parola valida \n");
    		txtParola.clear();
    		return ;
    	}*/
    	
    	 boolean flag=false;
    	for (int i=0; i<parolaInserita.length();i++) {
    		if (((parolaInserita.charAt(i))==' ') && (flag==false)) {
    			flag=true;
    		}
    	}
    	
    	if (flag==true) {
    	//StringTokenizer st= new StringTokenizer(parolaInserita, " ");
    	//st.countTokens() conto quanti token 
    	//parolaAliena= st.nextToken();
        //traduzione= st.nextToken();	
          
    		String[] s= parolaInserita.split(" ");
    		parolaAliena= s[0];
    		traduzione= s[1];	
    		if(s.length>2) {
    			txtResult.setText("Inserire al massimo due parole \n");
                txtParola.clear();
                return ;
    		}
            dizionario1.addWord(parolaAliena, traduzione);
            txtResult.setText("Parola aggiunta correttamente \n");
            txtParola.clear();
    	}
    else {
    		traduzione= dizionario1.translateWord(parolaInserita);
    		if (traduzione!=null) {
    		txtResult.setText(traduzione+"\n");
    		txtParola.clear();
    		}
    		else {
    			txtResult.setText("Parola non presente nel dizionario \n");
        		txtParola.clear();
    			
    		}
 
    }
    }

 

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        this.dizionario1= new AlienDictionary();

    }
}
