package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.entities.dto;

import java.util.Objects;

public class ScoreDTO {

    private int idScore;
    private static int compteurScore = 0;
    private int points;
    private long temps;

    public ScoreDTO(int points, long temps) {
        this.idScore = compteurScore;
        compteurScore++;
        this.points = points;
        this.temps = temps;
    }

    public int getIdScore() {
        return idScore;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public long getTemps() {
        return temps;
    }

    public void setTemps(long temps) {
        this.temps = temps;
    }



}
