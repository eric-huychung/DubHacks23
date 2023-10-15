import React from 'react';
import './topbanner.css';

function TopBanner() {
  return (
     <div className="top-banner">
      <div className="logo">
        <img src="https://www.palomar.edu/atrc/wp-content/uploads/sites/3/2017/01/Canvas-Logo.png" alt="Logo" />
      </div>
      <div className="text">
        <p>
          <span style={{ color: 'red' }}>CANVAS</span>Sync
        </p>
      </div>
      <div className="profile">
        <img src="https://cdn-icons-png.flaticon.com/128/3135/3135715.png" alt="Profile" />
      </div>
    </div>
  );
}


export default TopBanner