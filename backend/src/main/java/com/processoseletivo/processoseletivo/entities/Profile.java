package com.processoseletivo.processoseletivo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="PROFILE")
public class Profile {
    @Id
    @Getter
    String id = UUID.randomUUID().toString();

    @Getter
    @Setter
    @Column(unique = true)
    String businessKey;

    @Getter
    @Setter
    @Column(unique = true)
    String camundaId;

    @Column(length = 60)
    @NotBlank
    @Size(max = 60)
    @Pattern(regexp = "^[a-zA-Z0-9.\\-\\/+=@_ ]*$")
    @Getter
    String name;

    @Column(unique = true)
    @Email
    @Getter
    String email;

    @Column(length = 15, unique = true)
    @Getter
    @Size(max = 15)
    String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    @Getter
    Experience frontendExperience;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    @Getter
    Experience backendExperience;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    @Getter
    Experience databaseExperience;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    @Getter
    Experience camundaExperience;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    @Getter
    Experience healthExperience;

    public enum Experience {
        NENHUMA, INICIANTE, MEDIA, EXPERIENTE, ESPECIALISTA;
    }
}
