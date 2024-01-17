package com.dannyrooh.s3upload.ged.domain.util;

import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilCheckSum256 {

    public static String exec(InputStream inputStream) throws NoSuchAlgorithmException {
        
        byte[] sha256Hash = calculateSHA256(inputStream);
        return bytesToHex(sha256Hash);

    }

    private static byte[] calculateSHA256(InputStream inputStream) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] buffer = new byte[8192];
        
        try (DigestInputStream digestInputStream = new DigestInputStream(inputStream, digest)) {
            while (digestInputStream.read(buffer) != -1) {
                // Do nothing, just read to update the digest
            }
        } catch (Exception e) {
            new Exception("Erro ao calcular o checkSum do arquivo"); 
        }

        return digest.digest();
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    
}
