package com.processoseletivo.processoseletivo.entities;

import com.processoseletivo.processoseletivo.entities.camunda.ConsultedProcess;
import lombok.Getter;
import lombok.Setter;

public class ProfileResponse {
    @Getter
    @Setter
    ConsultedProcess process;

    @Getter
    @Setter
    Profile profile;

    public ProfileResponse(ConsultedProcess process, Profile profile){
        this.process = process;
        this.profile = profile;
    }
}
