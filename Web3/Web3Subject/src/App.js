import React from 'react';
import { HomePage } from './page/HomePage.js'
import { DocPage } from './page/DocPage.js'
import { LoginPage } from './page/LoginPage.js'
import { Navbar, Nav, Container, Carousel } from 'react-bootstrap'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"
import './App.css'
const App = () => {

	return (
		<Router>
			<Navbar bg="dark" variant="dark" expand="lg">
				<Container>
					<Navbar.Brand href="home">Trang chủ</Navbar.Brand>
					<Navbar.Toggle aria-controls="basic-navbar-nav" />
					<Navbar.Collapse id="basic-navbar-nav">
						<Nav className="me-auto">
							<Nav.Link href="doc">Tài liệu học tập</Nav.Link>
							<Nav.Link href="login">Đăng nhập</Nav.Link>
							<Nav.Link href="xxxxxx">XXXXXX</Nav.Link>
						</Nav>
					</Navbar.Collapse>
				</Container>
			</Navbar>

			
			<Routes>
				<Route path="/" element={<HomePage />} />
				<Route path="/home" element={<HomePage />} />
				<Route path="/doc" element={<DocPage />} />
				<Route path="/login" element={<LoginPage />} />
			</Routes>
		</Router>

	);
}

export default App;