package com.processoseletivo.processoseletivo.entities.camunda;

import com.processoseletivo.processoseletivo.entities.Profile;

public class ProcessRequest{
    public String businessKey;
    public Variables variables;

    public static class BackendExperience{
        public String value;
        public String type = "string";

        public BackendExperience(Profile.Experience backendExperience) {
            this.value = String.valueOf(backendExperience);
        }
    }

    public static class DatabaseExperience{
        public String value;
        public String type = "string";

        public DatabaseExperience(Profile.Experience databaseExperience) {
            this.value = String.valueOf(databaseExperience);
        }
    }

    public static class Email{
        public String value;
        public String type = "string";

        public Email(String email){
            this.value = email;
        }
    }

    public static class FrontendExperience{
        public String value;
        public String type = "string";

        public FrontendExperience(Profile.Experience frontendExperience) {
            this.value = String.valueOf(frontendExperience);
        }
    }

    public static class HealthExperience{
        public String value;
        public String type = "string";


        public HealthExperience(Profile.Experience healthExperience) {
            this.value = String.valueOf(healthExperience);
        }
    }

    public static class CamundaExperience {
        public String value;

        public String type = "string";

        public CamundaExperience(Profile.Experience experience) {
            this.value = String.valueOf(experience);
        }
    }

    public static class Name{
        public String value;
        public String type = "string";

        public Name(String name){
            this.value = name;
        }
    }

    public static class PhoneNumber{
        public String value;
        public String type = "string";
        public PhoneNumber(String phoneNumber){
            this.value = phoneNumber;
        }
    }


    public static class Variables{
        public Name name;

        public Email email;

        public PhoneNumber phoneNumber;

        public FrontendExperience frontendExperience;

        public BackendExperience backendExperience;

        public DatabaseExperience databaseExperience;

        public CamundaExperience camundaExperience;

        public HealthExperience healthExperience;

        public Variables(Name name, Email email, PhoneNumber phoneNumber, FrontendExperience frontendExperience, BackendExperience backendExperience, DatabaseExperience databaseExperience, CamundaExperience camundaExperience, HealthExperience healthExperience){
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.frontendExperience = frontendExperience;
            this.backendExperience = backendExperience;
            this.databaseExperience = databaseExperience;
            this.camundaExperience = camundaExperience;
            this.healthExperience = healthExperience;
        }
    }

    public ProcessRequest(String businessKey, Variables variables){
        this.businessKey = businessKey;
        this.variables = variables;
    }
}
