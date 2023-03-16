package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.enums.Langues;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class JoueurDTO {

    private static int compteurJoueur = 0;
    private int idJoueur;
    private String nomJoueur;
    private Integer anneeNaissance;
    private String pseudo;
    private Langues langueFav;
    private String hobbies;
    private ArrayList<ScoreDTO> listeScores;

    public JoueurDTO (String nomJoueur, Integer anneeNaissance, String pseudo, Langues langueFav, String hobbies) {
        this.idJoueur = this.compteurJoueur;
        this.nomJoueur = nomJoueur;
        this.anneeNaissance = anneeNaissance;
        this.pseudo = pseudo;
        this.langueFav = langueFav;
        this.hobbies = hobbies;
        this.listeScores = new ArrayList<ScoreDTO>();
        compteurJoueur++;
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

    public Integer getAnneeNaissance () {
        return anneeNaissance;
    }

    public void setAnnéeNaissance (Integer anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public String getPseudo () {
        return pseudo;
    }

    public void setPseudo (String pseudo) {
        this.pseudo = pseudo;
    }

    public Langues getLangueFav () {
        return langueFav;
    }

    public void setLangueFav (Langues langueFav) {
        this.langueFav = langueFav;
    }

    public String getHobbies () {
        return hobbies;
    }

    public void setHobbies (String hobbies) {
        this.hobbies = hobbies;
    }

    public ArrayList<ScoreDTO> getListeScores() {
        return listeScores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoueurDTO joueurDTO = (JoueurDTO) o;
        return Objects.equals(pseudo, joueurDTO.pseudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pseudo);
    }

    @Override
    public String toString() {
        return "JoueurDTO{" +
                "idJoueur=" + idJoueur +
                ", nomJoueur='" + nomJoueur + '\'' +
                ", anneeNaissance=" + anneeNaissance +
                ", pseudo='" + pseudo + '\'' +
                ", langueFav='" + langueFav + '\'' +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }
}
