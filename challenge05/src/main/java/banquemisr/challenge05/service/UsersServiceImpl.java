package banquemisr.challenge05.service;

import banquemisr.challenge05.DTO.UserDTO;

import banquemisr.challenge05.security.JwtService;
import banquemisr.challenge05.entities.users;

import banquemisr.challenge05.exception.UsersNotFoundExceptions;

import banquemisr.challenge05.mapper.UsersMapper;

import banquemisr.challenge05.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final JwtService jwtService;
    public UserDTO getUsersById (Long userId) {
        users users = usersRepository.findById(userId)
                .orElseThrow(() ->
        new UsersNotFoundExceptions(("\"user is not exist : \" " + userId)));

        return UsersMapper.mapToUsersDTO(users);
    }

    private UserDetails getUserDetails(String email){
        return usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    private boolean isValidEmail(String email){
        return email!=null&&email.contains("@");
    }
    private boolean isValidPassword(String password){
        return password!= null && password.length()>=8;
    }
    @Override
    public String login(String email,String password) {
        if (!isValidEmail(email)|| !isValidPassword(password)){
            throw new UsersNotFoundExceptions("invalid Credentials");
        }
        UserDetails userDetails = getUserDetails(email);
        return jwtService.generateToken(userDetails);
    }

}
