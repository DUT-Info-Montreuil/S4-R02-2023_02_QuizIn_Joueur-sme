package test.fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl.Mock;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.modeles.IServiceJoueur;

import java.util.ArrayList;
import java.util.Collection;

public class ServiceJoueurMockOk implements IServiceJoueur {




    @Override
    public JoueurDTO ajouterJoueur(int idJoueur, String nomJoueur, Integer annéeNaissance, String pseudo, String langueFav, String hobbies) {
        JoueurDTO joueur = new JoueurDTO(idJoueur, nomJoueur , annéeNaissance, pseudo, langueFav, hobbies);
        return joueur;
    }

    @Override
    public JoueurDTO supprimerJoueur(String pseudo) {
        return null;
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() {
        return null;
    }
}
