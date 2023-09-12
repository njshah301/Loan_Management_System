import "bootstrap/dist/css/bootstrap.min.css";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import EmployeeList from "./components/EmployeeList";
import AddEmployee from "./components/AddEmployee";
import RootLayout from "./components/RootLayout";
import AdminAndUser from "./components/AdminAndUser";
import Admin from "./components/Admin";
import User from "./components/User";
import EditEmployeeData from "./components/EditEmployeeData";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    children: [
      {path:"/",element:<AdminAndUser/>},
      {path:"/admin",element:<Admin/>},
      {path:"/user",element:<User/>},
      {path:"/editemployee/:employeeId",element:<EditEmployeeData/>},
      { path: "/employeelist", element: <EmployeeList /> },
      { path: "/add", element: <AddEmployee /> },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
