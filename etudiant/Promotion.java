package etudiant;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Promotion{
  private ArrayList <Etudiant> etudiants;
  private int annee;
  
  public Promotion(){
      this.etudiants = new ArrayList<Etudiant>();
  }

  public Promotion(int annee){
    this.SetAnnee(annee);
    this.etudiants = new ArrayList<Etudiant>();
  }

  public int GetAnnee(){
      return this.annee;
  }

  public void SetAnnee(int annee){
      this.annee = annee;
  }

  public int NbEtu(){
    return etudiants.size();
  }

  public List<Etudiant> getEtudiants(){
      return (List<Etudiant>)Collections.unmodifiableList(this.etudiants);
  }

  public void inscrire(Etudiant etu){ 
      if(!(this.etudiants.contains(etu))){
          this.etudiants.add(etu);
      }
  }
  public void afficheResultats(){
    for(int a=0 ; a<this.NbEtu() ; a++){
      System.out.println();
      System.out.println(this.etudiants.get(a).ligneResultats());
    }
    System.out.println();
  }

  public float moyenneGeneral(){
      if(this.NbEtu() == 0){
          return -1;
      }
      float somme=0;
      for(int i=0; i<this.NbEtu(); i++){
          somme += this.etudiants.get(i).moyenne();
      }
      return somme/this.NbEtu();
  }
  public Etudiant recherche(String etu){
    for(int i=0; i<this.NbEtu(); i++ ){
      if( this.etudiants.get(i).getNom().equals(etu) ){ //string1.equals(string2)
        return this.etudiants.get(i);
      }
    }
    return null;
  }
  public List<Etudiant> admis(){
    ArrayList <Etudiant> admis=new ArrayList<Etudiant>();
     for(int i=0; i<this.NbEtu(); i++){
       if(this.etudiants.get(i).moyenne()>=10){
         admis.add(this.etudiants.get(i));
       }
     }
     return admis;
  }
  public List<Etudiant> nouveauxInscritsNonFrancophones(){
    ArrayList <Etudiant> NonFr=new ArrayList<Etudiant>();
     for(int i=0; i<this.NbEtu(); i++){
       if(this.etudiants.get(i).getCodePays()==CodePays.etuEtrangerNonFrancophone){
         NonFr.add(this.etudiants.get(i));
       }
     }
     return NonFr;
  }

  public List<Etudiant> Major(){
    ArrayList <Etudiant> major=new ArrayList<Etudiant>();
    int max=0;
    for(Etudiant i: this.etudiants){
      if(i.moyenne()==max){
        major.add(i);
      }
      if(i.moyenne()>max){
        major.clear();
        major.add(i);
      } 
    }
    return major;
  }
}