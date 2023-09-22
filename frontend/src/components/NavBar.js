const NavBar = (props) => {
  var insert_link=`/${props.compo}_insert`
  var display_link=`/${props.compo}_display`
  return (
    <nav className="navbar">
      <div className="container">
        {/* <a href="#">
          MyCompany Inc
        </a> */}
        <ul className="navbar-nav">
          <li className="nav-item">
            <a href={insert_link} className="nav-link">
              Add {props.compo}
            </a>
          </li>
          <li className="nav-item">
            <a href={display_link} className="nav-link">
            {props.compo} List 
            </a>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default NavBar;