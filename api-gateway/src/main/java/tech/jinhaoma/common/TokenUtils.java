package tech.jinhaoma.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.jinhaoma.domain.TokenHeader;
import tech.jinhaoma.domain.TokenPayload;
import tech.jinhaoma.domain.User;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by mjrt on 2/22/2017.
 */
public class TokenUtils {

    private static ObjectMapper objectMapper;
//    private static TokenHeader header;
//    private static TokenPayload payload;

    static {
        objectMapper = new ObjectMapper();
    }

    public static String generateToken(User user, Long exp, String alg){

        TokenHeader header = new TokenHeader();
        header.setTyp("JWT");
        header.setAlg(alg);

        TokenPayload payload = new TokenPayload();
        payload.setIss("MJRT");
        payload.setSub(user.getRole());
        payload.setAud(user.getName());
        payload.setIat(System.currentTimeMillis());
        payload.setExp(exp);

        String headerJson = null;
        String payloadJson = null;
        try {
            headerJson = objectMapper.writeValueAsString(header);
            payloadJson = objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String headerBase64 = null;
        String payloadBase64 = null;
        try {
            headerBase64 = Base64.getEncoder().encodeToString(headerJson.getBytes("utf-8"));
            payloadBase64 = Base64.getEncoder().encodeToString(payloadJson.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();
        builder.append(headerBase64);
        builder.append(".");
        builder.append(payloadBase64);

        String signature = RSAUtils.encrypt(builder.toString());
        builder.append(".");
        builder.append(signature);

        return builder.toString();
    }

    public static boolean checkToken(String token){
        String[] value = token.split("[.]");

        if(value.length != 3)   return false;

        String header = value[0];
        String payload = value[1];
        String signature = value[2];



        String[] contrast = RSAUtils.decrypt(signature).split("[.]");
        String headerContrast = new String(Base64.getDecoder().decode(contrast[0]));
        String payloadContrast = new String(Base64.getDecoder().decode(contrast[1]));

        if(contrast.length != 2 )   return false;

        return header.equals(contrast[0]) && payload.equals(contrast[1]);
    }

    public static TokenPayload parseToken(String token){
        String[] value = token.split("[.]");
        String payloadBase64 = null;

        if (value.length==3)
            payloadBase64 = value[1];
        TokenPayload payload = null;
        try {
            payload =  objectMapper.readValue(Base64.getDecoder().decode(payloadBase64),TokenPayload.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return payload;
    }
}
