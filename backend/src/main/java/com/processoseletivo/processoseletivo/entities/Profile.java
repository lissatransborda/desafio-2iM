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
    @Setter
    String name;

    @Column(unique = true)
    @Email
    @Getter
    @Setter
    String email;

    @Column(length = 15, unique = true)
    @Getter
    @Size(max = 15)
    @Setter
    String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    @Getter
    @Setter
    Experience frontendExperience;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    @Getter
    @Setter
    Experience backendExperience;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    @Getter
    @Setter
    Experience databaseExperience;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    @Getter
    @Setter
    Experience camundaExperience;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    @Getter
    @Setter
    Experience healthExperience;

    public enum Experience {
        NENHUMA, INICIANTE, MEDIA, EXPERIENTE, ESPECIALISTA;
    }
}
