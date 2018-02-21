import React, { Component } from "react";
import { Menu, Icon, Input } from 'antd';


class IconInput extends Component {
    constructor(props) {
        super(props);
        this.state = {
            value: '',
        };
        this.onChangeValue=this.onChangeValue.bind(this);
        this.emitEmpty=this.emitEmpty.bind(this);
        this.render=this.render.bind(this);
    }
    emitEmpty() {
        this.valueInput.focus();
        this.setState({ value: '' });
    }
    onChangeValue(e) {
        this.setState({ value: e.target.value });
    }
    render() {
        const { value } = this.state;
        const suffix = value ? <Icon type="close-circle" onClick={this.emitEmpty} /> : null;
        return (
            <Input
                placeholder={this.props.placeholder}
                prefix={<Icon type={this.props.type} style={{ color: 'rgba(0,0,0,.25)' }} />}
                suffix={suffix}
                value={value}
                onChange={this.onChangeValue}
                ref={node => this.valueInput = node}
            />
        );
    }
}

export default IconInput