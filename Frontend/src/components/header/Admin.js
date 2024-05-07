import { NavLink } from 'react-router-dom';

function AdminHeader() {
  return (
    <>
      <div className="dashboard">
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <div className="container-fluid">
            <NavLink className="navbar-brand" to="/admin">Admin Dashboard</NavLink>
          </div>
          <ul className="nav nav-tabs justify-content-center" id="logoutTab" role="tablist">
            <li className="nav-item" role="presentation">
                <NavLink className="nav-link" id="admin-datawarehouses-tab" to="/" role="tab" aria-controls="admin-datawarehouses">Logout</NavLink>
            </li>
          </ul>
        </nav>
        <div className="content text-center"> 
          <h2>Welcome to Admin Dashboard!</h2>
          <br></br>
          <ul className="nav nav-tabs justify-content-center" id="adminTab" role="tablist"> {/* Added justify-content-center class */}
            <li className="nav-item" role="presentation">
              <NavLink className="nav-link" id="admin-datawarehouses-tab" to="/admin/datawarehouses" role="tab" aria-controls="admin-datawarehouses">Datawarehouses</NavLink>
            </li>
            <li className="nav-item" role="presentation">
              <NavLink className="nav-link" id="admin-manage_supervisors-tab" to="/admin/manage_supervisors" role="tab" aria-controls="admin-manage_supervisors">Supervisors</NavLink>
            </li>
            <li className="nav-item" role="presentation">
              <NavLink className="nav-link" id="admin-requests-tab" to="/admin/requests" role="tab" aria-controls="admin-requests">Supervisors' Requests</NavLink>
            </li>
          </ul>
        </div>
      </div>
    </>
  );
}

export default AdminHeader;
