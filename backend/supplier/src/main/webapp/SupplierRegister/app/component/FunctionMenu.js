import React, { Component } from "react";
import { Menu, Icon } from 'antd';
import RestaurantManagement from './RestaurantManagement';
import SupplierResgister from './SupplierRegister';

class FunctionMenu extends Component {
    constructor(){
        super();
        this.handleClick = this.handleClick.bind(this);
    };
    handleClick(event) {
        this.props.transferMsg(event.key);
    };
    render() {
        return (
            <Menu
                onClick={this.handleClick}
                defaultSelectedKeys={['1']}
                mode="inline"
            >
                <Menu.Item key="1">
                    <Icon type="pie-chart" />
                    <span>餐厅管理</span>
                </Menu.Item>
                <Menu.Item key="2">
                    <Icon type="desktop" />
                    <span>商户入驻</span>
                </Menu.Item>
            </Menu>
        );
    }
}

export default FunctionMenu
