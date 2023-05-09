package com.processoseletivo.processoseletivo.entities.camunda;

import lombok.Getter;
import lombok.Setter;

public class ConsultedProcess {
    @Getter
    @Setter
    String id;

    @Getter
    @Setter
    Links[] links;

    @Getter
    @Setter
    String definitionId;

    @Getter
    @Setter
    String businessKey;

    @Getter
    @Setter
    String caseInstanceId;

    @Getter
    @Setter
    Boolean ended;

    @Getter
    @Setter
    Boolean suspended;

    @Getter
    @Setter
    String tenantId;

    public static class Links {
        @Getter
        @Setter
        String method;

        @Getter
        @Setter
        String href;

        @Getter
        @Setter
        String rel;
    }
}