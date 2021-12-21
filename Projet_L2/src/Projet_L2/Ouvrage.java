package Projet_L2;

public class Ouvrage {

    private String titre;
    private String prenom;
    private String nom;
    private int nbrMots;


    public Ouvrage(String titre, String prenom, String nom, int nbrMots) {

    	this.titre= titre;
        this.prenom = prenom;
        this.nom = nom;
        this.nbrMots = nbrMots;
       
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setFirstName(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   public int getNbrMots() {
	   return nbrMots;
   }
   
   public void setNbrMots(int nbrMots) {
       this.nbrMots = nbrMots;
   }

}

