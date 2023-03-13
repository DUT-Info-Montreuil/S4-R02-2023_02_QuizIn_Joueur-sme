package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.modeles.IServiceJoueur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class ServiceJoueurImpl implements IServiceJoueur {

    private ArrayList <JoueurDTO> listJoueurs;

    public ServiceJoueurImpl() {
        this.listJoueurs = new ArrayList<JoueurDTO>();
    }

    @Override
    public JoueurDTO ajouterJoueur(int idJoueur, String nomJoueur, Integer annéeNaissance, String pseudo, String langueFav, String hobbies){
        Iterator <JoueurDTO> itAddJoueur = listJoueurs.iterator();

        JoueurDTO joueurToAdd = new JoueurDTO(idJoueur, nomJoueur, annéeNaissance, pseudo, langueFav, hobbies);

        for (JoueurDTO joueurListe : this.listJoueurs) {
            if (joueurListe.equals(joueurToAdd)) {
                return null;
            }
        }

        listJoueurs.add(joueurToAdd);

        return joueurToAdd;
    }

    @Override
    public JoueurDTO supprimerJoueur(String pseudo) {
        Iterator <JoueurDTO> itDeleteJoueur = listJoueurs.iterator();
        JoueurDTO joueurToVerif = null;

        while (itDeleteJoueur.hasNext()){
            joueurToVerif = itDeleteJoueur.next();
            if (joueurToVerif.getPseudo().equals(pseudo)){
                itDeleteJoueur.remove();
            }
        }
        return joueurToVerif;
    }

    public ArrayList<JoueurDTO> getListJoueurs() {
        return listJoueurs;
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() {
        return getListJoueurs();
    }

}
