package com.medisoft.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

public class RequestIdMdcConfig implements Filter {

    private static final String REQUEST_ID = "REQUEST_ID";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put(REQUEST_ID, UUID.randomUUID().toString().replaceAll("-", "").substring(10));
        filterChain.doFilter(servletRequest, servletResponse);
        MDC.remove(REQUEST_ID);
    }

}
