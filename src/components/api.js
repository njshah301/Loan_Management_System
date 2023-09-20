import axios from "axios";

const authenticateAdmin = async (credentials) => {
  const response = await axios.post(
    "http://localhost:8080/api/adminlogin",
    credentials
  );
};

const loan_insert = async (data) => {
  const response = await axios.post(
    "http://localhost:8080/api/loans",
    data
  );
};

const loan_data = async () => {
    const response = await axios.get(
      "http://localhost:8080/api/loans"
    );
    return response.data;
  };

const loan_delete=async(loan_id)=>{
    console.log(loan_id);
    const response = await axios.delete(
        `http://localhost:8080/api/loans/${loan_id}`
    );
}

const loan_data_by_id = async(loan_id) =>{
    const response = await axios.get(
        `http://localhost:8080/api/loans/${loan_id}`
    );
    return response.data;
}

const loan_edit = async(loan_id,loan) =>{
    const response = await axios.put(
        `http://localhost:8080/api/loans/${loan_id}`,
        loan
    );
}

export {authenticateAdmin,loan_insert,loan_data,loan_delete,loan_data_by_id,loan_edit};
