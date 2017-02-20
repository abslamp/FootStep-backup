package tech.jinhaoma.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import tech.jinhaoma.common.Constant;
import tech.jinhaoma.common.RSAUtils;

/**
 * Created by mjrt on 2/20/2017.
 */

/*
    @Param iss 签发着
    @Param sub 使用者
    @Param aud 接收方
    @Param iat 签发时间戳
    @Param exp 有效期
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class Token {

    private String iss;
    private String sub;
//    private String aud;
    private Long iat ;  //= System.currentTimeMillis();
    private Long exp ;

    public static String generateToken(String name,Long exp){

        Token token = new Token();
        token.setIss("MJRT");
        token.setSub(name);
        token.setIat(System.currentTimeMillis());
        token.setExp(exp);


        StringBuilder builder = new StringBuilder();
        builder.append(token.getIss()); builder.append("_");    //iss
        builder.append(token.getSub()); builder.append("_");    //sub
        builder.append(token.getIat()); builder.append("_");    //iat
        builder.append(token.getExp());                         //exp
        String tokenString = RSAUtils.encrypt(builder.toString());
        return tokenString;
    }

    public static Token parseToken(String tokenString){

        tokenString = RSAUtils.decrypt(tokenString);
        String[] str = tokenString.split("_");

        Token token = new Token();
        token.setIss(str.length > 0 ? str[0] : null);
        token.setSub(str.length > 1 ? str[1] : null);
        token.setIat(str.length > 2 ? Long.valueOf(str[2]) : null);
        token.setExp(str.length > 3 ? Long.valueOf(str[3]) : null);

        return token;
    }

//    public static void main(String[] args) {
//        String tokenString = Token.generateToken("mjh",Constant.MILLISECOND_ONE_DAY);
//        System.out.println(tokenString);
//
//        Token token = Token.parseToken(tokenString);
//        System.out.println(token.toString());
//    }

}
