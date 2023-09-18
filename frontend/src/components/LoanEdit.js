import { useEffect, useState } from "react";
import { loan_data,loan_delete,loan_data_by_id,loan_edit } from "./api";
import { Navigate, useNavigate } from "react-router-dom";
import { useLocation } from "react-router-dom";

const LoanEdit = () => {
  const navigate=useNavigate();
  const location=useLocation();
  const [loan_id, setLoan_id] = useState(location.state.Id);
  const [loan_type,setLoan_type] = useState('');
  const [duration,setDuration] = useState('');
  useEffect(() => {
    return async () => {
      const response= await loan_data_by_id(loan_id);
      setLoan_type(response.loan_type);
      setDuration(response.duration);
    };
  }, []);

  const onLoanIdChange = (e) => {
    setLoan_id(e.target.value);
  };
  const onLoanTypeChange = (e) => {
    setLoan_type(e.target.value);
  };
  const onDurationChange = (e) => {
    setDuration(e.target.value);
  };

   // e.preventDefault();

  const handleLoanEdit = async (e) => {
    e.preventDefault();
    const data={
        loan_type,
        duration
    };
    console.log(data);
    await loan_edit(loan_id,data);
    navigate('/loan_display');
  }



  return(
    <div>
        {/* <NavBar/> */}
        <h1>Loan Management Application</h1>
        <h2> Loan Cards Master Data Details</h2>
        <form onSubmit={handleLoanEdit}>
            <h4> Loan Id
                <input type="text" value={loan_id} className="LoanId" onChange={onLoanIdChange} disabled></input>
            </h4>
            <h4> Loan Type
            <select className="LoanType" onChange={onLoanTypeChange} required>
                <option value="">--Select Loan type--</option>
                <option value="furniture">Furniture</option>
                <option value="stationary">Stationary</option>
                <option value="crockery">Crockery</option>
            </select>
            </h4>
            <h4> Duration
                <input type="number"  value={duration} className="LoanDuration" onChange={onDurationChange} required></input>
            </h4>
            <button type="submit">Edit Data</button>
        </form>
    </div>
)
};
export default LoanEdit;