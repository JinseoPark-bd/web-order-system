import logo from './logo.svg';
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Login from './Login'
import './App.css';

function App2() {
    const [data, setData] = useState([])

    useEffect(() => {
        axios.get('/home')
        .then(res => setData(res.data))
        .catch(err => console.log(err))
    }, []);

    return (
        <div className="App">
            <header className="App-header ">
                <img src={logo} className="App-logo" alt="logo" />
                <p>
                    Edit <code>src/App.ks</code> and save to reload.
                </p>
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Learn React
                </a>
                    <ul className="text-blue-600">
                        {data.map((v,idx)=><li key={`${idx}-${v}`}>{v}</li>)}
                    </ul>
            </header>
        </div>
    );
}

export default App2;
