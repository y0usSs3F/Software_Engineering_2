import React from "react";
import { Link, NavLink } from 'react-router-dom';
import "./Header.css";

const SupervisorHeader = () => {

    return (


        <>
        <div className="dashboard">
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div className="container-fluid">
                    <Link className="navbar-brand" to="/supervisor">Supervisor Dashboard</Link>
                </div>
                <ul className="nav nav-tabs justify-content-center" id="logoutTab" role="tablist">
                    <li className="nav-item" role="presentation">
                        <NavLink className="nav-link" id="admin-datawarehouses-tab" to="/" role="tab" aria-controls="admin-datawarehouses">Logout</NavLink>
                    </li>
                </ul>

            </nav>


            
          <div className="content text-center"> 
            <h2>Welcome to Supervisor Dashboard!</h2>
            <br></br>
            <ul className="nav nav-tabs justify-content-center" id="adminTab" role="tablist">
              <li className="nav-item" role="presentation">
                <NavLink className="nav-link" id="supervisor-products-tab" to="/supervisor/products" role="tab" aria-controls="supervisor-products" aria-selected="false">Products</NavLink>
              </li>
              <li className="nav-item" role="presentation">
                <NavLink className="nav-link" id="supervisor-users-tab" to="/supervisor/send_request_to_admin" role="tab" aria-controls="supervisor-users" aria-selected="false">New Request</NavLink>
              </li>
              <li className="nav-item" role="presentation">
                <NavLink className="nav-link" id="supervisor-requests-tab" to="/supervisor/my_requests" role="tab" aria-controls="supervisor-requests" aria-selected="false">My Requests</NavLink>
              </li>
            </ul>
          </div>
        </div>
      </>

    );

};

export default SupervisorHeader;
