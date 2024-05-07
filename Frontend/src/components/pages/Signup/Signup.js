import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Signup.css'

function SignUp() {
    const [fullName, setFullName] = useState('');
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleSignup = (event) => {

        event.preventDefault();
        // I'm coming to your server with new credentials to sign me up:)
        console.log(fullName, username, email, password);
        console.log("User Registered Successfully!");

    };


    const navigateLogin = () => {
        navigate('/');
      }

    return (
        <div className="wrapper d-flex align-items-center">
            <div className="container">
                <h1>Sign Up</h1>
                <form className="needs-validation was-validated" onSubmit={handleSignup} encType="multipart/form-data">
                    <div className="mt-3 mb-3">
                        <label htmlFor="fullname" className="form-label">First Name:</label>
                        <input
                            type="text"
                            className="form-control"
                            id="fullname"
                            placeholder="Full Name"
                            name="fullname"
                            value={fullName}
                            onChange={(e) => setFullName(e.target.value)}
                            required
                        />
                        <div className="valid-feedback">Looks good!</div>
                        <div className="invalid-feedback">Please choose a First name.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="username" className="form-label">Last Name:</label>
                        <input
                            type="text"
                            className="form-control"
                            id="username"
                            placeholder="Username"
                            name="username"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            required
                        />
                        <div className="valid-feedback">Looks good!</div>
                        <div className="invalid-feedback">Please choose a Last Name.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="email" className="form-label">Email:</label>
                        <input
                            type="email"
                            className="form-control"
                            id="email"
                            placeholder="Email"
                            name="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                        <div className="valid-feedback">Looks good!</div>
                        <div className="invalid-feedback">Please choose an email.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="password" className="form-label">Password:</label>
                        <input
                            type="password"
                            className="form-control"
                            id="password"
                            placeholder="Password"
                            name="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                        <div className="valid-feedback">Looks good!</div>
                        <div className="invalid-feedback">Please choose a password.</div>
                    </div>

                    <button type="submit" className="btn btn-primary">Sign Up</button>

                    <br></br>
                    <br></br>

                    {/* <a href="../signin/signin.html" type="button" className="btn btn-link">I have an account.</a> */}
                    <button type="button" className="btn btn-primary" onClick={navigateLogin}>I have an account.</button>
                </form>
            </div>
        </div>
    );
}

export default SignUp;
