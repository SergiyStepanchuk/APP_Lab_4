package testOnline.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import testOnline.annotation.AutorizeUser;
import testOnline.entity.User;
import testOnline.service.impl.JwtTokenService;

@Component
public class AutorizeUserResolver implements HandlerMethodArgumentResolver {

    private JwtTokenService tokenService;

    public AutorizeUserResolver(JwtTokenService tokenService)
    {
        this.tokenService = tokenService;
    }

    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(AutorizeUser.class) != null;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        var token = webRequest.getHeader("Authorization").substring(7);
        return new User(
                Long.valueOf(
                        tokenService.decodeToken(token).getSubject()
                )
        );
    }
}
