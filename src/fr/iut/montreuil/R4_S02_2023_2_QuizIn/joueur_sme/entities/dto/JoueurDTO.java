package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto;

public class JoueurDTO {

    private int idJoueur;
    private String nomJoueur;
    private Integer annéeNaissance;
    private String pseudo;
    private String langueFav;
    private String hobbies;

    public JoueurDTO (int idJoueur, String nomJoueur, Integer annéeNaissance, String pseudo, String langueFav, String hobbies) {
        this.idJoueur = idJoueur;
        this.nomJoueur = nomJoueur;
        this.annéeNaissance = annéeNaissance;
        this.pseudo = pseudo;
        this.langueFav = langueFav;
        this.hobbies = hobbies;
    }

    public int getIdJoueur () {
        return idJoueur;
    }

    public void setIdJoueur (int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNomJoueur () {
        return nomJoueur;
    }

    public void setNomJoueur (String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public Integer getAnnéeNaissance () {
        return annéeNaissance;
    }

    public void setAnnéeNaissance (Integer annéeNaissance) {
        this.annéeNaissance = annéeNaissance;
    }

    public String getPseudo () {
        return pseudo;
    }

    public void setPseudo (String pseudo) {
        this.pseudo = pseudo;
    }

    public String getLangueFav () {
        return langueFav;
    }

    public void setLangueFav (String langueFav) {
        this.langueFav = langueFav;
    }

    public String getHobbies () {
        return hobbies;
    }

    public void setHobbies (String hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "JoueurDTO{" +
                "idJoueur=" + idJoueur +
                ", nomJoueur='" + nomJoueur + '\'' +
                ", annéeNaissance=" + annéeNaissance +
                ", pseudo='" + pseudo + '\'' +
                ", langueFav='" + langueFav + '\'' +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }
}
