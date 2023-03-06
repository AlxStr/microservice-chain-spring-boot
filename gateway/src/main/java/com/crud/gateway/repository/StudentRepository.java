package com.crud.gateway.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.gateway.entity.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}
