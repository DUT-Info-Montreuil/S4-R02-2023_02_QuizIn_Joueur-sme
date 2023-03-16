package fr.iut.montreuil.R4_S02_2023_2_QuizIn.joueur_sme.enums;

public enum Langues {
    Francais(1, "FR", "Française"),
    Anglais(2, "EN", "Anglaise"),
    Allemand(3, "DE", "Allemande"),
    Espagnole(4, "ES", "Espagnole"),
    Italien(5, "IT", "Italienne");

    Langues(int id, String code, String label) {
        this.id = id;
        this.code = code;
        this.label = label;
    }

    private final int id;
    private final String code;
    private final String label;

}