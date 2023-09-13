import { useState } from "react";
import { loginUser } from "./api";
export default function User() {
    const [username, setUserName] = useState("");
    const [password,setPassword]=useState("");

    const onUserNameChange = (e) => {
        setUserName(e.target.value);
    };
     const onPasswordChange=(e)=>{
        setPassword(e.target.value);
     }
   

    const handleUserLogin = async (e) => {
        e.preventDefault();
        // const employee = {
        //     username,
        //     password
            
        // };
        console.log("message for employee", username," ",password);
       const res= await loginUser(username,password);
    //    console.log("the value after login is ",res);
        console.log(res.status);
    };
    return (
        <div class="container justify-content-around align-items-center  w-50 my-5 h-100">
            <div className="container justify-content-around align-items-center h-100 w-100 my-5">
                <h3 className="text-primary">User</h3>
                <form className="col-4" onSubmit={handleUserLogin}>
                    <div className="form-group">
                        <label className="form-label">User Name</label>
                        <input type="text" className="form-control border border-dark" onChange={onUserNameChange} />
                    </div>

                    <div className="form-group">
                        <label className="form-label">Password</label>
                        <input type="password" className="form-control border border-dark " onChange={onPasswordChange} />
                    </div>
                    <br />
                    <button className="btn btn-primary">Login</button>
                </form>
            </div>
          
        </div>
    )
};