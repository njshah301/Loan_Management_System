import "./AddEmployee.css";
import { useState } from "react";
import { addEmployee } from "./api";
import { useNavigate } from "react-router-dom";


const AddEmployee = () => {
  const [name, setName] = useState("");
  const [gender, setGender] = useState("");
  const [birthdate, setBirthDate] = useState("");
  const [joiningdate, setJoiningDate] = useState("");
  const [empId, setEmpId] = useState("");
  const [department, setDepartment] = useState("");
  const [designation, setDesignation] = useState("");

  const onNameChange = (e) => {
    setName(e.target.value);
  };
  const onGenderChange = (e) => {
    setGender(e.target.value);
  };
  const onBirthDateChange = (e) => {
    setBirthDate(e.target.value);
  };
  const onJoiningDateChange = (e) => {
    setJoiningDate(e.target.value);
  };
  const onEmpIdChange = (e) => {
    setEmpId(e.target.value);
  };
  function onDepartmentChange(e) {
    setDepartment(e.target.value);
  }
  function onDesignationChange(e) {
    setDesignation(e.target.value);
  }
  const navigate = useNavigate();
  const handleAddEmployee = async (e) => {
    e.preventDefault();
    const employee = {
      empId,
      name,
      gender,
      birthdate,
      joiningdate,
      department,
     designation
     
    };
    console.log("messbirthdate for employee",employee);
    await addEmployee(employee);
    navigate(`/employeelist`)
  };

  

  return (
    <div className="container">
      <h3 className="text-primary">Add Employee</h3>
      <form className="col-4" onSubmit={handleAddEmployee}>
      <div className="form-group">
          <label className="form-label">Emp Id</label>
          <input
            type="empId"
            className="form-control"
            onChange={onEmpIdChange}
          />
        </div>
        <div className="form-group">
          <label className="form-label">Name</label>
          <input type="text" className="form-control" onChange={onNameChange} />
        </div>
        <div className="form-group">
          <label className="form-label">Gender</label>
          &nbsp;&nbsp;
          <div className="form-check-inline">
            <input
              type="radio"
              className="form-check-input"
              name="gender"
              value="Male"
              onChange={onGenderChange}
            />
            <label className="form-check-label">Male</label>
          </div>
          &nbsp;&nbsp;
          <div className="form-check-inline">
            <input
              type="radio"
              className="form-check-input"
              name="gender"
              value="Female"
              onChange={onGenderChange}
            />
            <label className="form-check-label">Female</label>
          </div>
          &nbsp;&nbsp;
          <div className="form-check-inline">
            <input
              type="radio"
              className="form-check-input"
              name="gender"
              value="Other"
              onChange={onGenderChange}
            />
            <label className="form-check-label">Other</label>
          </div>
        </div>
        <div className="form-group">
          <label className="form-label">Date Of Birth</label>
          <input type="Date" className="form-control" onChange={onBirthDateChange} />
        </div>
        <div className="form-group">
          <label className="form-label">Date Of Joining</label>
          <input
            type="Date"
            className="form-control"
            onChange={onJoiningDateChange}
          />
        </div>
        <div className="form-group">
          <label className="form-label">Department</label>
          <input type="text" className="form-control" onChange={onDepartmentChange} />
        </div>
        <div className="form-group">
          <label className="form-label">Designation</label>
          <input
            type="text"
            className="form-control"
            onChange={onDesignationChange}
          />
        </div>
        <br />
        <button className="btn btn-primary">Add Employee</button>
      </form>
    </div>
  );
};

export default AddEmployee;
