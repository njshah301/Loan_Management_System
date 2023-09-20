import { Outlet, Link } from "react-router-dom";
import { useState } from "react";
import { loan_insert } from "./api";
import NavBar from "./NavBar";
import { Navigate, useNavigate } from "react-router-dom";

const LoanInsert=()=>{
     const navigate=useNavigate();
     const [loan_id, setloanId] = useState("");
     const [loan_type, setLoanType] = useState("");
     const [duration, setLoanDuration] = useState();
      const onLoanIdChange = (e) => {
        setloanId(e.target.value);
      };
      const onLoanTypeChange = (e) => {
        setLoanType(e.target.value);
      };
      const onDurationChange = (e) => {
        setLoanDuration(e.target.value);
      };
    
      const handleLoanInsert = async (e) => {
        e.preventDefault();
        const data={
            loan_id,
            loan_type,
            duration
        };
        console.log(data);
        await loan_insert(data);
        navigate('/loan_display');
      }
    return(
        <div>
            <NavBar/>
            <h1>Loan Management Application</h1>
            <h2> Loan Cards Master Data Details</h2>
            <form onSubmit={handleLoanInsert}>
                <h4> Loan Id
                    <input type="text" className="LoanId" onChange={onLoanIdChange}></input>
                </h4>
                <h4> Loan Type
                <select className="LoanType" onChange={onLoanTypeChange}>
                    <option value="furniture">Furniture</option>
                    <option value="stationary">Stationary</option>
                    <option value="crockery">Crockery</option>
                </select>
                </h4>
                <h4> Duration
                    <input type="number" className="LoanDuration" onChange={onDurationChange}></input>
                </h4>
                <button type="submit">Add Data</button>
            </form>
        </div>
    )
}

export default LoanInsert;