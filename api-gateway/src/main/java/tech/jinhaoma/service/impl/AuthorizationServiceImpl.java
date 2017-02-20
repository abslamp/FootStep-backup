package tech.jinhaoma.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jinhaoma.common.Constant;
import tech.jinhaoma.domain.Token;
import tech.jinhaoma.domain.User;
import tech.jinhaoma.domain.UserMapper;
import tech.jinhaoma.service.AuthorizationService;

/**
 * Created by mjrt on 2/20/2017.
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    UserMapper mapper;

    @Override
    public String login(String name, String passWord) {
        if(name == null || name.equals(""))
            return "Not Found User";
        if(passWord == null || passWord.equals(""))
            return "you need provid password";

        User user = mapper.query(name);

        if(user == null){
            return "Not Found User";
        }

        if (passWord.equals(user.getPassWord())){
            return Token.generateToken(name, Constant.MILLISECOND_ONE_DAY);
        } else {
            return "error";
        }

    }

    @Override
    public boolean signOut(String token) {
        return false;
    }

    @Override
    public boolean authorize(@Param("token") String tokenString,String userName) {
        Token token = Token.parseToken(tokenString);
        boolean flag =  token.getIss() != null &&
                        token.getExp() != null &&
                        token.getIat() != null &&
                        token.getSub() == userName &&
                        token.getIat()-System.currentTimeMillis() >= token.getExp();

        return flag;
    }
}
