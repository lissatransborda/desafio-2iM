package com.processoseletivo.processoseletivo.services;

import com.processoseletivo.processoseletivo.camunda.CamundaRest;
import com.processoseletivo.processoseletivo.entities.Profile;
import com.processoseletivo.processoseletivo.entities.ProfileResponse;
import com.processoseletivo.processoseletivo.entities.camunda.ConsultedProcess;
import com.processoseletivo.processoseletivo.entities.camunda.ProcessRequest;
import com.processoseletivo.processoseletivo.repositories.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProfileServiceTest {
    @Mock
    private CamundaRest camundaRestMock;

    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private ProfileService profileService = new ProfileService();

    Profile profileToMock;

    @BeforeEach
    void setUp() {
        profileToMock = new Profile();

        profileToMock.setName("test");
        profileToMock.setEmail("test@email.com");
        profileToMock.setPhoneNumber("5".repeat(13));
        profileToMock.setBusinessKey("test-001");
        profileToMock.setCamundaId(UUID.randomUUID().toString());
        profileToMock.setFrontendExperience(Profile.Experience.MEDIA);
        profileToMock.setBackendExperience(Profile.Experience.MEDIA);
        profileToMock.setDatabaseExperience(Profile.Experience.MEDIA);
        profileToMock.setCamundaExperience(Profile.Experience.MEDIA);
        profileToMock.setHealthExperience(Profile.Experience.MEDIA);
    }

    @Test
    public void testProfileServiceCreate() {
        ProcessRequest profileRequest = camundaRestMock.profileToProcessRequest(profileToMock);

        ConsultedProcess consultedProcess = new ConsultedProcess();

        Mockito.when(camundaRestMock.startProcess(profileRequest)).thenReturn(consultedProcess);
        Mockito.when(profileRepository.save(profileToMock)).thenReturn(profileToMock);

         String profile = profileService.create(profileToMock);

        assertThat(profile.isEmpty());
    }

    @Test
    public void testProfileServiceCreateProcessError(){
        ProcessRequest profileRequest = camundaRestMock.profileToProcessRequest(profileToMock);

        Mockito.when(camundaRestMock.startProcess(profileRequest)).thenReturn(null);

        String profile = profileService.create(profileToMock);

        assertEquals(null, profile);
    }

    @Test
    public void testProfileServiceGet(){

        String profileId = UUID.randomUUID().toString();

        Mockito.when(profileRepository.findById(profileId)).thenReturn(Optional.of(profileToMock));
        Mockito.when(camundaRestMock.getProcess(profileToMock.getCamundaId())).thenReturn(new ConsultedProcess());

        ProfileResponse profile = profileService.get(profileId);

        assertThat(profile.getProfile());
        assertThat(profile.getProcess());
    }

    @Test
    public void testProfileServiceGetReturnNull(){

        String profileId = UUID.randomUUID().toString();

        Mockito.when(profileRepository.findById(profileId)).thenReturn(Optional.ofNullable(null));

        ProfileResponse profile = profileService.get(profileId);

        assertEquals(null, profile);
    }

    @Test
    public void testProfileServiceFindByEmail(){

        Mockito.when(profileRepository.findByEmail(profileToMock.getEmail())).thenReturn(Optional.of(profileToMock));

        Optional<Profile> profile = profileService.getByEmail(profileToMock.getEmail());

        assertThat(profile);
    }

    @Test
    public void testProfileServiceFindByEmailReturnNull(){

        Mockito.when(profileRepository.findByEmail(profileToMock.getEmail())).thenReturn(Optional.ofNullable(null));

        Optional<Profile> profile = profileService.getByEmail(profileToMock.getEmail());

        assertEquals(Optional.empty(), profile);
    }
}
