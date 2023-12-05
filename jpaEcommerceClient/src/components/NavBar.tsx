import {useState} from 'react';

const categories = ["vehicles", "clothes"]

function NavBar() {
    const [showCategories, setShowCategories] = useState(false)
    const [showConfig, setShowConfig] = useState(false)

    return (
        <nav className='navBar'>
            <div>
                <h4 style={{"margin": "0 0.5em"}} onClick={() => setShowCategories(!showCategories)}>Categories</h4>
                {
                    showCategories && 
                    <ul style={{position: "absolute", padding: "0 1.8em"}}>
                        {categories.map((c, i) => <li key={i}>{c}</li>)}
                    </ul>
                }
            </div>
            <h4 style={{"margin": "0 0.5em"}}>Login</h4>
            <h4 style={{"margin": "0 0.5em"}}>Register</h4>
            <div>
                <h4 style={{"margin": "0 0.5em"}} onClick={() => setShowConfig(!showConfig)}>Config</h4>
                {showConfig && <ul style={{position: "absolute", padding: "0 1.8em"}}> <li>Products</li> </ul>}
            </div>
        </nav>
    );
}

export default NavBar;