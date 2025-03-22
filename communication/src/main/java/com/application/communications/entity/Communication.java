package com.application.communications.entity;

import com.application.communications.enums.CommunicationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
