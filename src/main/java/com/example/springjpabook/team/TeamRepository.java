package com.example.springjpabook.team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
