package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.modeles.IServiceJoueur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class ServiceJoueurImpl implements IServiceJoueur {

    private Collection <JoueurDTO> listJoueurs;

    public ServiceJoueurImpl() {
        this.listJoueurs = new TreeSet <JoueurDTO>() ;
    }

    @Override
    public JoueurDTO ajouterJoueur(int idJoueur, String nomJoueur, Integer annéeNaissance, String pseudo, String langueFav, String hobbies) throws Exception{
        Iterator <JoueurDTO> itAddJoueur = listJoueurs.iterator();

        while (itAddJoueur.hasNext()) {
            JoueurDTO joueurToVerif = itAddJoueur.next();
            if (joueurToVerif.getPseudo().equals(pseudo)) {
                throw (new Exception("Le pseudo est déjà utilisé par un joueur !" + "\n\n"));
            }
        }
        JoueurDTO joueurToAdd = new JoueurDTO(idJoueur, nomJoueur, annéeNaissance, pseudo, langueFav, hobbies);
        listJoueurs.add(joueurToAdd);
        
        return joueurToAdd;
    }

    @Override
    public JoueurDTO supprimerJoueur(String pseudo) {
        return null;
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueur() {
        return null;
    }
}
