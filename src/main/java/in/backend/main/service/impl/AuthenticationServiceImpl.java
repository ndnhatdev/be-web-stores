package in.backend.main.service.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;
import in.backend.main.dto.request.IntrospectRequest;
import in.backend.main.dto.response.IntrospectResponse;
import in.backend.main.repository.IUserRepository;
import in.backend.main.repository.InvalidateTokenRepository;
import in.backend.main.service.IAuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationServiceImpl implements IAuthenticationService {

    @NonFinal
    @Value("")
    protected String SIGNER_KEY;

    IUserRepository userRepository;
    InvalidateTokenRepository invalidateTokenRepository;

    @Override
    public IntrospectResponse introspect(IntrospectRequest request)
            throws JOSEException, ParseException {
        String token = request.getToken();
        boolean isValid = true;
        try {
            verifyToken(token, isValid);
        } catch (ParseException e) {
            isValid = false;
        }
        return IntrospectResponse.builder().valid(isValid).build();
    }

    @Override
    public SignedJWT verifyToken(String token, boolean isRefresh) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiresTime = (isRefresh)
                ? new Date(signedJWT
                .getJWTClaimsSet()
                .getIssueTime()
                .toInstant()
                .plus(36000, ChronoUnit.SECONDS)
                .toEpochMilli()) : signedJWT.getJWTClaimsSet().getExpirationTime();

        boolean verified = signedJWT.verify(verifier);

        if(!(verified && expiresTime.after(new Date()))) {
            System.out.println("error date");
        }

        if(invalidateTokenRepository.existsById(signedJWT.getJWTClaimsSet().getJWTID())) {
            System.out.println("error invalidate");
        }

        return signedJWT;
    }
}
