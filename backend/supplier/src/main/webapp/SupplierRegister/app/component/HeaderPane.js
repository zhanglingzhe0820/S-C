import React, { Component } from 'react';
import ReactDOM from 'react-dom';

class HeaderPane extends Component {
    render() {
        if (this.props.paneIndex == 1) {
            return <h3 style={{ textAlign: 'center' }}>餐厅管理</h3>;
        } else {
            return <h3 style={{ textAlign: 'center' }}>商户入驻</h3>;
        }
    }
}

export default HeaderPane