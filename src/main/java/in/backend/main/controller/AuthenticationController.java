package in.backend.main.controller;

import com.nimbusds.jose.JOSEException;
import in.backend.main.dto.request.AuthenticationRequest;
import in.backend.main.dto.request.IntrospectRequest;
import in.backend.main.dto.request.LogoutRequest;
import in.backend.main.dto.request.RefreshRequest;
import in.backend.main.dto.response.ApiResponse;
import in.backend.main.dto.response.AuthenticationResponse;
import in.backend.main.dto.response.IntrospectResponse;
import in.backend.main.service.IAuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    IAuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        var result = authenticationService.authenticate(authenticationRequest);
        return ApiResponse.<AuthenticationResponse>builder().code(HttpStatus.OK.value()).result(result).build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest introspectRequest) throws ParseException, JOSEException {
        var result = authenticationService.introspect(introspectRequest);
        return ApiResponse.<IntrospectResponse>builder()
                .code(HttpStatus.OK.value())
                .result(result)
                .build();
    }

    @PostMapping("/refresh")
    ApiResponse<AuthenticationResponse> refresh(@RequestBody RefreshRequest refreshRequest) throws ParseException, JOSEException {
        var result = authenticationService.refreshToken(refreshRequest);
        return ApiResponse.<AuthenticationResponse>builder()
                .code(HttpStatus.OK.value())
                .result(result)
                .build();
    }

    @PostMapping("/logout")
    ApiResponse<String> logout(@RequestBody LogoutRequest logoutRequest) throws ParseException, JOSEException {
        return ApiResponse.<String>builder()
                .code(HttpStatus.NO_CONTENT.value())
                .result(authenticationService.logout(logoutRequest))
                .build();
    }

}
