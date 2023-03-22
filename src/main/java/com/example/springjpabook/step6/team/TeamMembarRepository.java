package com.example.springjpabook.step6.team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMembarRepository extends JpaRepository<TeamMember, String> {
}
