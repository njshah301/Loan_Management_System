import { Outlet, Link } from "react-router-dom";
import { useState } from "react";
import { loan_insert } from "./api";

const LoanInsert=()=>{
     const [loanId, setloanId] = useState("");
     const [LoanType, setLoanType] = useState("");
     const [LoanDuration, setLoanDuration] = useState("");
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
            loanId,
            LoanType,
            LoanDuration
        };
        await loan_insert(data);
      };
    return(
        <div>
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