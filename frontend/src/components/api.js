import axios from "axios";

const authenticateAdmin = async (credentials) => {
  const response = await axios.post(
    "http://localhost:8080/api/adminlogin",
    credentials
  );
};

const loan_insert = async (data) => {
  const response = await axios.post(
    "http://localhost:8080/api/loan_insert",
    data
  );
};

export {authenticateAdmin,loan_insert};
