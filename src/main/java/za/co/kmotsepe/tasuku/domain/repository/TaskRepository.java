package za.co.kmotsepe.tasuku.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.kmotsepe.tasuku.domain.entities.TaskEntity;

/**
 *
 * @author Kingsley Motsepe
 */
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer>{
    
}
