package com.dodonew.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dodonew.controller.helper.BackMapHelper;
import com.dodonew.utils.ErrorEnum;
import com.dodonew.utils.HttpUtil;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by yukx on 17/4/14.
 */
public class APIInterceptor extends HandlerInterceptorAdapter {
    Logger logger = Logger.getLogger(APIInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        Algorithm algorithm = null;
        try {
            algorithm = Algorithm.HMAC256("^^___@");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {

            JWTVerifier verifier = JWT.require(algorithm).withIssuer("teashop_api").build();
            DecodedJWT decodedJWT = verifier.verify(token);
        }catch (Exception e){
            e.printStackTrace();
            Map<String,Object> res = BackMapHelper.back(ErrorEnum.SIGN_ERROR);
            try {
                PrintWriter pw = response.getWriter();
                pw.append(new Gson().toJson(res));
                pw.flush();
                pw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return  false;
        }

        return true;
    }
}
