package etudiant;
import java.util.ArrayList;
import java.util.List;

public class TestPromotion{
  public static void main(String[] argv){
    Promotion test =new Promotion(1);

    Etudiant e5 = new Etudiant("Astrid", 1998, CodePays.etuFrançais,10, 10, 0);
    
    Etudiant e2 = new Etudiant("Jeanne", 1998, CodePays.etuFrançais,
		        14, 9, 16);

    test.inscrire(e5);
    test.inscrire(e2); 

    System.out.println(test.GetAnnee());
    test.afficheResultats();
    System.out.println(test.moyenneGeneral());
    System.out.println(test.recherche("Jeanne").toString());
    List<Etudiant> retour=test.admis();
    for(int i=0; i<retour.size() ; i++){
      System.out.println(retour.get(i).toString());
    }
  }
}