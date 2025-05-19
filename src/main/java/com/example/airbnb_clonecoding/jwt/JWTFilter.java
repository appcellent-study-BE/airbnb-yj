package com.example.airbnb_clonecoding.jwt;

import com.example.airbnb_clonecoding.dto.CustomUserDetailsDto;
import com.example.airbnb_clonecoding.model.Member;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    public JWTFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // request에서 Header-Authorization를 받아옴
        String authorization = request.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {

            System.out.println("token null");
            filterChain.doFilter(request, response);

            // 메소드 종료
            return;
        }

        String token = authorization.split("")[1];

        // 토큰 소멸 시간 검증
        if (jwtUtil.isExpired(token)) {

            System.out.println("token expired");
            filterChain.doFilter(request, response);

            // 메소드 종료
            return;
        }

        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        Member member = new Member();
        member.setUserName(username);
        member.setUserPassword("pw");
        member.setRole(role);

        CustomUserDetailsDto customUserDetailsDto = new CustomUserDetailsDto(member);

        Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetailsDto, null, customUserDetailsDto.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }
}
