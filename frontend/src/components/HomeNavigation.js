import AdminLogin from "./AdminLogin";
import UserLogin from "./UserLogin";
import { Outlet, Link } from "react-router-dom";
const HomeNavigation=()=>{
    return( 
        <div className="HomeNavigation">
            <h1> Loan Management Application</h1>
            <br></br>
            <Link to="/login_admin">
                <button>Admin Portal</button>
            </Link>
            <Link to="/login_user">
                <button>User Portal</button>
            </Link>
            {/* <Outlet/>  */}
        </div>
    )
}

export default HomeNavigation;