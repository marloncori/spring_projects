package net.javaguides.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.student_management.model.Student;

                            //no need to add @Repository annotation.
                            //no need to add @Transactional annotation to the Serivce layer
                            //Long refers to the type of the primary key.
public interface StudentRepository extends JpaRepository<Student, Long> {

}
