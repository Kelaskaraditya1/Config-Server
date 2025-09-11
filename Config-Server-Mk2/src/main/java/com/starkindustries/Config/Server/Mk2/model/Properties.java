package com.starkindustries.Config.Server.Mk2.model;

import com.starkindustries.Config.Server.Mk2.enums.Profiles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "Property")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application")
    private String application;

    @Column(name = "profile")
    @Enumerated(EnumType.STRING)
    private Profiles profile;

    @Column(name = "label")
    private String label;

    @Column(name = "prop_key")
    private String propKey;

    @Column(name = "prop_value")
    private String propValue;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;
}
