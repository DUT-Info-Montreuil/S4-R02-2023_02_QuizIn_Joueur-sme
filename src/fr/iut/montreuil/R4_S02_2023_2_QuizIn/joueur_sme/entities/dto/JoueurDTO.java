package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto;

import java.util.Objects;

public class JoueurDTO {

    private int idJoueur;
    private String nomJoueur;
    private Integer anneeNaissance;
    private String pseudo;
    private String langueFav;
    private String hobbies;

    public JoueurDTO (int idJoueur, String nomJoueur, Integer anneeNaissance, String pseudo, String langueFav, String hobbies) {
        this.idJoueur = idJoueur;
        this.nomJoueur = nomJoueur;
        this.anneeNaissance = anneeNaissance;
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
