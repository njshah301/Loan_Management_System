import axios from "axios";
const addEmployee = async (employee) => {
  const response = await axios.post(
    "http://localhost:8080/api/employee",
    employee
  );
};

const getAll = async () => {
  const response = await axios.get("http://localhost:8080/api/employee");
  console.log("This is from get All", response.data);
  return response.data;
};

const loginUser=async(username,password)=>{
  const response=await axios.post("http://localhost:8080/api/auth",{username,password});
  console.log("this from login part",response.data);
  return response.data;
}

const deleteUser=async(id)=>{
  const res=await axios.delete(`http://localhost:8080/api/employee/${id}`);
  console.log("the value after deleting is",res.data);
  return res.data;
}

const editEmployee=async(employee,id)=>{
  // const id=employee.id;
  const res=await axios.put(`http://localhost:8080/api/employee/${id}`,employee);
  console.log("the value was updated successfully",res.data);
}
export { addEmployee, getAll,loginUser,deleteUser,editEmployee};
