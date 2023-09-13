import React, { useState, useEffect, Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import { Routes, Route, useNavigate, useParams } from "react-router-dom";
import CustomButton from "./customButton";
import { addEmployee, editEmployee } from './api';


const EditEmployeeData = (props) => {
  let navigate = useNavigate();

  function handleCloseClick() {
    let path = `/employeelist`;
    navigate(path);
  }
  let { employeeId } = useParams();
  console.log(employeeId);
  const [name, setname] = useState("");
  const [gender, setgender] = useState("");
  const [department, setdep] = useState("");
  const [designation, setdesignation] = useState("");
  const [DOB, setDOB] = useState(new Date());
  const [DOJ, setDOJ] = useState(new Date());
  const [empID, setID] = useState("");
  const handleIdChange = (value) => {
    setID(value);
  };
  const handleNameChange = (value) => {
    setname(value);
  };
  const handleGenderChange = (value) => {
    setgender(value);
  };
  const handleDepartmentChange = (value) => {
    setdep(value);
  };
  const handleDesignationChange = (value) => {
    setdesignation(value);
  };
  const handleDOBChange = (value) => {
    setDOB(value);
  };
  const handleDOJChange = (value) => {
    setDOJ(value);
  };
  async function handleSubmit(e) {
    e.preventDefault();
    const employee = {
      empId:empID,
      name:name,
      gender:gender,
      department:department,
      designation:designation,
      birthdate:DOB,
      joiningdate:DOJ
    };
    const res = await editEmployee(employee, employeeId);
    console.log("called from editemployeeclass", res);
    handleCloseClick();
  };

  const fetchdata = (empId) => {
    //just add {employeeId} to the final api for fetching data for individual data
    axios.get(`http://localhost:8080/api/employee/${employeeId}`).then((response) => {
      console.log(response.data);
      // var info=JSON.parse(response.data);
      // console.log("the value of emp id is",info)
      // const employee=response.data;
      console.log('the valyue in the empployee is', response.data.empId);
      setID(response.data.empId);
      setname(response.data.name);
      setgender(response.data.gender);
      setdep(response.data.department);
      setdesignation(response.data.designation);
      setDOB(response.data.birthdate);
      setDOJ(response.data.joiningdate);


    }).catch(error => {
      alert(error);
    })
  }
  useEffect(() => {
    fetchdata(props.empId)
  }, []);


  // function handleLogin(e) {
  //   e.preventDefault();
  //   props.toggle();
  // }

  const [validated, setValidated] = useState(false);




  return (
    <div>
      <Form noValidate validated={validated}>
        <Row className="mb-3">
          <Form.Group as={Col} md="6" controlId="validationCustom01">
            <Form.Label>Employee ID</Form.Label>
            <Form.Control
              required
              type="text"
              placeholder="Employee ID"
              value={empID}
              disabled
              onChange={(e) => handleIdChange(e.target.value)}
            />
            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
          </Form.Group>

          <Form.Group as={Col} md="6" controlId="validationCustom01">
            <Form.Label>Employee Name</Form.Label>
            <Form.Control
              required
              type="text"
              placeholder="Employee Name"
              value={name}
              onChange={(e) => handleNameChange(e.target.value)}
            />
            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
          </Form.Group>
        </Row>
        <Row className="mb-3">
          <Form.Group as={Col} md="6" controlId="validationCustom01">
            <Form.Label>Designation</Form.Label>
            <Form.Control
              required
              type="text"
              placeholder="Employee Designation"
              value={designation}
              onChange={(e) => handleDesignationChange(e.target.value)}
            />
            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
          </Form.Group>

          <Form.Group as={Col} md="6" controlId="validationCustom01">
            <Form.Label>Department</Form.Label>
            <Form.Control
              required
              type="text"
              placeholder="Enter your department"
              value={department}
              onChange={(e) => handleDepartmentChange(e.target.value)}
            />
            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
          </Form.Group>
        </Row>
        <Row className="mb-3">
          <Form.Group as={Col} md="6" controlId="validationCustom01">
            <Form.Label>Date of Birth</Form.Label>
            <Form.Control
              required
              type="text"
              placeholder="Enter Date of Birth"
              value={DOB}
              onChange={(e) => handleDOBChange(e.target.value)}
            />
            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
          </Form.Group>

          <Form.Group as={Col} md="6" controlId="validationCustom01">
            <Form.Label>Date of joining</Form.Label>
            <Form.Control
              required
              type="text"
              placeholder="Enter Date of joining"
              value={DOJ}
              onChange={(e) => handleDOJChange(e.target.value)}
            />
            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
          </Form.Group>
        </Row>

        <Row className="mb-3">


          <Form.Group as={Col} md="6" controlId="validationCustom05">
            <Form.Label>Gender</Form.Label>
            <Form.Select
              aria-label="Default select example"
              value={gender}
              required
              onChange={(e) => handleGenderChange(e.target.value)}
            >
              <option value="p">Select gender</option>
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="Other">Other</option>

            </Form.Select>
            <Form.Control.Feedback type="invalid">
              Please select a option.
            </Form.Control.Feedback>
          </Form.Group>
        </Row>
        <CustomButton type="submit" onClick={handleSubmit}>
          Edit
        </CustomButton> &nbsp; &nbsp;
        <CustomButton type="submit" onClick={handleCloseClick}>
          Close
        </CustomButton>
      </Form>
      {/* <p>helo from {empID}</p> */}
    </div>
  );
}

export default EditEmployeeData;
