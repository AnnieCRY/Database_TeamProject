package edu.northeastern.cs5200.repositories;
import org.springframework.data.repository.CrudRepository;
import edu.northeastern.cs5200.models.Group;

public interface GroupRepository extends CrudRepository<Group, Integer>{

}