import { useState, useEffect } from 'react'
import { Button, Form, Navbar, Container, Nav } from 'react-bootstrap';
import { Dropdown, DropdownButton, Row, Col } from 'react-bootstrap';
import './DocPage.css'
export const DocPage = () => {

	const [url, setUrl] = useState(null)
	const [genre, setGenre] = useState('waifu')
	const [type, setType] = useState(true)
	useEffect(() => {
		fetchURL()

	}, [])

	const fetchURL = (type, genre) => {
		var requestOptions = {
			method: 'GET',
			redirect: 'follow'
		};

		let typeValue
		if (type) {
			typeValue = 'sfw'
		} else {
			typeValue = 'nsfw'
		}
		fetch("https://api.waifu.pics/" + typeValue + "/" + genre, requestOptions)
			.then(response => response.json())
			.then(result => {
				console.log(result)
				setUrl(result.url)
			})
			.catch(error => console.log('error', error));
	}

	const onSwitchAction = () => {
		setType(!type);
	};

	const getGenre = () => {
		if (type) {
			return ['waifu', 'neko', 'bully']
		} else {
			return ['waifu', 'neko', 'trap']
		}
	}
	return (
		<div className="DocPage">
			<h1>Tài liệu học tập</h1>
			<img height='300px' src={url} />
			<Form>
				<Form.Check
					type="switch"
					id="custom-switch"
					label={type ? 'sfw' : 'nsfw'}
					onChange={onSwitchAction}
				/>
			</Form>
			<DropdownButton id="dropdown-basic-button" title={genre}>
				{
					getGenre().map(item => {
						return <Dropdown.Item onClick={() => setGenre(item)}>{item}</Dropdown.Item>
					})
				}

			</DropdownButton>

			<Button onClick={() => fetchURL(type, genre)}>Refresh</Button>


		</div>
	);
}
