package com.crud.lastname.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.lastname.entity.Lastname;

public interface LastnameRepository extends JpaRepository<Lastname, UUID> {
}
