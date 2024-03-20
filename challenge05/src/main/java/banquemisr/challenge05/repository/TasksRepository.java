package banquemisr.challenge05.repository;

import banquemisr.challenge05.entities.tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<tasks,Long> {
        Page<tasks> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    }


