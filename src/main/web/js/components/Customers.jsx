import React, { Component } from 'react';
import { fetchAndSetData } from '../utils';
import { connect } from 'react-redux';
import { setCustomersApiData } from '../data/dataStore';

export class Customers extends Component {
    constructor(props) {
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(event) {
        this.props.setData({});
        fetchAndSetData(
            this.props.apiUrl + "/customers/12345678901",
            this.props.setData);
    }

    render() {
        return (
            <div>
                <h2>Customers</h2>
                <p>GET request: /customers/(customerID)</p>
                <p>Get customer details by ID.</p>
                <button onClick={this.handleClick}>Try !</button>
                <pre>{JSON.stringify(this.props.data, null, 2)}</pre>
            </div>
        );
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Customers);

function mapStateToProps(state) {
    return {
        apiUrl: state.apiUrl,
        data: state.customersApiData
    };
}

function mapDispatchToProps(dispatch) {
    return {
        setData: data => dispatch(setCustomersApiData(data))
    }
}