package banquemisr.challenge05.repository;

import banquemisr.challenge05.entities.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<users,Long> {

     Optional<users> findByEmail(String email) ;

    }

