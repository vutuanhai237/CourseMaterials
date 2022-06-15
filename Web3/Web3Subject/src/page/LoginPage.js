import React, { useState } from "react";
import {Form, Button } from 'react-bootstrap'
import './LoginPage.css'
import md5 from 'md5'

export const LoginPage = () => {
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    
    
   

    const loginSubmit = (e) => {
        console.log(email)
        console.log(password)
        let hash = md5(email + password)
        console.log(hash)
    };

    return (
        <div className="Login-Page">
            <h1>Đăng nhập</h1>
            <Form>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control onChange={(event) => setEmail(event.target.value)} type="email" placeholder="Enter email" />
                    <Form.Text className="text-muted">
                        We'll never share your email with anyone else.
                    </Form.Text>
                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control onChange={(event) => setPassword(event.target.value)} type="password" placeholder="Password" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicCheckbox">
                    <Form.Check type="checkbox" label="Check me out" />
                </Form.Group>
                <Button variant="primary" onClick={loginSubmit}>
                    Đăng nhập
                </Button>
            </Form>
     
        </div>
    );
}
