import HomeNavigation from './components/HomeNavigation';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import AdminLogin from './components/AdminLogin';
import UserLogin from './components/UserLogin';

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
