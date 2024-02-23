package com.tradeflow.filters;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/register") // Specify the URL pattern to which this filter should be applied
public class AgeValidationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if any
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Retrieve the date of birth parameter from the request
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));

        // Calculate the age
        int age = Period.between(dob, LocalDate.now()).getYears();

        // Check if the age is greater than 18
        if (age < 18) {
            // If age is less than 18, send an error response
            response.getWriter().write("You must be 18 years or older to register.");
        } else {
            // If age is 18 or older, continue with the filter chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Cleanup code, if any
    }
}
