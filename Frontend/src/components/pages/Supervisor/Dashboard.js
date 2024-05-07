import React from 'react';
import { Link } from 'react-router-dom';
import SupervisorHeader from '../../header/Supervisor';
import Footer from '../../footer/Footer';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import List_my_requests from './List_my_requests';
import List_products from './List_products';
import Send_new_request_to_admin from './Send_new_request_to_admin'; // Import the Requests component



function SupervisorDashboard() {
  return (

    <>

    <SupervisorHeader />

    <Routes> {/* Use Routes instead of Route */}
        <Route path="/" element={<div className="dashboard">You are on <h3>/supervisor</h3> endpoint</div>} /> {/* Define the root route */}
        <Route path="products" element={<List_products />} /> {/* Nested route for datawarehouses */}
        {/* Add other nested routes here */}
        <Route path="my_requests" element={<List_my_requests />} />
        <Route path="send_request_to_admin" element={<Send_new_request_to_admin />} />
    </Routes>

    <Footer />

    </>
    
  );
}

export default SupervisorDashboard;
