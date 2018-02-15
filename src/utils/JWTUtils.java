package utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;

public class JWTUtils {

    /**
     * Method used to encrypt a specific information facilitated by parameters using as HMAC256 algorithm and as key, the read from file.
     * @param userInfo information to encrypt
     * @param fileKeyName Directory or name where the file is located
     * @return String with the token encrypted
     */
    public static String encryptInformation(String userInfo, String fileKeyName){
        String key = FileUtils.getStringFileContent(fileKeyName);

        try {
            if(key != null){
                Algorithm algorithm = Algorithm.HMAC256(key);

                return JWT.create()
                        .withSubject(userInfo)
                        .sign(algorithm);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding");
            System.out.println(e.toString());
        }
        return null;

    }

    /**
     * Method used to decrypt a specific information facilitated by parameters using as HMAC256 algorithm and as key, the read from file.
     * @param stringToDecrypt information to decrypt
     * @param fileKeyName Directory or name where the file is located
     * @return String with the user information decrypted
     */
    public static String decryptInformation(String stringToDecrypt, String fileKeyName){
        String key = FileUtils.getStringFileContent(fileKeyName);

        try {
            Algorithm algorithm = Algorithm.HMAC256(key);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(stringToDecrypt);


            return jwt.getSubject();

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
