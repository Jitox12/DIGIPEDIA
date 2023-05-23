package com.DIGIPEDIA.Digimon.Collection.utils;

public class FamilyCatcher {

    public static boolean familyCatcher(String digimonFamily, String digimonEvolvedFamily) {
        boolean result = false;

        switch (digimonFamily) {
            case "Training 1":
                result = (digimonEvolvedFamily.equals("Training 2")) ? true : false;
                break;
            case "Training 2":
                result = (digimonEvolvedFamily.equals("Rookie")) ? true : false;
                break;
            case "Rookie":
                result = (digimonEvolvedFamily.equals("Champion")) ? true : false;
                break;
            case "Champion":
                result = (digimonEvolvedFamily.equals("Ultimate")) ? true : false;
                break;
            case "Ultimate":
                result = (digimonEvolvedFamily.equals("Mega")) ? true : false;
                break;
            case "Mega":
                result = (digimonEvolvedFamily.equals("Ultra")) ? true : false;
                break;
            case "Ultra":
                result = false;
                break;
        }

        return result;
    }

}
