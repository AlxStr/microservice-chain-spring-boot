package com.crud.middlename.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.middlename.entity.Middlename;

public interface MiddlenameRepository extends JpaRepository<Middlename, UUID> {
}
