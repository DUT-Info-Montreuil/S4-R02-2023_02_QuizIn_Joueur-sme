package test.fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl.Mock;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.ScoreDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.enums.Langues;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.exceptions.PseudoJoueurDejaExistant;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.modeles.IServiceJoueur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ServiceJoueurMockOk implements IServiceJoueur {

    private ArrayList<JoueurDTO> listJoueurs = new ArrayList<JoueurDTO>();


    @Override
    public JoueurDTO ajouterJoueur(String nomJoueur, Integer annéeNaissance, String pseudo, Langues langueFav, String hobbies) throws PseudoJoueurDejaExistant {
        JoueurDTO joueur = new JoueurDTO(nomJoueur , annéeNaissance, pseudo, langueFav, hobbies);
        this.listJoueurs.add(joueur);
        return joueur;
    }

    @Override
    public JoueurDTO supprimerJoueur(String pseudo) {

        Iterator<JoueurDTO> itDeleteJoueur = listJoueurs.iterator();
        JoueurDTO joueurToVerif = null;

        while (itDeleteJoueur.hasNext()){
            joueurToVerif = itDeleteJoueur.next();
            if (joueurToVerif.getPseudo().equals(pseudo)){
                itDeleteJoueur.remove();
                return joueurToVerif;
            }
        }
        return null;
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() {
        return listJoueurs;
    }

    @Override
    public ScoreDTO gestionScoreJoueur(int points, long temps, JoueurDTO joueur) {
        return null;
    }

    @Override
    public ArrayList<ScoreDTO> fournirStatsJoueur(JoueurDTO joueur) {
        return null;
    }

    @Override
    public void fournirClassement() {

    }

    @Override
    public String transmettreInfoJoueur(JoueurDTO joueur) {
        return null;
    }
}
