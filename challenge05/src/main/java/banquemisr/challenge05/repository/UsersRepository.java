package banquemisr.challenge05.repository;

import banquemisr.challenge05.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<user, Long> {

    Optional<user> findByEmail(String email);

}

