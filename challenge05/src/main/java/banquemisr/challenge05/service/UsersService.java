package banquemisr.challenge05.service;

import banquemisr.challenge05.DTO.UserDTO;

public interface UsersService {
  UserDTO getUsersById(Long userId);

    String login(String email,String password);
}
