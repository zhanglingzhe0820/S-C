import React, {Component} from "react";
import config from './config.json';

class InputText extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <input placeholder={config.name} ref="name">
                </input>
                <input placeholder={config.username} ref="username">
                </input>
                <input placeholder={config.password} ref="password">
                </input>
            </div>
        );
    }
}

export default InputText
