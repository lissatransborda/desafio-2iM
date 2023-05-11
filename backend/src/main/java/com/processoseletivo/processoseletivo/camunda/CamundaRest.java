package com.processoseletivo.processoseletivo.camunda;

import com.google.gson.Gson;
import com.processoseletivo.processoseletivo.entities.Profile;
import com.processoseletivo.processoseletivo.entities.camunda.ConsultedProcess;
import com.processoseletivo.processoseletivo.entities.camunda.ProcessRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Component
public class CamundaRest {
    @Value("${camunda.url}")
    private String camundaUrl;

    private final Gson gson = new Gson();

    private final RestTemplate restTemplate = new RestTemplateBuilder().
            setConnectTimeout(Duration.ofSeconds(20))
            .setReadTimeout(Duration.ofSeconds(20))
            .build();

    public ConsultedProcess startProcess(ProcessRequest processRequest){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String json = gson.toJson(processRequest);
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        try{
            String responseJson = restTemplate.postForObject(camundaUrl + "/process-definition/key/ProcessoSeletivo/start", request, String.class);
            return gson.fromJson(responseJson, ConsultedProcess.class);
        }catch (HttpClientErrorException e){
            return null;
        }
    }
    public ConsultedProcess getProcess(String id) {
        try{
            String url = camundaUrl + "/process-instance/" + id;
            return restTemplate.getForObject(url, ConsultedProcess.class);
        }catch(final HttpClientErrorException e){
            return null;
        }
    }

    public ProcessRequest profileToProcessRequest(Profile profile){

        ProcessRequest.Email email = new ProcessRequest.Email(profile.getEmail());
        ProcessRequest.Name name = new ProcessRequest.Name(profile.getName());
        ProcessRequest.PhoneNumber phoneNumber = new ProcessRequest.PhoneNumber(profile.getPhoneNumber());
        ProcessRequest.FrontendExperience frontendExperience = new ProcessRequest.FrontendExperience(profile.getFrontendExperience());
        ProcessRequest.BackendExperience backendExperience = new ProcessRequest.BackendExperience(profile.getBackendExperience());
        ProcessRequest.DatabaseExperience databaseExperience = new ProcessRequest.DatabaseExperience(profile.getDatabaseExperience());
        ProcessRequest.CamundaExperience camundaExperience = new ProcessRequest.CamundaExperience(profile.getCamundaExperience());
        ProcessRequest.HealthExperience healthExperience = new ProcessRequest.HealthExperience(profile.getHealthExperience());

        ProcessRequest.Variables variables = new ProcessRequest.Variables(name, email, phoneNumber, frontendExperience, backendExperience, databaseExperience, camundaExperience, healthExperience);

        return new ProcessRequest(profile.getBusinessKey(), variables);
    }
}
