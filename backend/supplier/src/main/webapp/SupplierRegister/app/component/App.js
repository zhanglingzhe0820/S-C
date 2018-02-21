import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { Layout } from 'antd';
const { Header, Footer, Sider, Content } = Layout;
import FunctionMenu from './FunctionMenu';
import MainPane from './MainPane';
import HeaderPane from './HeaderPane';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            paneIndex: 1
        };
    };
    transferMsg(msg) {
        this.setState({
            paneIndex: msg
        });
    };
    render() {
        return (
            <Layout style={{ minHeight: '100vh' }}>
                <Sider id="sider">
                    <img id="logo" src={require('./images/logo.png')} alt="" style={{marginBottom:'10%'}}/>
                    <FunctionMenu transferMsg={msg => this.transferMsg(msg)} />
                </Sider>
                <Layout>
                    <Header style={{ background: '#fff', padding: 0 }} >
                        <HeaderPane paneIndex={this.state.paneIndex} />
                    </Header>
                    <Content id="content" style={{ margin: '0 16px' }}>
                        <MainPane paneIndex={this.state.paneIndex} />
                    </Content>
                    <Footer style={{ textAlign: 'center' }}>
                        @Powered by Surevil
                    </Footer>
                </Layout>
            </Layout>
        )
    };
    componentDidMount() {
        document.getElementById("logo").style.width = document.getElementById("sider").style.width;
    };
}

export default App