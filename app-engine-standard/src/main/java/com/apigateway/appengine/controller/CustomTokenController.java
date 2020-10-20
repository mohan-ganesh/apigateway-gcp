package com.apigateway.appengine.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.apigateway.appengine.exception.InvalidInputException;


@RestController
public class CustomTokenController {

    public static Log logger = LogFactory.getLog(CustomTokenController.class);

    /**
     *
     * @param userId
     * @return
     * @throws FirebaseAuthException
     */
    @RequestMapping (path="/firebase/custom/token", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity customtoken(@RequestParam ("userId") String userId ) throws FirebaseAuthException {

        if (null == userId || userId.isEmpty()) {
            throw new InvalidInputException("User Id is required value");
        }
        String customToken = FirebaseAuth.getInstance().createCustomToken(userId);
        return ResponseEntity.ok(customToken);
    }

    /**
     *
     * @param token
     * @return
     * @throws JWTDecodeException
     */
    @RequestMapping (path="/appengine/decode/token", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity decodetoken(@RequestHeader ("token") String token) throws JWTDecodeException {
    DecodedJWT jwt = JWT.decode(token);
    return ResponseEntity.ok(jwt);


    }


}
