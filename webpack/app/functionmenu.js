import {Menu, Icon} from 'antd';
import React from "react";
import {Component} from "react/cjs/react.production.min";

class FunctionMenu extends Component {
    render() {
        return (
            <div style={{width: 256}}>
                <Menu
                    defaultSelectedKeys={['1']}
                    mode="inline"
                    theme="dark"
                >
                    <Menu.Item key="1">
                        <Icon type="appstore-o"/>
                        <span>餐厅管理</span>
                    </Menu.Item>
                    <Menu.Item key="2">
                        <Icon type="plus-square"/>
                        <span>商户入驻</span>
                    </Menu.Item>
                </Menu>
            </div>
        );
    }
}

export default FunctionMenu