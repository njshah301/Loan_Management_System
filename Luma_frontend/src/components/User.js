import { useState } from "react";
export default function User() {
    const [name, setName] = useState("");
    const [gender, setGender] = useState("");
    const [age, setAge] = useState("");
    const [salary, setSalary] = useState("");
    const [email, setEmail] = useState("");
    const [doj, setDoj] = useState("");
    const [mobile, setMobile] = useState("");

    const onNameChange = (e) => {
        setName(e.target.value);
    };
    const onGenderChange = (e) => {
        setGender(e.target.value);
    };
    const onAgeChange = (e) => {
        setAge(e.target.value);
    };
    const onSalaryChange = (e) => {
        setSalary(e.target.value);
    };
    const onEmailChange = (e) => {
        setEmail(e.target.value);
    };
    const onDojChange = (e) => {
        setDoj(e.target.value);
    };
    function onMobileChange(e) {
        setMobile(e.target.value);
    }

    const handleAddEmployee = async (e) => {
        e.preventDefault();
        const employee = {
            name,
            gender,
            age,
            salary,
            email,
            doj,
            mobile,
        };
        console.log("message for employee", employee);
        // await addEmployee(employee);
    };
    return (
        <div class="container justify-content-around align-items-center  w-50 my-5 h-100">
            <div className="container justify-content-around align-items-center h-100 w-100 my-5">
                <h3 className="text-primary">User</h3>
                <form className="col-4" onSubmit={handleAddEmployee}>
                    <div className="form-group">
                        <label className="form-label">User Name</label>
                        <input type="text" className="form-control border border-dark" onChange={onNameChange} />
                    </div>

                    <div className="form-group">
                        <label className="form-label">Password</label>
                        <input type="password" className="form-control border border-dark " onChange={onAgeChange} />
                    </div>
                    <br />
                    <button className="btn btn-primary">Login</button>
                </form>
            </div>
          
        </div>
    )
};