import { ToastContainer, toast } from "react-toastify";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import { useForm } from "react-hook-form";

import axios from "axios";
import Header from "../../components/Header/Header";
import Profile from "../../entities/Profile";

import "./styles.css";
import "react-toastify/dist/ReactToastify.css";

const BACKEND_URL = process.env.REACT_APP_BACKEND_URL;

function JobApplication() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [frontendExperience, setFrontendExperience] = useState("NENHUMA");
  const [backendExperience, setBackendExperience] = useState("NENHUMA");
  const [databaseExperience, setDatabaseExperience] = useState("NENHUMA");
  const [camundaExperience, setCamundaExperience] = useState("NENHUMA");
  const [healthExperience, setHealthExperience] = useState("NENHUMA");

  let navigate = useNavigate();

  async function sendJobApplication() {
    const profile: Profile = {
      name: name,
      email: email,
      phoneNumber: phoneNumber,
      frontendExperience: frontendExperience,
      backendExperience: backendExperience,
      databaseExperience: databaseExperience,
      camundaExperience: camundaExperience,
      healthExperience: healthExperience,
    };

    try {
      const response = await axios.post(`${BACKEND_URL}/profile`, profile);
      const profileId = response.data;

      localStorage.setItem("profileId", profileId);

      navigate("/processo");
    } catch (e: any) {
      if (e.response.data === "profile alredy exists") {
        toast.error("Perfil já cadastrado", {
          position: toast.POSITION.TOP_CENTER,
        });
      } else if (e.code === "ERR_BAD_REQUEST") {
        toast.error("Formulário com dados incorretos", {
          position: toast.POSITION.TOP_CENTER,
        });
      }
    }
  }

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const onSubmit = () => {
    sendJobApplication()
  }

  return (
    <div className="JobApplication">
      <Header />
      <main className="jobApplicationMain">
        <div className="jobApplicationTitle">
          <h1>Se candidate na vaga!</h1>
        </div>
        <ToastContainer />
        <form onSubmit={handleSubmit(onSubmit)} className="applicationForm">
          <input
            type="text"
            placeholder="name"
            {...register("name", { required: true, maxLength: 60 })}
            value={name}
            onChange={(e) => setName(e.target.value)}
            className="applicationFormInput"
          />
          {errors.name && <span>Preencha este campo corretamente</span>}
          <input
            type="text"
            placeholder="Email"
            {...register("email", { required: true, pattern: /^\S+@\S+$/i })}
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="applicationFormInput"
          />
          {errors.email && <span>Preencha este campo corretamente</span>}
          <input
            type="tel"
            placeholder="phoneNumber"
            {...register("phoneNumber", { required: true, maxLength: 15 })}
            value={phoneNumber}
            onChange={(e) => setPhoneNumber(e.target.value)}
            className="applicationFormInput"
          />
          {errors.phone && <span>Preencha este campo corretamente</span>}
          <div className="experienceLevelDiv">
            <label htmlFor="frontendExperience" className="labelExperienceLevel"><span>Experiência em Frontend</span></label>
            <select
              {...register("frontendExperience")}
              value={frontendExperience}
              onChange={(e) => setFrontendExperience(e.target.value)}
              name="frontendExperience"
            >
              <option value="NENHUMA">NENHUMA</option>
              <option value="INICIANTE">INICIANTE</option>
              <option value="MEDIA">MEDIA</option>
              <option value="EXPERIENTE">EXPERIENTE</option>
              <option value="ESPECIALISTA">ESPECIALISTA</option>
            </select>
          </div>
          <div className="experienceLevelDiv">
            <label htmlFor="backcendExperience" className="labelExperienceLevel"><span>Experiência em Backend</span></label>
            <select
              {...register("backendExperience")}
              value={backendExperience}
              onChange={(e) => setBackendExperience(e.target.value)}
              name="backendExperience"
            >
              <option value="NENHUMA">NENHUMA</option>
              <option value="INICIANTE">INICIANTE</option>
              <option value="MEDIA">MEDIA</option>
              <option value="EXPERIENTE">EXPERIENTE</option>
              <option value="ESPECIALISTA">ESPECIALISTA</option>
            </select>
          </div>
          <div className="experienceLevelDiv">
            <label htmlFor="databaseExperience" className="labelExperienceLevel"><span>Experiência em Banco de dados</span></label>
            <select
              {...register("databaseExperience")}
              value={databaseExperience}
              onChange={(e) => setDatabaseExperience(e.target.value)}
              className="experienceLevelExperience"
              name="databaseExperience"
            >
              <option value="NENHUMA">NENHUMA</option>
              <option value="INICIANTE">INICIANTE</option>
              <option value="MEDIA">MEDIA</option>
              <option value="EXPERIENTE">EXPERIENTE</option>
              <option value="ESPECIALISTA">ESPECIALISTA</option>
            </select>
          </div>
          <div className="experienceLevelDiv">
            <label htmlFor="camundaExperience" className="labelExperienceLevel"><span>Experiência em Camunda</span></label>
            <select
              {...register("camundaExperience")}
              onChange={(e) => setCamundaExperience(e.target.value)}
              className="experienceLevelExperience"
              name="camundaExperience"
            >
              <option value="NENHUMA">NENHUMA</option>
              <option value="INICIANTE">INICIANTE</option>
              <option value="MEDIA">MEDIA</option>
              <option value="EXPERIENTE">EXPERIENTE</option>
              <option value="ESPECIALISTA">ESPECIALISTA</option>
            </select>
          </div>
          <div className="experienceLevelDiv">
            <label htmlFor="healtExperience" className="labelExperienceLevel"><span>Experiência em Saúde</span></label>
            <select
              value={healthExperience}
              onChange={(e) => setHealthExperience(e.target.value)}
              className="experienceLevelExperience"
              name="healtExperience"
            >
              <option value="NENHUMA">NENHUMA</option>
              <option value="INICIANTE">INICIANTE</option>
              <option value="MEDIA">MEDIA</option>
              <option value="EXPERIENTE">EXPERIENTE</option>
              <option value="ESPECIALISTA">ESPECIALISTA</option>
            </select>
          </div>
          <button type="submit" className="jobApplicationButton">
            Enviar
          </button>
        </form>
      </main>
    </div>
  );
}

export default JobApplication;
