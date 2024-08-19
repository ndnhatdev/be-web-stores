package in.backend.main.service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.SignedJWT;
import in.backend.main.dto.request.IntrospectRequest;
import in.backend.main.dto.response.IntrospectResponse;

import java.text.ParseException;

public interface IAuthenticationService {
    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
    SignedJWT verifyToken(String token, boolean isRefresh) throws JOSEException, ParseException;
}
