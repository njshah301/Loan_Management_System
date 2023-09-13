import { useEffect, useState } from "react";
import { loan_data,loan_delete } from "./api";

const EmployeeList = () => {
  const [loans, setLoans] = useState([]);

  useEffect(() => {
    return async () => {
      const response = await loan_data();
      setLoans(response);
    //   console.log("This is from useEffect", response);
    };
  }, [loans]);

  const handleLoanDelete = async (loan_id) => {
    // e.preventDefault();
    await loan_delete(loan_id);
  };

  const handleLoanEdit=async()=>{
    console.log("edit");
   // e.preventDefault();
  }



  return (
    <div className="container">
      <h3>Loans List</h3>
      <table>
        <thead>
          <tr>
            <th>Loan Id</th>
            <th>Loan Type</th>
            <th>Loan Duration</th>
          </tr>
        </thead>
        <tbody>
          {loans.map((loan) => (
            <tr key={loan.loan_id}>
              <td>{loan.loan_id}</td>
              <td>{loan.loan_type}</td>
              <td>{loan.duration}</td>
              <td><button onClick={handleLoanEdit}> Edit</button><button onClick={()=>handleLoanDelete(loan.loan_id)}> Delete </button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default EmployeeList;
