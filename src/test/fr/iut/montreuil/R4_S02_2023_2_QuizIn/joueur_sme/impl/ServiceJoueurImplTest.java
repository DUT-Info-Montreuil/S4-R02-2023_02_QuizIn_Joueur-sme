package test.fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl.ServiceJoueurImpl;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.modeles.IServiceJoueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import test.fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl.Mock.ServiceJoueurMockKo;
import test.fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl.Mock.ServiceJoueurMockOk;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class ServiceJoueurImplTest {

    ServiceJoueurMockOk serviceJoueurMockOk;
    ServiceJoueurMockKo serviceJoueurMockKo;
    private JoueurDTO j1 = new JoueurDTO(1,"Dio", 1866, "DIO", "francais", "rugby");
    private IServiceJoueur sji;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        this.serviceJoueurMockOk = new ServiceJoueurMockOk();
        this.serviceJoueurMockKo = new ServiceJoueurMockKo();

        this.serviceJoueurMockOk.ajouterJoueur(1,"Dio", 1866, "DIO", "francais", "rugby");

        this.sji = new ServiceJoueurImpl();
        this.sji.ajouterJoueur(1,"Jonathan", 1866, "JoJo", "francais", "rugby");

        System.out.println("test " + testInfo.getDisplayName());
    }

    @org.junit.jupiter.api.Test
    void ajouterJoueur() {

        assertEquals(this.j1, this.serviceJoueurMockOk.ajouterJoueur(1,"Dio", 1866, "DIO", "francais", "rugby"));

        assertNotEquals(this.j1, this.serviceJoueurMockOk.ajouterJoueur(2,"Dio", 1866, "dio", "francais", "rugby"), "Cas pseudo ressemblant : joueur créé");

        assertEquals(this.j1, this.serviceJoueurMockOk.ajouterJoueur(3,"Diego", 1870, "DIO", "francais", "cheval, course"), "Cas pseudo déjà existant : joueur pas créé");

    }

    @org.junit.jupiter.api.Test
    void ajouterJoueurMethode() {

        assertEquals(this.j1, sji.ajouterJoueur(1,"Dio", 1866, "DIO", "francais", "rugby"), "cas joueur valide : créé");

        assertEquals(null, sji.ajouterJoueur(1,"Jonathan", 1866, "JoJo", "francais", "rugby"), "cas joueur identique : pas créé");

        assertEquals(new JoueurDTO(4,"Joseph", 1920, "Jojo", "francais", "aucun"), sji.ajouterJoueur(4,"Joseph", 1920, "Jojo", "francais", "aucun"), "cas joueur ressemblant : créé");

    }

    @org.junit.jupiter.api.Test
    void supprimerJoueur() {

        //assertEquals(this.j1,this.serviceJoueurMockOk.supprimerJoueur(j1.getPseudo()), "cas joueur supprimé");

        assertEquals(null,this.serviceJoueurMockOk.supprimerJoueur("Naoufel"), "cas joueur inexistant");

        assertEquals(null,this.serviceJoueurMockOk.supprimerJoueur("Dio"), "cas pseudo mal ecrit");

    }

    @org.junit.jupiter.api.Test
    void supprimerJoueurMethode() {

        this.sji.ajouterJoueur(j1.getIdJoueur(), j1.getNomJoueur(), j1.getAnneeNaissance(), j1.getPseudo(), j1.getLangueFav(), j1.getHobbies());

        assertEquals(this.j1,this.sji.supprimerJoueur(this.j1.getPseudo()), "cas joueur supprimé");

        //assertEquals(null,this.sji.supprimerJoueur("Richard"), "cas pseudo  inexistant");

        //assertEquals(null,this.sji.supprimerJoueur("Dio"), "cas pseudo mal ecrit");

    }


}

