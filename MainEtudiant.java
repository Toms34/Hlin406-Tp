package etudiant;

public class MainEtudiant {

	public static void main(String[] args) {
		/*Etudiant(String nom, int anneeNaiss, CodePays codePays,
			        double note1, double note2, double note3)*/
		Etudiant e1 = new Etudiant("Marie", 1998, CodePays.etuFrançais,
			        14, 18, 16);
		System.out.println(e1);
		
		Etudiant e2 = new Etudiant("Jeanne", 1998, CodePays.etuFrançais,
		        14, 9, 16);
		System.out.println(e2);
		
		Etudiant e3 = new Etudiant("Sylvie", 1998, CodePays.etuFrançais,
		        7, 9, 10);
		System.out.println(e3);
		
		Etudiant e4 = new Etudiant("Esther", 1998, CodePays.etuFrançais,
		        7, 9, 5);
		System.out.println(e4);
		
		Etudiant e5 = new Etudiant("Astrid", 1998, CodePays.etuFrançais,
		        10, 10, 0);
		System.out.println(e5);	
	}

}
