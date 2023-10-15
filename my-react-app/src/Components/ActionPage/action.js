import React, { useState } from 'react';
import { HOME } from "../constants/routes.js";
import './action.css';

function Action() {

  const initialCheckboxes = [
    { id: 1, label: 'CSE 373', checked: false },
    { id: 2, label: 'CSE 414', checked: false },
    { id: 3, label: 'MATH 207', checked: false },
  ];

  const [checkboxes, setCheckboxes] = useState(initialCheckboxes);
  const [isClicked, setIsClicked] = useState(false);

  const handleCheckboxChange = (id) => {
    const updatedCheckboxes = checkboxes.map((checkbox) =>
      checkbox.id === id ? { ...checkbox, checked: !checkbox.checked } : checkbox
    );
    setCheckboxes(updatedCheckboxes);
  };

  const handleAddToCalendar = () => {
    const checkedCheckboxes = checkboxes.filter((checkbox) => checkbox.checked);
    console.log(checkedCheckboxes);
    setIsClicked(true);
  };

  return (
    <section className="container">
      <div className="sync-container">
        <h1>Sync Items from your Canvas!</h1>
        {checkboxes.map((checkbox) => (
          <label key={checkbox.id}>
            <input
              type="checkbox"
              checked={checkbox.checked}
              onChange={() => handleCheckboxChange(checkbox.id)}
            />
            {checkbox.label}
          </label>
        ))}
        <a className="add-to-calendar" onClick={handleAddToCalendar}>
          {isClicked ? 'Success!' : 'Add To Calendar'}
        </a>
      </div>
    </section>

  );
}

export default Action;
