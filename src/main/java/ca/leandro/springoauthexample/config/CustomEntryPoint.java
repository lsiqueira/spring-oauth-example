package ca.leandro.springoauthexample.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public CustomEntryPoint() {
        super("/login_form");
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        if (request.getRequestURI() != null && request.getRequestURI().toLowerCase().contains("/oauth/")) {
            super.commence(request, response, authException);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied.");
        }
    }
}