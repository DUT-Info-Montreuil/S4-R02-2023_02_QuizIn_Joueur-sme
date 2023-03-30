package test.fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.impl;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto.ScoreDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.enums.Langues;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.exceptions.JoueurNonExistant;
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
    private JoueurDTO j2 = new JoueurDTO("Rachid", 2003, "RSK", Langues.Francais, "Football");
    private JoueurDTO j3 = new JoueurDTO("Yanis", 2003, "ttc", Langues.Francais, "basket");

    private ScoreDTO s1 = new ScoreDTO(10, 100);

    private ScoreDTO s2 = new ScoreDTO(10, 100);

    private IServiceJoueur sji;

    @BeforeEach
    void setUp (TestInfo testInfo) throws PseudoJoueurDejaExistant {
        this.serviceJoueurMockOk = new ServiceJoueurMockOk();
        this.serviceJoueurMockKo = new ServiceJoueurMockKo();
        this.serviceJoueurMockOk.ajouterJoueur("Dio", 1866, "DIO", Langues.Francais, "rugby");

        this.sji = new ServiceJoueurImpl();
        this.sji.ajouterJoueur("Jonathan", 1866, "JoJo", Langues.Francais, "rugby");
        this.sji.ajouterJoueur("Dio", 1866, "DIO", Langues.Francais, "rugby");
        this.sji.ajouterJoueur("Rachid", 2003, "RSK", Langues.Francais, "Football");


        System.out.println("test " + testInfo.getDisplayName());
    }

    @org.junit.jupiter.api.Test
    void ajouterJoueurMock () throws PseudoJoueurDejaExistant {

        try {

            assertEquals(this.j1, this.serviceJoueurMockOk.ajouterJoueur("Dio", 1866, "DIO", Langues.Francais, "rugby"));

            assertNotEquals(this.j1, this.serviceJoueurMockOk.ajouterJoueur("Dio", 1866, "dio", Langues.Francais, "rugby"), "Cas pseudo ressemblant : joueur créé");

            assertEquals(this.j1, this.serviceJoueurMockOk.ajouterJoueur("Diego", 1870, "DIO", Langues.Francais, "cheval, course"), "Cas pseudo déjà existant : joueur pas créé");

        } catch (PseudoJoueurDejaExistant e) {

            System.out.println("Joueur déjà existant");

        }
    }

    @org.junit.jupiter.api.Test
    void ajouterJoueurMethode () throws PseudoJoueurDejaExistant {

        try {

            assertEquals(this.j1, sji.ajouterJoueur("Dio", 1866, "DIO", Langues.Francais, "rugby"), "cas joueur valide : créé");

            assertEquals(null, sji.ajouterJoueur("Jonathan", 1866, "JoJo", Langues.Francais, "rugby"), "cas joueur identique : pas créé");

            assertEquals(new JoueurDTO("Joseph", 1920, "Jojo", Langues.Francais, "aucun"), sji.ajouterJoueur("Joseph", 1920, "Jojo", Langues.Francais, "aucun"), "cas joueur ressemblant : créé");

        } catch (PseudoJoueurDejaExistant e) {

            System.out.println("Joueur déjà existant");

        }
    }

    @org.junit.jupiter.api.Test
    void supprimerJoueurMock () throws PseudoJoueurDejaExistant {

        this.serviceJoueurMockOk.ajouterJoueur("Dio", 1866, "DIO", Langues.Francais, "rugby");

        assertEquals(this.j1, this.serviceJoueurMockOk.supprimerJoueur(j1.getPseudo()), "cas joueur supprimé");

        assertEquals(null, this.serviceJoueurMockOk.supprimerJoueur("Naoufel"), "cas joueur inexistant");

        assertEquals(null, this.serviceJoueurMockOk.supprimerJoueur("Dio"), "cas pseudo mal ecrit");

    }

    @org.junit.jupiter.api.Test
    void supprimerJoueurMethode () throws PseudoJoueurDejaExistant, JoueurNonExistant {

        this.sji.ajouterJoueur(j1.getNomJoueur(), j1.getAnneeNaissance(), j1.getPseudo(), j1.getLangueFav(), j1.getHobbies());

        assertEquals(this.j1, this.sji.supprimerJoueur(this.j1.getPseudo()), "cas joueur supprimé");

        assertEquals(null, this.sji.supprimerJoueur("Richard"), "cas pseudo  inexistant");

        assertEquals(null, this.sji.supprimerJoueur("Dio"), "cas pseudo mal ecrit");

    }

    @org.junit.jupiter.api.Test
    void gestionScoreJoueurMock () {
        ScoreDTO resultat = this.serviceJoueurMockOk.gestionScoreJoueur(50, 300, this.j1);

        assertEquals(null, this.serviceJoueurMockKo.gestionScoreJoueur(5, 120, this.j1));

        assertEquals(50, resultat.getPoints(), "Cas point bien ajouté");

        assertEquals(300, resultat.getTemps(), "Cas temps bien ajouté");
    }

    @org.junit.jupiter.api.Test
    void gestionScoreJoeurMethode () {
        this.sji.gestionScoreJoueur(this.s1.getPoints(), this.s1.getTemps(), this.j1);
        this.sji.gestionScoreJoueur(this.s2.getPoints(), this.s2.getTemps(), this.j1);

        ScoreDTO score = new ScoreDTO(50, 120);
        ScoreDTO resultat = this.sji.gestionScoreJoueur(score.getPoints(), score.getTemps(), this.j2);

        assertEquals(1, this.j2.getListeScores().size(), "Cas score bien ajouté dans la liste de score du joueur");

        assertEquals(10, this.j1.getMoyennePoints(), "Cas pour voir si la moyenne des points du joueur est bien calculé");

        assertEquals(100, this.j1.getMoyenneTemps(), "Cas pour voir si la moyenne des temps du joueur est bien calculée");

        assertEquals(50, resultat.getPoints(), "Cas point bien ajouté dans le score ");

        assertEquals(120, resultat.getTemps(), "Cas temps bien ajouté dans le score");

        assertEquals(20, this.j1.getTotalPoints(), "Cas total point joueur bien calculé");

        assertEquals(2, this.j1.getTotalPartiesJouees(), "Cas total partie jouée bien pris en compte");
    }


    @org.junit.jupiter.api.Test
    void fournirStatsJoueurMock () {
        ScoreDTO score1 = new ScoreDTO(100, 1000);
        ScoreDTO score2 = new ScoreDTO(500, 500);
        this.j1.getListeScores().add(score1);
        this.j1.getListeScores().add(score2);
        ArrayList<ScoreDTO> listeScore = this.j1.getListeScores();

        assertEquals(listeScore, this.serviceJoueurMockOk.fournirStatsJoueur(this.j1), "Statistique bien retournée");

        assertEquals(null, this.serviceJoueurMockKo.fournirStatsJoueur(this.j2), "Cas liste score vide");
    }

    @org.junit.jupiter.api.Test
    void fournirStatsJoueurMethode () {
        ScoreDTO score1 = new ScoreDTO(60, 800);
        ScoreDTO score2 = new ScoreDTO(20, 250);
        this.j2.getListeScores().add(score1);
        this.j2.getListeScores().add(score2);
        ArrayList<ScoreDTO> listeScore = this.j2.getListeScores();

        assertEquals(listeScore, this.sji.fournirStatsJoueur(this.j2), "Statistique bien retournée");

        assertEquals(null, this.sji.fournirStatsJoueur(this.j3), "Cas liste score joueur vide");
    }

}

