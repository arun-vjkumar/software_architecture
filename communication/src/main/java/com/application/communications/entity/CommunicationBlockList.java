package com.application.communications.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Communication_block_list")
public class CommunicationBlockList extends AuditDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "recipient", nullable = false)
    private String recipient;
    
    @Column(name = "reason")
    private String reason;
    
    @Column(name = "blocked_at", nullable = false)
    private LocalDateTime blockedAt;
    
    @Column(name = "blocked_until")
    private LocalDateTime blockedUntil;
}
