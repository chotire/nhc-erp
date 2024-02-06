package nhc.erp.prunus.biz.user;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import prunus.biz.core.user.UserContext;
import prunus.biz.core.user.UserContextProvider;

/**
 * @author 조용상
 */
@Component
public class UserContextProviderImpl implements UserContextProvider {
	@Override
    public Optional<UserContext> getUserContext(HttpServletRequest request) {
        UserContext userContext = new UserContext("nhc", "nhcadmin");
        return Optional.of(userContext);
    }
}
