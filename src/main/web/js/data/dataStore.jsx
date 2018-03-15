import { createStore } from 'redux';

export const actionTypes = {
    SET_API_URL: 'SET_API_URL',
    SET_CUSTOMERS_API_DATA: 'SET_CUSTOMERS_API_DATA'
};

export function getStore() {
    return store;
}

const store = createStore(reducer);

function defaultState() {
    return {
        apiUrl: "http://localhost:8080/",
        customersApiData: {}
    };
}

function reducer(state = defaultState(), action) {
    const { type, payload } = action;
    switch (type) {
        case actionTypes.SET_API_URL:
        case actionTypes.SET_CUSTOMERS_API_DATA:
            return Object.assign({}, state, payload);
        default: return state;
    }
}

export function setApiUrl(apiUrl) {
    return {
        type: actionTypes.SET_API_URL,
        payload: { apiUrl },
    };
}


export function setCustomersApiData(customersApiData) {
    return {
        type: actionTypes.SET_CUSTOMERS_API_DATA,
        payload: { customersApiData },
    };
}