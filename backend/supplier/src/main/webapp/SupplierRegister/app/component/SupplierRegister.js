import React, { Component } from "react";
import { Menu, Icon, Button, Layout, Select, notification } from 'antd';
const Option = Select.Option;
const { Header, Footer, Sider, Content } = Layout;
import IconInput from './IconInput';
import config from './config.json';

class SupplierRegister extends Component {
    constructor() {
        super();
        this.render = this.render.bind(this);
        this.componentWillMount = this.componentWillMount.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
        this.state = {
            "options": null,
            "selected": 1
        }
    };

    componentWillMount() {
        fetch(config.backendUrl + "loadRestaurant")
            .then(res => res.json())
            .then(
                (result) => {
                    var options = result.map(
                        function (option) {
                            return <Option key={option.id}>{option.name}</Option>
                        }
                    )
                    this.setState({
                        "options": options
                    })
                },
                (error) => {
                    notification.open({
                        message: '系统繁忙，稍后再试',
                    });
                }
            )
    };

    handleClick() {
        fetch(config.backendUrl + "signUp?name=" + this.refs.position.state.value + "&username=" + this.refs.username.state.value + "&password=" + this.refs.password.state.value + "&restaurantId=" + this.state.selected)
            .then(res => res.json())
            .then(
                (result) => {
                    console.log(result);
                    if (result == "Success") {
                        notification.open({
                            message: '注册成功',
                        });
                    } else if (result == "DataError") {
                        notification.open({
                            message: '已存在相同的用户名',
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
    };

    handleChange(value) {
        this.setState({
            "selected": value
        })
    };

    handleBlur() {
        console.log('blur');
    };

    handleFocus() {
        console.log('focus');
    };

    render() {
        return (
            <Layout style={{ margin: '10%', padding: "10%", border: "solid", borderRadius: "5%", marginLeft: "20%", marginRight: "20%" }}>
                <Content style={{ textAlign: 'center' }}>
                    <div style={{ margin: '10%' }}>
                        <IconInput ref="username" type="user" placeholder="请输入用户名" style={{ padding: '40%' }} />
                    </div>
                    <div style={{ margin: '10%' }}>
                        <IconInput ref="password" type="eye" placeholder="请输入密码" style={{ padding: '40%' }} />
                    </div>
                    <div style={{ margin: '10%' }}>
                        <IconInput ref="position" type="credit-card" placeholder="请输入档口名称" style={{ padding: '40%' }} />
                    </div>
                    <Select
                        showSearch
                        style={{ width: 200 }}
                        placeholder="选择餐厅"
                        optionFilterProp="children"
                        onChange={this.handleChange}
                        onFocus={this.handleFocus}
                        onBlur={this.handleBlur}
                        filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}
                    >
                        {this.state.options}
                    </Select>
                    <Button type="primary" onClick={this.handleClick} style={{ margin: '10%' }}>确认注册</Button>
                </Content>
            </Layout>
        )
    }
}

export default SupplierRegister