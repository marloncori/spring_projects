package pl.millenium.mvctutorial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@repository
public interface RobotRepository extends CrudRepository<Robot> {
}
