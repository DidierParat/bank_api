import React from 'react';
import { Customers } from '../js/components/Customers';
import renderer from 'react-test-renderer';
import { shallow, configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { fetchAndSetData } from '../js/utils';

jest.mock('../js/utils', () => ({
    fetchAndSetData: jest.fn()
}));

configure({ adapter: new Adapter() });

describe('Test <Customers> with wrapping in <Provider>',()=>{
    it('+++ renders correctly', () => {
        const setData = (data)=>{};
        const rendered = renderer.create(
            <Customers apiUrl={'http://localhost:8080'} data={{}} setData={setData} />
        );
        expect(rendered.toJSON()).toMatchSnapshot();
    });

    it('+++ clicking button sets new data', () => {
        const setData = (data)=>{};
        const wrapper = shallow( <Customers apiUrl={'http://localhost:8080'} data={{}} setData={setData} /> );
        wrapper.find('button').simulate('click');
        expect(fetchAndSetData).toBeCalledWith('http://localhost:8080/customers/123', setData);
    });

    it('+++ data is displayed as json', () => {
        const setData = (data)=>{};
        const wrapper = shallow( <Customers apiUrl={'http://localhost:8080'} data={{status: 200}} setData={setData} /> );
        expect(wrapper.find('pre').get(0).props.children).toBe("{\n  \"status\": 200\n}");
    });
});