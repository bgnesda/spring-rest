// src/App.js

import React, { Component } from 'react';
import Home from './components/Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import LocaleList from './components/LocaleList';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/locales' exact={true} component={LocaleList}/>
        </Switch>
      </Router>
    )
  }
}

export default App;