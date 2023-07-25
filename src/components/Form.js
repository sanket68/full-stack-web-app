import React, { useState } from "react";
import "./Form.css";

const Form = () => {
  const [formData, setFormData] = useState({
    id: "",
    name: "",
    email: "",
    yearOfStudy: "1", // Default value for radio button
    contactNumber: "",
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    // Create an object with the form data
    const data = {
      id: (formData.id),
      contact: (formData.contactNumber), // Convert the contactNumber to a Long (integer)
      email: formData.email,
      name: formData.name,
      year: (formData.yearOfStudy), // Year is a character (char)
    };
    // Make a POST request to your API using fetch
    fetch("http://localhost:8080/students/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
         if ((data.status ==="Success")) {
           console.log("Data posted successfully:");
           // If you want to reset the form after submission, uncomment the line below
           setFormData({
             id: "",
             name: "",
             email: "",
             yearOfStudy: "1",
             contactNumber: "",
           });
         } 
         else{
          console.log(data.status);
         }
        
      })
      .catch((error) => {
        console.error("Error posting data:", error);
      });
  };

  return (
    <div className="container form">
      <form className="custom-form" onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="id">ID</label>
          <input
            type="text"
            className="form-control"
            id="id"
            name="id"
            value={formData.id}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="name">Name</label>
          <input
            type="text"
            className="form-control"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input
            type="email"
            className="form-control"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Year of Study</label>
          <div className="form-check">
            <input
              type="radio"
              className="form-check-input"
              id="year1"
              name="yearOfStudy"
              value="1"
              checked={formData.yearOfStudy === "1"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="year1">
              First Year
            </label>
          </div>
          <div className="form-check">
            <input
              type="radio"
              className="form-check-input"
              id="year2"
              name="yearOfStudy"
              value="2"
              checked={formData.yearOfStudy === "2"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="year2">
              Second Year
            </label>
          </div>
          <div className="form-check">
            <input
              type="radio"
              className="form-check-input"
              id="year3"
              name="yearOfStudy"
              value="3"
              checked={formData.yearOfStudy === "3"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="year3">
              Third Year
            </label>
          </div>
          <div className="form-check">
            <input
              type="radio"
              className="form-check-input"
              id="year4"
              name="yearOfStudy"
              value="4"
              checked={formData.yearOfStudy === "4"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="year4">
              Final Year
            </label>
          </div>
        </div>
        <div className="form-group">
          <label htmlFor="contactNumber">Contact Number</label>
          <input
            type="tel"
            className="form-control"
            id="contactNumber"
            name="contactNumber"
            value={formData.contactNumber}
            onChange={handleChange}
            required
          />
        </div>
        <div className="neon-button-wrapper">
          <button type="submit" className="neon-button">
            Add Student Details
          </button>
        </div>
      </form>
    </div>
  );
};

export default Form;
