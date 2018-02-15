package utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    private static final String CLAIM_ID = "userInfo";

    public static String encryptInformation(String userInfo, String fileKeyName){
        String key = FileUtils.getStringFileContent(fileKeyName);

        try {
            if(key != null){
                Algorithm algorithm = Algorithm.HMAC256(key);

                return JWT.create()
                        .withIssuer(userInfo)
                        .sign(algorithm);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding");
            System.out.println(e.toString());
        }
        return null;

    }


    public static String decryptInformation(String stringToDecrypt, String fileKeyName){
        String key = FileUtils.getStringFileContent(fileKeyName);

        try {
            Algorithm algorithm = Algorithm.HMAC256(key);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(stringToDecrypt);


            return jwt.getIssuer();

        } catch (UnsupportedEncodingException e){
            //UTF-8 encoding not supported
            System.out.println("Unsupported Encoding");
            System.out.println(e.toString());
        } catch (JWTVerificationException e){
            //Invalid signature/claims
            System.out.println("JWTVerificationException");
            System.out.println(e.toString());
        }
        return null;
    }


}
