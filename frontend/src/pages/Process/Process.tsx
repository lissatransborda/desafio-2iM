import { useEffect, useState } from "react";
import Header from "../../components/Header/Header";
import axios from "axios";
import ProfileResponse from "../../entities/ProfileResponse";

import "./styles.css";
import ProfileData from "../../components/ProfileData/ProfileData";
import { useNavigate } from "react-router-dom";

const BACKEND_URL = process.env.REACT_APP_BACKEND_URL;

function Process() {
  const [profileResponse, setProfileResponse] = useState<ProfileResponse>({
    process: {
      id: "",
      definitionId: "",
      businessKey: "",
      caseInstanceId: "",
      ended: false,
      suspended: false,
      tenantID: "",
    },
    profile: {
      name: "",
      email: "",
      phoneNumber: "",
      frontendExperience: "",
      backendExperience: "",
      databaseExperience: "",
      camundaExperience: "",
      healthExperience: "",
    },
  });

  let navigate = useNavigate();

  async function getProfileResponse() {
    const profileId = localStorage.getItem("profileId");
    if (profileId) {
      try {
        const data = await axios.get(`${BACKEND_URL}/profile/${profileId}`);
        const response: ProfileResponse = data.data;
        setProfileResponse(response);
      } catch (e: any) {
        if (e.code === "ERR_BAD_REQUEST") {
          navigate("/candidatura");
        }
      }
    }else{
      navigate("/");
    }
  }

  useEffect(() => {
    getProfileResponse();
  }, []);

  function ProcessState() {
    if (profileResponse.process.ended) {
      return <h2 className="processState">O processo terminou</h2>;
    } else if (profileResponse.process.suspended) {
      return <h2 className="processState">O processo está suspenso</h2>;
    } else {
      return (
        <h2 className="processState">Aguarde o fim do processo seletivo</h2>
      );
    }
  }

  return (
    <div className="processPage">
      <Header />
      <h1>Olá {profileResponse.profile.name}!</h1>

      <ProcessState />

      <h2>Enquanto isso, veja os dados que você inseriu no processo:</h2>

      <ProfileData profile={profileResponse.profile} />
    </div>
  );
}

export default Process;
