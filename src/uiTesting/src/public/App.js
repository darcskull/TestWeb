import React, { Component } from 'react';
import axios from 'axios';
import './App.css';

const API_URL = 'http://localhost:8080/';

class App extends Component {

  state = {
    firstValue: "",
    secondValue: "",
    message: ""
  };
  handleInput = event => {
    this.setState({ firstValue: event.target.value });
  };
  handleInput2 = event => {
    this.setState({ secondValue: event.target.value });
  };

  handleClick = () => {
    axios.get(API_URL + "calculate",{
      params:{
        firstNumber: this.state.firstValue,
        secondNumber: this.state.secondValue
      }},{
        Headers:{
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"
        }
      }).then((response)=>{
        this.setState({message: response.data});
      });
   };

  render() {
    return (
      <div className="App">
        <h1>Въведете две цели числа, които да бъдат разделени</h1>
        <div class ="content">
          <div class="red">Въведете първо число</div>
          <div><input id="input-01" type="text" maxLength={8} onChange={this.handleInput}/></div>
        </div>
        <div class ="content">
          <div class="green">Въведете второ число</div>
          <div><input id="input-02" type="text" maxLength={8} onChange={this.handleInput2}/></div>
        </div>
        <div>
          <button type="button" onClick={this.handleClick}>Изчисли</button>
        </div>
        <div class = "content">
          <div class="blue">Получен резултат</div>
          <div><input id="input-03" type="text" value={this.state.message} size="40"/></div>
        </div>
      </div>
    );
  }
}

export default App;
