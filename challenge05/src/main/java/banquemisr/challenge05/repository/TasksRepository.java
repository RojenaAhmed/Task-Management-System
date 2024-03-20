package banquemisr.challenge05.repository;

import banquemisr.challenge05.entities.task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<task, Long> {
    Page<task> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}


