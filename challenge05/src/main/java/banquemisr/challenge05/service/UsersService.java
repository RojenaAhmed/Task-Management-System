package banquemisr.challenge05.service;

import banquemisr.challenge05.DTO.UsersDTO;

public interface UsersService {
  UsersDTO getUsersById(Long userId);

    String login(String email,String password);
}
