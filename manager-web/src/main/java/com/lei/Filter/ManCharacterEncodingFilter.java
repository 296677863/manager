package com.lei.Filter;

import com.lei.SystemCacheHolder.ThreadLocalHolder;
import com.lei.util.WebUtils;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lei on 11/30/2016.
 */
public class ManCharacterEncodingFilter extends CharacterEncodingFilter{
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        persistIp(request);
        super.doFilterInternal(request, response, filterChain);
    }

    private void persistIp(HttpServletRequest request) {
        final String clientIp = WebUtils.retrieveClientIp(request);
        ThreadLocalHolder.clientIp(clientIp);
    }
}
