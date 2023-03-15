package test.fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.enums.Langues;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.exceptions.PseudoJoueurDejaExistant;
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
    private JoueurDTO j1 = new JoueurDTO("Dio", 1866, "DIO", Langues.Francais, "rugby");
    private IServiceJoueur sji;

    @BeforeEach
    void setUp(TestInfo testInfo) throws PseudoJoueurDejaExistant {
        this.serviceJoueurMockOk = new ServiceJoueurMockOk();
        this.serviceJoueurMockKo = new ServiceJoueurMockKo();

        this.serviceJoueurMockOk.ajouterJoueur("Dio", 1866, "DIO", Langues.Francais, "rugby");

        this.sji = new ServiceJoueurImpl();
        this.sji.ajouterJoueur("Jonathan", 1866, "JoJo", Langues.Francais, "rugby");

        System.out.println("test " + testInfo.getDisplayName());
    }

    @org.junit.jupiter.api.Test
    void ajouterJoueurMock() throws PseudoJoueurDejaExistant {

        try {

            assertEquals(this.j1, this.serviceJoueurMockOk.ajouterJoueur("Dio", 1866, "DIO", Langues.Francais, "rugby"));

            assertNotEquals(this.j1, this.serviceJoueurMockOk.ajouterJoueur("Dio", 1866, "dio", Langues.Francais, "rugby"), "Cas pseudo ressemblant : joueur créé");

            assertEquals(this.j1, this.serviceJoueurMockOk.ajouterJoueur("Diego", 1870, "DIO", Langues.Francais, "cheval, course"), "Cas pseudo déjà existant : joueur pas créé");

        } catch(PseudoJoueurDejaExistant e) {

            System.out.println("Joueur déjà existant");

        }
    }

    @org.junit.jupiter.api.Test
    void ajouterJoueurMethode() throws PseudoJoueurDejaExistant {

        try {

            assertEquals(this.j1, sji.ajouterJoueur("Dio", 1866, "DIO", Langues.Francais, "rugby"), "cas joueur valide : créé");

            assertEquals(null, sji.ajouterJoueur("Jonathan", 1866, "JoJo", Langues.Francais, "rugby"), "cas joueur identique : pas créé");

            assertEquals(new JoueurDTO("Joseph", 1920, "Jojo", Langues.Francais, "aucun"), sji.ajouterJoueur("Joseph", 1920, "Jojo", Langues.Francais, "aucun"), "cas joueur ressemblant : créé");

        } catch(PseudoJoueurDejaExistant e) {

            System.out.println("Joueur déjà existant");

        }
    }

    @org.junit.jupiter.api.Test
    void supprimerJoueurMock() throws PseudoJoueurDejaExistant {

        this.serviceJoueurMockOk.ajouterJoueur("Dio", 1866, "DIO", Langues.Francais, "rugby");

        assertEquals(this.j1,this.serviceJoueurMockOk.supprimerJoueur(j1.getPseudo()), "cas joueur supprimé");

        assertEquals(null,this.serviceJoueurMockOk.supprimerJoueur("Naoufel"), "cas joueur inexistant");

        assertEquals(null,this.serviceJoueurMockOk.supprimerJoueur("Dio"), "cas pseudo mal ecrit");

    }

    @org.junit.jupiter.api.Test
    void supprimerJoueurMethode() throws PseudoJoueurDejaExistant {

        this.sji.ajouterJoueur(j1.getNomJoueur(), j1.getAnneeNaissance(), j1.getPseudo(), j1.getLangueFav(), j1.getHobbies());

        assertEquals(this.j1,this.sji.supprimerJoueur(this.j1.getPseudo()), "cas joueur supprimé");

        assertEquals(null,this.sji.supprimerJoueur("Richard"), "cas pseudo  inexistant");

        assertEquals(null,this.sji.supprimerJoueur("Dio"), "cas pseudo mal ecrit");

    }


}

