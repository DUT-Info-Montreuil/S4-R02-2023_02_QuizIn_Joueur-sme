package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto;

public class JoueurDTO {

    private int idJoueur;
    private String nomJoueur;
    private String pseudo;
    private int score;

    public JoueurDTO (int idJoueur, String nomJoueur, String pseudo, int score) {
        this.idJoueur = idJoueur;
        this.nomJoueur = nomJoueur;
        this.pseudo = pseudo;
        this.score = score;
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

    public String getPseudo () {
        return pseudo;
    }

    public void setPseudo (String pseudo) {
        this.pseudo = pseudo;
    }

    public int getScore () {
        return score;
    }

    public void setScore (int score) {
        this.score = score;
    }
}
