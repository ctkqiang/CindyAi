package com.artificial_intelligent.johnmelodyme.cindyai.Model;

public class CindyCharacter {
    private static String cindy;
    private static String AI;

    public CindyCharacter() {
    }

    public static void setCindy(String cindy) {
        CindyCharacter.cindy = cindy;
    }

    public static void setAI(String AI) {
        CindyCharacter.AI = AI;
    }

    public static String getCindy() {
        return cindy;
    }

    public static String getAI() {
        return AI;
    }
}
