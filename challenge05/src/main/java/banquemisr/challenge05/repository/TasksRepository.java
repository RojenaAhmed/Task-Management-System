package banquemisr.challenge05.repository;

import banquemisr.challenge05.entities.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TasksRepository extends JpaRepository<Tasks,Long> {
        Page<Tasks> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    }


