package in.backend.main.service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.SignedJWT;
import in.backend.main.dto.request.AuthenticationRequest;
import in.backend.main.dto.request.IntrospectRequest;
import in.backend.main.dto.request.RefreshRequest;
import in.backend.main.dto.response.AuthenticationResponse;
import in.backend.main.dto.response.IntrospectResponse;
import in.backend.main.enity.User;
import org.springframework.security.core.Authentication;

import java.text.ParseException;

public interface IAuthenticationService {
    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
    AuthenticationResponse authenticate(AuthenticationRequest request);
    AuthenticationResponse refreshToken(RefreshRequest request) throws ParseException, JOSEException;
}
