import { useState } from 'react'
import './App.css'
import Hello from "./components/MainPage";

function App() {

  return (
   <>
      <div>
          <Routes>
              <Route path="/" element={<MainPage />} />
              <Route path="/user/register" element={<Register />} />
              <Route path="/products/add-listing" element={<Listings />} />



      </div>
   </>
  )
}

export default App