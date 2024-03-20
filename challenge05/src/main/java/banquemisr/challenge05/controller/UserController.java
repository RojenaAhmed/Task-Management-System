package banquemisr.challenge05.controller;

import banquemisr.challenge05.DTO.UserDTO;
import banquemisr.challenge05.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {
    private UserController userController;
    private UsersService usersService;

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserId(@PathVariable("id") Long userId) {
        UserDTO usersDTO = usersService.getUsersById(userId);
        return ResponseEntity.ok(usersDTO);

    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        String token = usersService.login(email, password);
        return ResponseEntity.ok(token);
    }

}