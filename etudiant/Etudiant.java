package etudiant;

import java.time.LocalDate;
import java.time.Period;

public class Etudiant {
	
	/*
		- nom : String {readonly}
		- / age : int
		- annéeNaiss : int {readonly}
		- codePays : CodePays
		- note1 : float
		- note2 : float
		- note3 : float
	 */
	
	//private String prenom; // valeur par défaut sera null
	//private String prenom="inconnu"; // valeur par défaut sera ""
	// si ensuite on écrit prenom.charAt(0);
	// cela fonctionne si prenom a été initialisé
	// sinon erreur nullPointerException
	
	private final String nom; // mettre une valeur pour éviter que
	// la valeur par défaut (null) soit utilisée - si on la met ici
	// je ne peux plus la changer --> on ne met pas 
	// l'initialisation ici !!! mais dans les constructeurs
	
	// private int age; // solution 1 : on le stocke
	// solution 2 : je ferai une méthode
	
	private final int anneeNaiss;
	
	private CodePays codePays;
	
	private double note1, note2, note3;
	
	/*
	 * + <<Create>>  constEtudiant(in nom : String
	 *  in anneeNaiss : int, 
	 * 	in codePays : CodePays, 
	 *  in note1 : double, in note2 : double, in note3 : double)
	 *  par rapport au modèle :
	 *  - on a enlevé l'âge qui va être calculé
	 *  - on a ajouté le nom de l'étudiant
	 *  - float -> double
	 */
	
	public Etudiant() 
		{this.nom = "inconnu"; this.anneeNaiss=0;}
	
	public Etudiant(String nom, int anneeNaiss, CodePays codePays,
			        double note1, double note2, double note3) {
		// final veut dire en Java
		// "ne peut être initialisé qu'une fois"
		/* version initiale
		this.nom = nom;
		this.anneeNaiss = anneeNaiss;
		this.codePays=codePays;
		this.note1=note1;
		this.note2=note2;
		this.note3=note3;
		*/
		this.nom = nom;
		this.anneeNaiss = anneeNaiss; 
		// doit-on vérifier la valeur de anneeNaiss?
		// on décide que non : tout entier fonctionne
		this.setCodePays(codePays);
		this.setNote1(note1);
		this.setNote2(note2);
		this.setNote3(note3);
	}
	
	/*
	 + getNom() : string {readonly}
	 en java on ne traduit pas 'readonly'
	 (en C++ const)
	 */
	
	public String getNom() {
		return this.nom;
	}
	
	/* On ne l'écrit pas car nom est final
	 * je n'ai pas le droit de donner une 2e fois une valeur
	public void setNom(String nom) {
		this.nom=nom;
	}
	*/
	
	/*
	+ getAge() : int {readonly}
	+ NON : setAge(in age : int) : void
	si on avait choisi de stocker l'âge dans un attribut
	cette méthode setAge ne devrait pas exister
	car l'âge doit rester cohérent avec
	l'année de naissance qui est stocké par ailleurs
	*/
	
	public int getAge() {
		LocalDate today =  LocalDate.now();
		return today.getYear() - this.anneeNaiss;
	}
	
	/*
	+ getAnnéeNaiss() : int {readonly}
	+ NON : setAnnéeNaiss(in annéeNaiss: int) : void
	*/
	
	public int getAnneeNaiss() {
		return this.anneeNaiss;
	}
	
	/* impossible car anneeNaiss est final
	public void setAnneeNaiss(int a) {
		this.anneeNaiss=a;
	}
	*/
	
	/*
	+ getNote1() : float {readonly}
	+ setNote1(in note1: float) 
	+ getNote2() : float {readonly}
	+ setNote2(in note2: float) 
	+ getNote3() : float {readonly}
	+ setNote3(in note3: float) 
	*/
	
	public double getNote1() {
		return this.note1;
	}
	
	public void setNote1(double nouvelleNote) {
		// on suppose des notes entre 0 et 20
		if (nouvelleNote >=0 && nouvelleNote <=20)
			this.note1 = nouvelleNote;
		else
			System.out.println("pb note hors de l'intervalle [0,20]");
	}
	
	public double getNote2() {
		return this.note2;
	}
	
	public void setNote2(double nouvelleNote) {
		// on suppose des notes entre 0 et 20
		if (nouvelleNote >=0 && nouvelleNote <=20)
			this.note2 = nouvelleNote;
		else
			System.out.println("pb note hors de l'intervalle [0,20]");
	}
	
	public double getNote3() {
		return this.note3;
	}
	
	public void setNote3(double nouvelleNote) {
		// on suppose des notes entre 0 et 20
		if (nouvelleNote >=0 && nouvelleNote <=20)
			this.note3 = nouvelleNote;
		else
			System.out.println("pb note hors de l'intervalle [0,20]");
	}
	
	/*
	+ getCodePays() : CodePays {readonly}
	+ setCodePays(in cp: CodePays) 
	*/
	
	public CodePays getCodePays() {
		return this.codePays;
	}
	
	public void setCodePays(CodePays nouveauCode) {
		// rien à vérifier car l'énumération limite
		// naturellement les valeurs à un 
		// ensemble de valeurs cohérentes
		this.codePays=nouveauCode;
	}
	
	/*
		+ moyenne(): double
		+ mention() : Mention
		+ ligneResultats() : String
	 */
	
	public double moyenne() {
		return (this.note1+this.note2+this.note3)/3;
	}
	
	/*
	 * 
	Rattrapage : moyenne entre 0 et <10
	Passable : de 10 à <12
	Assez bien : de 12 à <14
	Bien : de 14 à <16
	Tresbien : de 16 à <18
	Excellent : de 18 à 20
	 */
	public Mention mention() {
		// Hyp = moyenne retourne une valeur entre 0 et 20
		double moy = this.moyenne();
		Mention mention = null;
		if (moy >= 0 && moy <10)
			mention = Mention.rattrapage;
		else // moy < 0 impossible ou moy >=10
			if (moy < 12)
				mention = Mention.passable;
			else //moy >=12
				if (moy < 14)
					mention = Mention.assezBien;
				else // moy >=14
					if (moy < 16)
						mention = Mention.bien;
					else // moy >=16
						if (moy < 18)
							mention = Mention.tresBien;
						else // moy >=18
							mention = Mention.excellent;
		return mention;
	}
	
	public String ligneResultats() {
		/*
		 * retourne nom, moyenne, mention 
		 * et si rattrapage, les modules obtenus 
		 * (module1, module2 ou module3)
		 */
		double moy = this.moyenne();
		String res = "Resultats de "+this.getNom()+
				" moyenne = "+moy+
				" mention = "+this.mention();
		if (moy < 10 ) // rattrapage
		{
			res = res + "\n modules obtenus : [ ";
			if (note1 >= 10)
				res = res + " module 1 ";
			if (note2 >= 10)
				res = res + " module 2 ";
			if (note3 >= 10)
				res = res + " module 3 ";
			res = res + " ]";
		}		
		return res;
	}
	
	public String toString() {
		return "Etudiant "+this.getNom()+
				"\n age "+this.getAge()+
				"\n code pays "+this.getCodePays()+
				"\n "+this.ligneResultats()+"\n";
	}
}
