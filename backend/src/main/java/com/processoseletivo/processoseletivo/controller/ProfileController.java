package com.processoseletivo.processoseletivo.controller;

import com.processoseletivo.processoseletivo.entities.Profile;
import com.processoseletivo.processoseletivo.entities.ProfileResponse;
import com.processoseletivo.processoseletivo.services.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Profile profile, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("profile/create");
        }

        Optional<Profile> emailEntry = profileService.getByEmail(profile.getEmail());
        Optional<Profile> phoneEntry = profileService.getByPhoneNumber(profile.getPhoneNumber());

        if (emailEntry.isPresent() || phoneEntry.isPresent()){
            return ResponseEntity.badRequest().body("profile alredy exists");
        }

        String createdProfile = profileService.create(profile);
        if (createdProfile == null){
            return ResponseEntity.internalServerError().body("the server couldn't create the profile");
        }
        return ResponseEntity.created(URI.create("/profile/" + createdProfile)).body(createdProfile);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable String id){
        ProfileResponse profile = profileService.get(id);
        if (profile == null) return ResponseEntity.badRequest().body("profile not found");
        return ResponseEntity.ok(profile);
    }

}
