import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import './Landing.css';

class Landing extends Component {
    constructor(props){
        super(props);
        this.state = {};
    }

    render() {
        return (
            <div className="landing">
                <div className="landing__header">
                    <div className="landing__headerbuttons">
                        <Link to="/signup">
                        <button className="landing__headerbutton"><span>Sign up</span></button>
                        </Link>
                        <Link to="/login">
                            <button className="landing__headerbutton"><span>Log in</span></button>
                        </Link>
                    </div>
                </div>
                <div className="landing__main">
                    <div className="landing__mainLeft">
                        <span className="landing__maintext">Welcome!</span>
                        <span className="landing__maintext">Coffee-Maker Cloud Robot System (CCRS)</span>
                        <span className="landing__subtext">Team 12: Y.Choi, J.Monsod, A.Pandian, S.Lau</span>
                        <span className="landing__description">Sign up or Log in to start</span>
                        <div className="landing__mainbuttons">
                            <Link to="/signup">
                            <button className="landing__button"><span>Sign up</span></button>
                            </Link>
                            <Link to="/login">
                                <button className="landing__button"><span>Log in</span></button>
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Landing;
