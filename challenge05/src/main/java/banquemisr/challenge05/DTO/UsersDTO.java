package banquemisr.challenge05.DTO;


import banquemisr.challenge05.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO  {

    private Long userId;

    private String firstName;

    private String lastName ;

    private String email ;

    private String password ;

    private Role role ;

}
