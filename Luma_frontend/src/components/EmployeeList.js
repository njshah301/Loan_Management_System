import { useEffect, useState } from "react";
import { deleteUser, getAll } from "./api";
import { Link, useNavigate } from "react-router-dom";
import CustomButton from "./customButton";
import EditEmployeeData from "./EditEmployeeData";
import Popup from "reactjs-popup";
import { Navigate } from "react-router-dom";
const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);
  const [box, setBox] = useState(false);
  const [empId, setEmpId] = useState("");
  let navigate = useNavigate();
  // function  handleEditClick(){
  //   let path=`/editemployee/${employee.id}`;
  //   navigate(path)
  // }

   async function  handleDelete(id){
    let res=await deleteUser(id);
    console.log('user deleted successfully');
  }
  useEffect(() => {
    return async () => {
      const response = await getAll();

      // const response = [{ "id": 2151219, "name": "Bhavesh", "gender": "M", "age": 35, "salary": 3000, "email": "bhavesh@gmail.com", "doj": "23-08-2098", "mobile": 9521221162 },
      // { "id": 2151219, "name": "Anshul", "gender": "M", "age": 35, "salary": 3000, "email": "bhavesh@gmail.com", "doj": "23-08-2098", "mobile": 9521221162 },
      // { "id": 2151219, "name": "Rah8ul", "gender": "M", "age": 35, "salary": 3000, "email": "bhavesh@gmail.com", "doj": "23-08-2098", "mobile": 9521221162 }]
      setEmployees(response);
       console.log("This is from useEffect", response);
    };
  }, [employees]);
  
  return (
    <div className="container">
      <h3 className="text-secondary">Employee List</h3>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Emp Id</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Date Of Birth</th>
            <th>Date Of Joining</th>
            <th>Department</th>
            <th>Designation</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (

            <tr key={employee.id}>
              <td>{employee.empId}</td>
              <td>{employee.name}</td>
              <td>{employee.gender}</td>
              <td>{employee.birthdate}</td>
              <td>{employee.joiningdate}</td>
              <td>{employee.department}</td>
              <td>{employee.designation}</td>
              <td><button
                onClick={()=>{
                  let id=employee.id;
                  let path=`/editemployee/${employee.id}`;
                  navigate(path)
                }} >
                Edit
              </button>
              <br></br><button onClick={()=>handleDelete(employee.id)} >Delete</button></td>
               
              </tr>
            
           
          ))}
      </tbody>
    </table>
    </div >
  );
};

export default EmployeeList;
