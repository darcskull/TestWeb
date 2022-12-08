import React, { Component } from 'react';
import axios from 'axios';
import './App.css';

const API_URL = 'http://localhost:8080/';
const zeroError = "Делене на -0- не е разрешена операция";
const invalidError = "Невалидни числени стойности";

class App extends Component {

  state = {
    firstValue: "",
    secondValue: "",
    message: "",
    name: ""
  };
  handleInput = event => {
    this.setState({ firstValue: event.target.value });
  };
  handleInput2 = event => {
    this.setState({ secondValue: event.target.value });
  };

  handleClick = () => {
    
  }

  render() {
    return (
      <div className="App">
        <h1>Калкулатор</h1>
        <div>
          <h3>Въведете първо число</h3>
          <input id="input-01" type="text" maxLength={8} onChange={this.handleInput}/>
        </div>
        <div>
          <h3>Въведете второ число</h3>
          <input id="input-02" type="text" maxLength={8} onChange={this.handleInput2}/>
        </div>
        <div>
          <h3></h3>
          <button type="button" onClick={this.handleClick}>Изчисли</button>
        </div>
        <div>
        <input id="input-03" type="text" value={this.state.message}/>
        </div>
      </div>
    );
  }
}

export default App;
