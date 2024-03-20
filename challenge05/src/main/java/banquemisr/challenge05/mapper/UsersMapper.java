package banquemisr.challenge05.mapper;

import banquemisr.challenge05.DTO.UsersDTO;

import banquemisr.challenge05.entities.Users;

public class UsersMapper {
    public static UsersDTO mapToUsersDTO(Users users) {
        return new UsersDTO(
                users.getUserId(),
                users.getFirstName(),
                users.getLastName(),
                users.getEmail(),
                users.getPassword(),
                users.getRole()

        );
    }

    public static Users mapToTasks(UsersDTO usersDTO) {
        return new Users(
                usersDTO.getUserId(),
                usersDTO.getFirstName(),
                usersDTO.getLastName(),
                usersDTO.getEmail(),
                usersDTO.getPassword(),
                usersDTO.getRole()

        );


    }


}
