package testOnline.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import testOnline.dto.LoggedDTO;
import testOnline.entity.ActiveRefreshToken;
import testOnline.entity.User;
import testOnline.exceptions.BadRequesException;
import testOnline.repositories.ActiveRefreshTokenRepository;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenService {
    @Value("${settings.jwt.issuer}")
    private String issuer;

    // cfg
    @Value("${settings.jwt.token.key}")
    private String key;
    @Value("${settings.jwt.token.msExpires}")
    private long msExpires;

    @Value("${settings.jwt.refreshToken.key}")
    private String refreshTokenKey;
    @Value("${settings.jwt.refreshToken.msExpires}")
    private long refreshTokenMsExpires;

    @Autowired
    private ActiveRefreshTokenRepository activeRefreshTokenRepository;

    public Claims decodeToken(String jwt) {
        try
        {
            Claims claims = Jwts.parser()
                    .setSigningKey(key.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(jwt).getBody();
            return claims;
        }
        catch (Exception ex) {}

        throw new BadRequesException("Incorrect token!");
    }

    public Claims decodeRefreshToken(String jwt) {
        try
        {
            Claims claims = Jwts.parser()
                .setSigningKey(refreshTokenKey.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(jwt).getBody();
            return claims;
        }
        catch (Exception ex) {}

        throw new BadRequesException("Incorrect refresh token!");
    }

    public LoggedDTO login(User user) {
        var dto = new LoggedDTO();
        var jti = UUID.randomUUID().toString();
        var tokenExpires = new Date(new Date().getTime() + msExpires);
        System.out.println(new Date().getTime() + " " + msExpires);
        //Let's set the JWT Claims
        var builder = Jwts.builder().setId(jti)
                .setSubject(user.getId().toString())
                .setIssuer(issuer)
                .setExpiration(tokenExpires)
                .signWith(SignatureAlgorithm.HS256, key.getBytes(StandardCharsets.UTF_8));

        dto.token = builder.compact();

        builder.setSubject(null)
                .setExpiration(new Date(new Date().getTime() + refreshTokenMsExpires))
                .signWith(SignatureAlgorithm.HS256, refreshTokenKey.getBytes(StandardCharsets.UTF_8));

        dto.refreshToken = builder.compact();
        dto.expires = tokenExpires.getTime();

        var dbRefToken = new ActiveRefreshToken();
        dbRefToken.setJti(jti);
        dbRefToken.setUser(user);
        dbRefToken.setExpire(tokenExpires);
        activeRefreshTokenRepository.save(dbRefToken);

        return dto;
    }

    public LoggedDTO refreshToken(Claims claims) throws Exception {
        var activeRefreshToken = activeRefreshTokenRepository.findById(claims.getId()).get();
        if (activeRefreshToken == null)
            throw new BadRequesException("Incorrect jti");
        var user = new User();
        user.setId(activeRefreshToken.getUser().getId());
        activeRefreshTokenRepository.delete(activeRefreshToken);
        return login(user);
    }
}
