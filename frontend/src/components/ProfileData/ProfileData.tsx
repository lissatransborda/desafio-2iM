import Profile from "../../entities/Profile";
import profileDataProps from "./profileDataProps";

function ProfileData(props: profileDataProps) {
  return (
    <section className="profileData">
      <div className="profileDataProperty">
        <span className="profileDataItem">Nome: </span>
        <span className="profileDataValue">{props.profile.name}</span>
      </div>

      <div className="profileDataProperty">
        <span className="profileDataItem">Email: </span>
        <span className="profileDataValue">{props.profile.email}</span>
      </div>

      <div className="profileDataProperty">
        <span className="profileDataItem">Telefone: </span>
        <span className="profileDataValue">{props.profile.phoneNumber}</span>
      </div>

      <div className="profileDataProperty">
        <span className="profileDataItem">Experiência em Frontend: </span>
        <span className="profileDataValue">
          {props.profile.frontendExperience}
        </span>
      </div>

      <div className="profileDataProperty">
        <span className="profileDataItem">Experiência em Backend: </span>
        <span className="profileDataValue">
          {props.profile.backendExperience}
        </span>
      </div>

      <div className="profileDataProperty">
        <span className="profileDataItem">Experiência em Banco de dados: </span>
        <span className="profileDataValue">
          {props.profile.databaseExperience}
        </span>
      </div>

      <div className="profileDataProperty">
        <span className="profileDataItem">Experiência em Camunda: </span>
        <span className="profileDataValue">
          {props.profile.camundaExperience}
        </span>
      </div>

      <div className="profileDataProperty">
        <span className="profileDataItem">Experiência em Saúde: </span>
        <span className="profileDataValue">
          {props.profile.healthExperience}
        </span>
      </div>
    </section>
  );
}

export default ProfileData;
