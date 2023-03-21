package com.example.springjpabook.team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMembarRepository extends JpaRepository<TeamMember, String> {
}
