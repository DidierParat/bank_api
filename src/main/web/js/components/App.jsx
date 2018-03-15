import React, { Component } from 'react';
import ApiUrlInput from './ApiUrlInput';
import Customers from './Customers';

export default class App extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <ApiUrlInput />
                <Customers />
            </div>
        );
    }
}