import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import RestaurantManagement from './RestaurantManagement';
import SupplierRegister from './SupplierRegister';

class MainPane extends Component {
    render() {
        if (this.props.paneIndex == 1) {
            return <RestaurantManagement />;
        } else {
            return <SupplierRegister />;
        }
    }
}

export default MainPane