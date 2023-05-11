import { Link } from "react-router-dom";
import "./styles.css";
import Process from "../../pages/Process/Process";

function Header() {
  function ProcessLink() {
    if (localStorage.getItem("profileId")) {
        return <nav className="header-nav">
        <Link to="/processo" className="header-anchor">Traduzir</Link>
        </nav>
    }

  }
  return (
    <div>
      <header>
        <Link to="/"><strong className="header-title">Processo Seletivo</strong></Link>
        {localStorage.getItem("profileId") &&
          <nav className="header-nav">
            <Link to="/processo" className="header-anchor">Ver candidatura</Link>
          </nav>
         }
      </header>
    </div>
  );
}

export default Header;
