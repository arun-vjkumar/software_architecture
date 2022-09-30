package com.application.communications.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "communication_logs")
public class CommunicationLog extends AuditDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CommunicationIdGenerator")
    @SequenceGenerator(name = "CommunicationIdGenerator", sequenceName = "CommunicationId", allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name="type", nullable = false)
    private String type;

    @Column(name = "vendor", nullable = false)
    private String vendor;
}
