package banquemisr.challenge05.mapper;

import banquemisr.challenge05.DTO.UserDTO;

import banquemisr.challenge05.entities.User;

public class UsersMapper {
    public static UserDTO mapToUsersDTO(User users) {
        return new UserDTO(
                users.getUserId(),
                users.getFirstName(),
                users.getLastName(),
                users.getEmail(),
                users.getPassword(),
                users.getRole()

        );
    }

    public static User mapToTasks(UserDTO usersDTO) {
        return new User(
                usersDTO.getUserId(),
                usersDTO.getFirstName(),
                usersDTO.getLastName(),
                usersDTO.getEmail(),
                usersDTO.getPassword(),
                usersDTO.getRole()

        );


    }


}
