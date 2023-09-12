import { Link } from "react-router-dom";
const MainNavigation = () => {
  return (
    <nav className="navbar navbar-dark  navbar-expand bg-primary">
      <div className="container">
        <Link href="/" className="navbar-brand">
         BRENS Corp.
        </Link>
        <ul className="navbar-nav">
          <li className="nav-item">
            <Link to="/employeelist" className="nav-link">
              List Employees
            </Link>
          </li>
          <li className="nav-item">
            <Link to="/add" className="nav-link">
              Add Employee
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default MainNavigation;