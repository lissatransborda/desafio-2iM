import Header from "../../components/Header/Header";
import { Link } from "react-router-dom";
import "./styles.css";

function Home() {
  return (
    <div className="Home">
      <Header />
      <main className="homeMain">
        <h1>Envie sua candidatura!</h1>
        <Link to="/candidatura" className="startApplication">
          Começar
        </Link>
      </main>
    </div>
  );
}

export default Home;
