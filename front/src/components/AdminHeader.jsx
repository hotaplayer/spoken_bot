import "@/styles/HomeHeader.css";
import { Button,Avatar } from "antd";
import {UserOutlined } from '@ant-design/icons';
import Logo from "@/assets/logo.png";
import { useNavigate, Link } from "react-router-dom";
import Cookies from 'js-cookie';

export default function AdminHeader() {
    const navigate = useNavigate();
    return (
        <div className="home-header">
            <img src={Logo} className="w-28 h-10"/>
            <div>
                <Link >
                    <Avatar icon={<UserOutlined />}></Avatar>
                    <Avatar size={48}>{Cookies.get("username")}</Avatar>
                </Link>
            </div>
        </div>
    )
}