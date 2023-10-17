package cmpe.cloudcomputing.robot.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cmpe.cloudcomputing.robot.dto.AuthRequest;
import cmpe.cloudcomputing.robot.entity.Businessowner;
import cmpe.cloudcomputing.robot.entity.User;
import cmpe.cloudcomputing.robot.entity.UserAuthWrapper;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/public")
public class AuthAPI {
	
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthAPI(AuthenticationManager authenticationManager,
                   JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthWrapper> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getEmail(), request.getPassword()
                            )
                    );

            User user = (User) authenticate.getPrincipal();
            
            if (user.getRole().equals("BUSINESS")) {
            	Businessowner bo = (Businessowner)user;
            	return ResponseEntity.ok()
                        .body(new UserAuthWrapper(bo.getId(), bo.getRole(),  bo.getAccount(), jwtTokenUtil.generateAccessToken(user)));
            }
            return ResponseEntity.ok()
                    .body(new UserAuthWrapper(user.getId(), user.getRole(), jwtTokenUtil.generateAccessToken(user)));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

}