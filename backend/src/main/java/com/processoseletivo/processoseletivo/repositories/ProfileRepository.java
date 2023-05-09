package com.processoseletivo.processoseletivo.repositories;

import com.processoseletivo.processoseletivo.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, String> {
    Optional<Profile> findByEmail(String email);
    Optional<Profile> findByPhoneNumber(String phone);
}
