import { useState } from 'react'
import { Button, Dropdown } from 'react-bootstrap';
// Trong file index.js
// import 'bootstrap/dist/css/bootstrap.min.css';
function MatHang({ onChange, ten_mat_hang, gia_san_pham, link_san_pham, limit }) {
    const SuKienClick = (link_san_pham) => {
        window.location.href = link_san_pham;
    }

    const [count, setCount] = useState(0)
    const decreaseCount = () => {
        if (count > 0) {
            setCount(count - 1)
        }
        onChange({ 'ten_mat_hang': ten_mat_hang, 'so_luong': count });

    }

    const increaseCount = (limit) => {
        if (count < limit) {
            setCount(count + 1)
        }
        onChange({ 'ten_mat_hang': ten_mat_hang, 'so_luong': count });

    }
    const createSoLuong = (limit) => {
        let soLuong = [];

        for (var i = 1; i <= limit; i++) {
            soLuong.push(i);
        }
        return soLuong
    }
    return (
        <div>
            <p>{ten_mat_hang}</p>
            <p>Giá: {gia_san_pham}</p>
            <p >Số lượng: {count}</p>
            <Dropdown>
                <Dropdown.Toggle variant="success" id="dropdown-basic">
                    Số lượng
                </Dropdown.Toggle>

                <Dropdown.Menu>
                    <div>
                        {
                            createSoLuong(limit).map((i) => {
                                return <Dropdown.Item>{i}</Dropdown.Item>
                            })

                        }
                    </div>
                </Dropdown.Menu>
            </Dropdown>
            <Button onClick={() => { SuKienClick(link_san_pham) }}>Click</Button>
        </div>
    )
}

export default MatHang;