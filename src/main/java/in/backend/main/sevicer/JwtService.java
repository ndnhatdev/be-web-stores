package in.backend.main.sevicer;

import in.backend.main.security.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.Authenticator;
import java.util.Date;

@Service
@Component
public class JwtService {
    private static final String SELECT_KEY = "07112002";
    private static final Long EXPIRATION_TIME = 86400000000L;
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    public String generateJwtToken(Authentication authentication) {
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRATION_TIME * 1000))
                .signWith(SignatureAlgorithm.HS512, SELECT_KEY)
                .compact();
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(SELECT_KEY).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    public String getUsernameFromJwtToken(String token) {
        String username = null;
                username= Jwts.parser()
                .setSigningKey(SELECT_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
        return username;
    }
}
