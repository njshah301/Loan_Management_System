import HomeNavigation from './components/HomeNavigation';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import AdminLogin from './components/AdminLogin';
import UserLogin from './components/UserLogin';
import LoanInsert from './components/LoanInsert';
import LoanDisplay from './components/LoanDisplay';
// const router = createBrowserRouter(
//     // {path:"/",element:<HomeNavigation/>},
//     // // children: [
//     // //   { path: "/login_admin", element: <AdminLogin /> },
//     // //   { path: "/login_user", element: <UserLogin /> },
//     // // ],
//     // {path:"/login_admin",element:<AdminLogin/>},
//     // {path:"/login_user",element:<UserLogin/>}
// );

const router = createBrowserRouter([
  {
    path: "/",
    element: <HomeNavigation />,
    // children: [
    //   { path: "/", element: <AdminLogin /> },
    //   { path: "/add", element: <UserLogin /> },
    // ],
  },
  {
    path:"/login_admin",
    element:<AdminLogin/>,
  },
  {
    path:"/login_user",
    element:<UserLogin/>,
  },
  {
    path:"/loan_insert",
    element:<LoanInsert/>,
  },
  {
    path:"/loan_display",
    element:<LoanDisplay/>,
  }
]);

function App() {
  return (
    <div className="App">
      <RouterProvider router={router} />;
    </div>
  );
}

export default App;
