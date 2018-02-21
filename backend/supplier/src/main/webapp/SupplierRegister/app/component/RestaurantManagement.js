import React, { Component } from "react";
import { Menu, Icon, Button, Layout, TimePicker } from 'antd';
import moment from 'moment';
const { Header, Footer, Sider, Content } = Layout;
import IconInput from './IconInput';
import config from './config.json';

class RestaurantManagement extends Component {
    constructor() {
        super();
        this.render = this.render.bind(this);
        this.handleClick = this.handleClick.bind(this);
        this.onStartTimeChange = this.onStartTimeChange.bind(this);
        this.onEndTimeChange = this.onEndTimeChange.bind(this);
        this.state = {
            "startTime": "00:00:00",
            "endTime": "00:00:00"
        }
    };
    handleClick() {
        fetch(config.backendUrl + "saveRestaurant?name=" + this.refs.restaurantName.state.value + "&time=" + this.state.startTime + "-" + this.state.endTime)
            .then(res => res.json())
            .then(
                (result) => {
                    console.log(result)
                },
                (error) => {
                    console.log(error)
                }
            )
    };
    onStartTimeChange(time, timeString) {
        this.setState({
            "startTime": timeString
        })
    };
    onEndTimeChange(time, timeString) {
        this.setState({
            "endTime": timeString
        })
    };
    render() {
        return (
            <Layout style={{ margin: '10%', padding: "10%", border: "solid", borderRadius: "5%", marginLeft: "20%", marginRight: "20%" }}>
                <Content style={{ textAlign: 'center' }}>
                    <div style={{ margin: '10%' }}>
                        <IconInput ref="restaurantName" type="user" placeholder="请输入餐厅名" style={{ padding: '40%' }} />
                    </div>
                    <TimePicker onChange={this.onStartTimeChange} placeholder="开始时间" defaultOpenValue={moment('00:00:00', 'HH:mm:ss')} />
                    <TimePicker onChange={this.onEndTimeChange} placeholder="结束时间" defaultOpenValue={moment('00:00:00', 'HH:mm:ss')} />
                    <Button type="primary" onClick={this.handleClick} style={{ margin: '10%' }}>确认添加</Button>
                </Content>
            </Layout>
        )
    }
}

export default RestaurantManagement;