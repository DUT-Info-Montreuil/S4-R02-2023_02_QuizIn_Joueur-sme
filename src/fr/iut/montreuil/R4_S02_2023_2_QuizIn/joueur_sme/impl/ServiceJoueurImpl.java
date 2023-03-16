package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.ScoreDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.enums.Langues;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.exceptions.JoueurNonExistant;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.exceptions.PseudoJoueurDejaExistant;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.modeles.IServiceJoueur;

import java.util.ArrayList;
import java.util.Iterator;

public class ServiceJoueurImpl implements IServiceJoueur {

    private static ServiceJoueurImpl uniqueInstance = new ServiceJoueurImpl();
    private ArrayList <JoueurDTO> listJoueurs;

    public ServiceJoueurImpl() {
        this.listJoueurs = new ArrayList<JoueurDTO>();
    }

    public static ServiceJoueurImpl getInstance(){
        return uniqueInstance;
    }

    @Override
    public JoueurDTO ajouterJoueur (String nomJoueur, Integer annéeNaissance, String pseudo, Langues langueFav, String hobbies) throws PseudoJoueurDejaExistant {
        JoueurDTO joueurToAdd = new JoueurDTO(nomJoueur, annéeNaissance, pseudo, langueFav, hobbies);

        for (JoueurDTO joueurListe : this.listJoueurs) {
            if (joueurListe.equals(joueurToAdd)) {
                throw new PseudoJoueurDejaExistant();
            }
        }
        listJoueurs.add(joueurToAdd);
        return joueurToAdd;    }

    @Override
    public JoueurDTO supprimerJoueur(String pseudo) throws JoueurNonExistant {
        Iterator <JoueurDTO> itDeleteJoueur = listJoueurs.iterator();
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

    public ArrayList<JoueurDTO> getListJoueurs() {
        return listJoueurs;
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() {
        return getListJoueurs();
    }

    @Override
    public ScoreDTO gestionScoreJoueur(int points, long temps) {
        return null;
    }

    @Override
    public ArrayList<ScoreDTO> fournirStatsJoueur() {
        return null;
    }

    @Override
    public void fournirClassement() {

    }

    @Override
    public String transmettreInfoJoueur() {
        return null;
    }

}
