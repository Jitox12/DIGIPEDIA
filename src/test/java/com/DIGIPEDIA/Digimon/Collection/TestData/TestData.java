package com.DIGIPEDIA.Digimon.Collection.TestData;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class TestData {
    public static byte[] img = Base64.getDecoder().decode("Base64");
    public static List<Integer> idList = new ArrayList<>();

    public static Integer genericId = 1;

    public static String digimonName = "Agumon";

    public static String digimonTypeName = "Virus";

    public static String digimonPassive= "Fueguito";

    public static String digimonFamilyName = "Bebe";

    public static String attributeName = "Fuego";

    public static String skillName = "Placaje";

    public static String skillDescription = "Danio";

    public static String skillTypeName = "Normal";

}
