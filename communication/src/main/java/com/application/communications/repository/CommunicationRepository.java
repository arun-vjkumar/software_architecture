package com.application.communications.repository;

import com.application.communications.entity.Communication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicationRepository extends JpaRepository<Communication, Long> {
}