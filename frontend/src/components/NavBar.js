const NavBar = () => {
    return (
      <nav className="navbar">
        <div className="container">
          {/* <a href="#">
            MyCompany Inc
          </a> */}
          <ul className="navbar-nav">
            <li className="nav-item">
              <a href="/loan_display" className="nav-link">
               Loan Card List
              </a>
            </li>
            <li className="nav-item">
              <a href="/loan_insert" className="nav-link">
                Add Loan
              </a>
            </li>
          </ul>
        </div>
      </nav>
    );
  };
  
  export default NavBar;