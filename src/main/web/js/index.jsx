import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';
import { getStore } from './data/dataStore';
import { Provider } from 'react-redux';
import '../styles/app.scss';

ReactDOM.render(
    <Provider store={getStore()}>
        <App />
    </Provider>,
    document.getElementById('app')
);