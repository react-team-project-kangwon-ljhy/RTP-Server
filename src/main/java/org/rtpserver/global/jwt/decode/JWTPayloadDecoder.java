package org.rtpserver.global.jwt.decode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Map;

@Slf4j
@Service
public class JWTPayloadDecoder {

    public Long jwtPayloadDecodeToUserId(String jwt) {
        jwt = jwt.substring(jwt.indexOf("."), jwt.length()-1);
        jwt = jwt.substring(0, jwt.indexOf(".", 1));
        jwt = jwt.replace(".", "");

        log.warn("decode jwt: " + jwt);
        Base64.Decoder decoder = Base64.getUrlDecoder();
        JsonParser jsonParser = new BasicJsonParser();
        Map<String, Object> jsonArray = jsonParser.parseMap(new String(decoder.decode(jwt)));
        return Long.valueOf(jsonArray.get("sub").toString());
    }

}
