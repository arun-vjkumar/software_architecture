package com.application.communications.entity;

import com.application.communications.enums.CommunicationType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "communications")
public class Communication extends AuditDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name="types", nullable = false)
    private List<CommunicationType> types;
}
