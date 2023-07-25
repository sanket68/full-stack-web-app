import React from "react";
import "./Navbar.css";
import logo from "../images/vnit-logo.png"
import PropTypes from "prop-types";

export default function Navbar(props) {
  return (
    <>
      <nav className="navbar bg-yellow">
        <div className="container navbar">
          <div className="navbar-brand">
            <img src={logo} alt="College Logo" className="logo-image" />
          </div>
          <div className="navbar mx-auto">
              <h1>{props.title}</h1>
          </div>
        </div>
      </nav>
    </>
  );
}
Navbar.prototype = {
  title: PropTypes.string,
};
