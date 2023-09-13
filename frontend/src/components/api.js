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

export {authenticateAdmin,loan_insert,loan_data,loan_delete};
