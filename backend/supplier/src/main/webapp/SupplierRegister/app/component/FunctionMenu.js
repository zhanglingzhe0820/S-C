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
        if(event.key!=3){
            this.props.transferMsg(event.key);
        }else{
            fetch(config.backendUrl + "confirmUserFaith")
            .then(res => res.json())
            .then(
                (result) => {
                    if (result == "Success") {
                        notification.open({
                            message: '添加成功',
                        });
                    } else {
                        notification.open({
                            message: '系统繁忙，稍后再试',
                        });
                    }
                },
                (error) => {
                    notification.open({
                        message: '服务器错误，请检查网络',
                    });
                }
            )
        }
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
                <Menu.Item key="3">
                    <Icon type="retweet" />
                    <span>更新用户信用度</span>
                </Menu.Item>
            </Menu>
        );
    }
}

export default FunctionMenu
