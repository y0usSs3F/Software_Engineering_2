import React from 'react';
import AdminHeader from '../../header/Admin';
import Footer from '../../footer/Footer';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import DataWarehouses from './DataWarehouses';
import List_Supervisors from './List_Supervisors';
import List_requests_from_supervisors from './List_requests_from_supervisors'; // Import the Requests component

function AdminDashboard() {
  return (

    <>

    <AdminHeader />

    <Routes> {/* Use Routes instead of Route */}
        <Route path="/" element={<div className="dashboard">You are on <h3>/admin</h3> endpoint</div>} /> {/* Define the root route */}
        <Route path="datawarehouses" element={<DataWarehouses />} /> {/* Nested route for datawarehouses */}
        {/* Add other nested routes here */}
        <Route path="manage_supervisors" element={<List_Supervisors />} />
        <Route path="requests" element={<List_requests_from_supervisors />} />
    </Routes>

    <Footer />

    </>

  );
}

export default AdminDashboard;
