package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.modeles.IServiceJoueur;

import java.util.ArrayList;

public class ServiceJoueurImpl implements IServiceJoueur {
    @Override
    public JoueurDTO ajouterJoueur(int idJoueur, String nomJoueur, Integer annéeNaissance, String pseudo, String langueFav, String hobbies) {
        return null;
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
