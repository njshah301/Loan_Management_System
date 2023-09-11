import axios from "axios";

const authenticateAdmin = async (credentials) => {
  const response = await axios.post(
    "http://localhost:8080/api/adminlogin",
    credentials
  );
};

export {authenticateAdmin };
