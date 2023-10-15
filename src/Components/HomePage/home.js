import React from 'react';
import './home.css';

function Home() {
  return (
    <div className="home-container">
      <div className="content">
        <h1>Welcome to Canvas</h1>
        <p>Explore the world of learning.</p>
        <a href="ActionPage" className="sign-in-button">Sign into Canvas</a>
      </div>
    </div>
  );
}

export default Home;