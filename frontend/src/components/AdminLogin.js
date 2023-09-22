import { Outlet, Link } from "react-router-dom";
import { useState } from "react";
import { authenticateAdmin } from "./api";

const AdminLogin=()=>{
     const [userId, setUserId] = useState("");
     const [password, setPassword] = useState("");
      const onUserIdChange = (e) => {
        setUserId(e.target.value);
      };
      const onPasswordChange = (e) => {
        setPassword(e.target.value);
      };
    
      const handleAdminLogin = async (e) => {
        e.preventDefault();
        const credentials={
            userId,
            password
        };
        await authenticateAdmin(credentials);
      };
    return(
        <div>
            <h1>Loan Management Application</h1>
            <h2> Admin Login</h2>
            <form onSubmit={handleAdminLogin}>
                <h4> Enter Admin User Id
                    <input type="text" className="AdminUserId" onChange={onUserIdChange}></input>
                </h4>
                <h4> Enter Admin Password
                    <input type="text" className="AdminPassword" onChange={onPasswordChange}></input>
                </h4>
                <button type="submit">Login</button>
            </form>
        </div>

    )
}

export default AdminLogin;