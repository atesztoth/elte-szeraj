package atesztoth.elte.szeraj.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements AuthenticationFacadeInterface {

    @Override
    public Authentication getAuthentication() {
        return getSecurityContext().getAuthentication();
    }

    @Override
    public SecurityContext getSecurityContext() {
        return SecurityContextHolder.getContext();
    }
}
