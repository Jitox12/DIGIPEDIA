package com.DIGIPEDIA.Digimon.Collection.utils;

import java.util.Base64;

public class Base64Coder {
    public static byte[] base64Decoder(String base64){
        return Base64.getDecoder().decode(base64);
    }

    public static String base64Encoder(byte[] bytes){
        return  Base64.getEncoder().encodeToString(bytes);
    }
}
