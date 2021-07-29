package br.com.desafio.cooperforteservice.controllers;

import br.com.desafio.cooperforteservice.dtos.JwtRequest;
import br.com.desafio.cooperforteservice.dtos.JwtResponse;
import br.com.desafio.cooperforteservice.security.JwtTokenUtil;
import br.com.desafio.cooperforteservice.security.JwtUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AutenticacaoController {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsService userDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        Authentication authentication = authenticate(authenticationRequest.converter());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.gerarToken(authentication);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private Authentication authenticate(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws Exception {
        //TODO: Exception customizada
        try {
            return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        } catch (Exception e) {
            throw new Exception(e.getCause());
        }
    }
}
