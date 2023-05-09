package com.processoseletivo.processoseletivo.services;

import com.processoseletivo.processoseletivo.camunda.CamundaRest;
import com.processoseletivo.processoseletivo.entities.ProfileResponse;
import com.processoseletivo.processoseletivo.entities.camunda.ConsultedProcess;
import com.processoseletivo.processoseletivo.entities.camunda.ProcessRequest;
import com.processoseletivo.processoseletivo.entities.Profile;
import com.processoseletivo.processoseletivo.repositories.ProfileRepository;
import com.processoseletivo.processoseletivo.utils.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private CamundaRest camundaRest;
    private final RandomNumber randomNumber = new RandomNumber();

    public String create(Profile profile){
        profile.setBusinessKey(profile.getName().toLowerCase() + randomNumber.get(100, 999));

        ProcessRequest processRequest = camundaRest.profileToProcessRequest(profile);

        ConsultedProcess process = camundaRest.startProcess(processRequest);

        if (process == null){
            return null;
        }

        profile.setCamundaId(process.getId());
        Profile profileCreated = profileRepository.save(profile);
        return profileCreated.getId();

    }

    public ProfileResponse get(String id){
        Optional<Profile> profile = profileRepository.findById(id);
        if (profile.isPresent()){
            ConsultedProcess process = camundaRest.getProcess(profile.get().getCamundaId());

            return new ProfileResponse(process, profile.get());
        }

        return null;
    }

    public Optional<Profile> getByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    public Optional<Profile> getByPhoneNumber(String phone) {
        return profileRepository.findByPhoneNumber(phone);
    }
}
