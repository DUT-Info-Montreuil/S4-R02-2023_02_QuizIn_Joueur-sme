package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.modeles;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.exceptions.PseudoJoueurDejaExistant;

import java.util.ArrayList;
import java.util.Collection;

public interface IServiceJoueur {

    public JoueurDTO ajouterJoueur(int idJoueur, String nomJoueur, Integer annéeNaissance, String pseudo, String langueFav, String hobbies) throws PseudoJoueurDejaExistant;

    public JoueurDTO supprimerJoueur(String pseudo);

    public ArrayList<JoueurDTO> listerJoueurs();

}
