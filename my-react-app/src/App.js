import React from 'react';
import Home from './Components/HomePage/home.js';
import Action from './Components/ActionPage/action.js';
import TopBanner from './Components/Top Banner/topbanner';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';


function App() {
  return (
    <div>
      <TopBanner />
      <Router>
        <div className="App">
          <Routes>
            <Route path="/actionPage" element={<Action />} />
            <Route path="/" element={<Home />} />
          </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;