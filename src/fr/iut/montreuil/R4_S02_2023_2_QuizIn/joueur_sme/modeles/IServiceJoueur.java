package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.modeles;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.ScoreDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.enums.Langues;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.exceptions.JoueurNonExistant;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.exceptions.PseudoJoueurDejaExistant;

import java.util.ArrayList;

public interface IServiceJoueur {

    public JoueurDTO ajouterJoueur(String nomJoueur, Integer annéeNaissance, String pseudo, Langues langueFav, String hobbies) throws PseudoJoueurDejaExistant;

    public JoueurDTO supprimerJoueur(String pseudo) throws JoueurNonExistant;

    public ArrayList<JoueurDTO> listerJoueurs();

    public ScoreDTO gestionScoreJoueur(int points, long temps, JoueurDTO joueur);

    public ArrayList<ScoreDTO> fournirStatsJoueur(JoueurDTO joueur);

    public void fournirClassement();

    public String transmettreInfoJoueur(JoueurDTO joueur);

}
