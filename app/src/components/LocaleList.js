import React, { Component } from 'react';
import AppNavbar from './AppNavBar';
import { Link } from 'react-router-dom';
import Locales from './locales';

const API = '/api/v1/locales';

class LocaleList extends Component {

  constructor(props) {
    super(props);

    this.state = {
        locales: [],
    };
  }

  componentDidMount() {
    fetch(API)
        .then(res => res.json())
        .then(data => this.setState({ locales: data.content }));
  }

  render() {
    return (
        <div>
            <AppNavbar/>
            <Locales locales={this.state.locales} />
        </div>
    )
  }
}

export default LocaleList;