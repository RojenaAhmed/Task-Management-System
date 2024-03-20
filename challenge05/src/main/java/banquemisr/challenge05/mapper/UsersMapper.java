package banquemisr.challenge05.mapper;

import banquemisr.challenge05.DTO.UserDTO;

import banquemisr.challenge05.entities.users;

public class UsersMapper {
    public static UserDTO mapToUsersDTO(users users) {
        return new UserDTO(
                users.getUserId(),
                users.getFirstName(),
                users.getLastName(),
                users.getEmail(),
                users.getPassword(),
                users.getRole()

        );
    }

    public static users mapToTasks(UserDTO usersDTO) {
        return new users(
                usersDTO.getUserId(),
                usersDTO.getFirstName(),
                usersDTO.getLastName(),
                usersDTO.getEmail(),
                usersDTO.getPassword(),
                usersDTO.getRole()

        );


    }


}
