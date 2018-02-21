import React, { Component } from "react";
import { Menu, Icon, Button, Layout, Select } from 'antd';
const Option = Select.Option;
const { Header, Footer, Sider, Content } = Layout;
import IconInput from './IconInput';

class SupplierRegister extends Component {
    handleClick() {

    };

    handleChange(value) {
        console.log(`selected ${value}`);
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
                        <IconInput type="user" placeholder="请输入用户名" style={{ padding: '40%' }} />
                    </div>
                    <div style={{ margin: '10%' }}>
                        <IconInput type="eye" placeholder="请输入密码" style={{ padding: '40%' }} />
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
                        <Option value="jack">Jack</Option>
                        <Option value="lucy">Lucy</Option>
                        <Option value="tom">Tom</Option>
                    </Select>
                    <Button type="primary" onClick={this.handleClick} style={{ margin: '10%' }}>确认注册</Button>
                </Content>
            </Layout>
        )
    }
}

export default SupplierRegister