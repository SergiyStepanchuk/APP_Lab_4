package testOnline.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import testOnline.annotation.AutorizeFilter;
import testOnline.annotation.AutorizeUser;
import testOnline.entity.enumeration.AutorizeFilterTypes;
import testOnline.entity.enumeration.UserRole;
import testOnline.service.impl.JwtTokenService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtTokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        if (!(handler instanceof HandlerMethod))
            return true;
        AutorizeFilter annotation = ((HandlerMethod)handler).getMethod().getAnnotation((AutorizeFilter.class));

        if (annotation == null)
            annotation = ((HandlerMethod)handler).getMethod().getDeclaringClass().getAnnotation(AutorizeFilter.class);

        if (annotation != null) {
            if (annotation.vType() == AutorizeFilterTypes.AUTORIZED) {
                if (request.getHeader("Authorization") != null) {
                    var claims = tokenService.decodeToken(request.getHeader("Authorization").substring(7));
                    if (annotation.role().length > 0)
                    {
                        if (!Arrays.stream(annotation.role()).anyMatch(e -> e == UserRole.valueOf(claims.get("user_role").toString())))
                        {
                            response.setStatus(403);
                            return false;
                        }
                    }
                }
                else
                {
                    response.setStatus(403);
                    return false;
                }
            }
            else if (annotation.vType() == AutorizeFilterTypes.NOT_AUTORIZED)
            {
                if (request.getHeader("Authorization") != null)
                {
                    response.setStatus(403);
                    return false;
                }
            }
        }

        return true;
    }

}