import { Outlet } from 'react-router-dom'
import './App.css'
import NavBar from './components/layout/navBar/NavBar'

function App() {

  return (
    <>
      <NavBar />
      <Outlet />
    </>
  )
}

export default App
