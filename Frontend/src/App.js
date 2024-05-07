import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

// Signup
import SignupPanel from './components/pages/Signup/Signup';

// Login
import Login from './components/pages/Login/Login';

// Dashboards
import AdminDashboard from './components/pages/Admin/Dashboard';
import SupervisorDashboard from './components/pages/Supervisor/Dashboard';

// Admin
import DataWarehouses from './components/pages/Admin/DataWarehouses';
import List_Supervisors from './components/pages/Admin/List_Supervisors';
import List_requests_from_supervisors from './components/pages/Admin/List_requests_from_supervisors'; // Import the Requests component

// Supervisor
import List_Products from './components/pages/Supervisor/List_products';
import List_my_requests from './components/pages/Supervisor/List_my_requests';
import Send_new_request_to_admin from './components/pages/Supervisor/Send_new_request_to_admin'; // Import the Requests component

import './App.css';

function App() {
  return (
    <Router>

      <div className="App">

        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/admin/*" element={<AdminDashboard />}>
            {/* Nested routes for admin dashboard */}
            <Route path="datawarehouses" element={<DataWarehouses />} />
            <Route path="manage_supervisors" element={<List_Supervisors />} />
            <Route path="requests" element={<List_requests_from_supervisors />} />
          </Route>
          <Route path="/supervisor/*" element={<SupervisorDashboard />}>
            {/* Nested routes for supervisor dashboard */}
            <Route path="products" element={<List_Products />} />
            <Route path="my_requests" element={<List_my_requests />} />
            <Route path="send_request_to_admin" element={<Send_new_request_to_admin />} />
          </Route>
          <Route path="/signup/*" element={<SignupPanel />}>
          </Route>
        </Routes>
        
      </div>

    </Router>
  );
}

export default App;
