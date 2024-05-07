import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Login.css'

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = () => {

    if (username === 'karim@gmail.com' && password === 'admin') {

      navigate('/admin');

    } else if (true) {

      // I'm coming to your server with non-admin credentials.
      
      navigate('/supervisor');

    }
  };

  const navigateSignup = () => {
    navigate('/signup');
  }

  return (
    <div className="d-flex align-items-center justify-content-center" style={{ minHeight: '100vh' }}>
      <div className="container">
        <div className="">
          <div className="card-body">
            <h1 className="card-title">Sign In</h1>
            <br></br>
            <form className="needs-validation was-validated">
              <div className="mb-3">
                <div className="form-label" style={{ textAlign: 'left' }}>Username:</div>
                <input
                  type="text"
                  className="form-control"
                  id="username"
                  placeholder="Username"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  required
                />
                <div className="valid-feedback">Looks good!</div>
                <div className="invalid-feedback">Please fill in the username.</div>
              </div>
              
              <div className="mb-4">
              <div className="form-label" style={{ textAlign: 'left' }}>Password:</div>
                <input
                  type="password"
                  className="form-control"
                  id="password"
                  placeholder="Password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  required
                />
                <div className="valid-feedback">Looks good!</div>
                <div className="invalid-feedback">Please fill in the password.</div>
              </div>
              
              
              <button type="button" className="btn btn-primary" onClick={handleLogin}>Sign In</button>

              <br></br>
              <br></br>

              <button type="button" className="btn btn-primary" onClick={navigateSignup}>I don't have an account.</button>

              
            </form>
          </div>
        </div>
      </div>    
    </div>
  );
}

export default Login;
