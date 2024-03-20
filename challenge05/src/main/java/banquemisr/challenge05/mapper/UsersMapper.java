package banquemisr.challenge05.mapper;

import banquemisr.challenge05.DTO.UserDTO;

import banquemisr.challenge05.entities.user;

public class UsersMapper {
    public static UserDTO mapToUsersDTO(user users) {
        return new UserDTO(
                users.getUserId(),
                users.getFirstName(),
                users.getLastName(),
                users.getEmail(),
                users.getPassword(),
                users.getRole()

        );
    }

    public static user mapToTasks(UserDTO usersDTO) {
        return new user(
                usersDTO.getUserId(),
                usersDTO.getFirstName(),
                usersDTO.getLastName(),
                usersDTO.getEmail(),
                usersDTO.getPassword(),
                usersDTO.getRole()

        );


    }


}
