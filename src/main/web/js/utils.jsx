import React from 'react';
import { get } from 'axios';

export function fetchAndSetData(request, setData) {
    get(request)
        .then(response => setData(response.data))
        .catch(error => console.error(error));
}