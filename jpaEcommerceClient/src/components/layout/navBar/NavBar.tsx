import { Link } from 'react-router-dom';
import './navBar.css';

const categories = ["vehicles", "clothes"]

function NavBar() {

    return (
        <nav className='NavBar'>
            <div className='NavBarContent'>
                <div className='catTitleWrapper'>
                    <Link to={"/"}  className='catTitle'>Home</Link>
                </div>
                <div className='d-flex'>
                    {/* <div className='catTitleWrapper'>
                        <h4  className='catTitle'>Categories</h4>
                        {
                            <ul className='arrow'>
                                {categories.map((c, i) => (
                                    <li key={i}>
                                        <Link to={""}>{c}</Link>
                                    </li>
                                ))}
                            </ul>
                        }
                    </div> */}
                    <div className='catTitleWrapper'>
                        {/* <Link to={"/login"}  className='catTitle'>Login</Link>  */}
                    </div>
                    <div className='catTitleWrapper'>
                        <h4  className='catTitle'>Config</h4>
                        { 
                            <ul className='arrow'> 
                                <li>
                                    <Link to={"product/create"}>Create Product</Link>
                                </li>
                                {/* <li>
                                    <Link to={"category/create"}>Create Category</Link>
                                </li>
                                <li>
                                    <Link to={"filter/create"}>Create Filter</Link>
                                </li> */}
                            </ul>
                        }
                    </div>
                </div>
            </div>
        </nav>
    );
}

export default NavBar;