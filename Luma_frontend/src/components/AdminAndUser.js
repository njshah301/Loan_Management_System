import { Link } from "react-router-dom";

export default function AdminAndUser() {
    return (
        <div class="d-flex  justify-content-around my-3">
            <Link to="/admin" class="card   my-4 rounded-3 shadow-sm border-secondary d-inline-block w-25 h-25 d-flex align-items-center justify-content-center">

                <div class="bg-warning rounded-circle w-75 h-75 text-center my-4 ">
                    <img class="rounded-circle card-img-top mx-auto d-block  " src="adminlogo.png" alt="Card image cap"></img>

                </div>

                <div class="card-body  ">
                    <h3 class="card-title text-center ">Admin </h3>
                </div>


            </Link>
            <Link to="/user" class="card  my-4 rounded-3 shadow-sm border-secondary d-inline-block w-25 h-25 d-flex align-items-center justify-content-center">

                <div class="bg-warning rounded-circle w-75 h-75 text-center my-4 ">
                    <img class="rounded-circle card-img-top mx-auto d-block  " src="users.png" alt="Card image cap"></img>

                </div>

                <div class="card-body  ">
                    <h3 class="card-title text-center ">User </h3>
                </div>


            </Link>
        </div>
    )
}