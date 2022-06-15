import { useEffect } from "react"
import {Carousel } from 'react-bootstrap'
export const HomePage = () => {

    return <div>
        <Carousel fade>
				<Carousel.Item>
					<img
						className="d-block w-100 image-gai"
						src={require('../gaixinh1.jpg')}
						alt="Gái xinh 1"
					/>
					<Carousel.Caption>
						<h3>Gái xinh 1</h3>
						<p>Tên: abc</p>
					</Carousel.Caption>
				</Carousel.Item>
				<Carousel.Item>
					<img
						className="d-block w-100 image-gai"
						src={require('../gaixinh2.jpg')}
						alt="Second slide"
					/>

					<Carousel.Caption>
						<h3>Gái xinh 2</h3>
						<p>Tên: abc</p>
					</Carousel.Caption>
				</Carousel.Item>
				<Carousel.Item>
					<img
						className="d-block w-100 image-gai"
						src={require('../gaixinh3.jpg')}
						alt="Third slide"
					/>

					<Carousel.Caption>
						<h3>Gái xinh 3</h3>
						<p>Tên: abc</p>
					</Carousel.Caption>
				</Carousel.Item>
			</Carousel>
    </div>

}
