package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.modeles;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;

import java.util.ArrayList;

public interface IServiceJoueur {

    public JoueurDTO ajouterJoueur(int idJoueur, String nomJoueur, Integer annéeNaissance, String pseudo, String langueFav, String hobbies);

    public JoueurDTO supprimerJoueur(String pseudo);

    public ArrayList<JoueurDTO> listerJoueur();

}
