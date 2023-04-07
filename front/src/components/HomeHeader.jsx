import "@/styles/HomeHeader.css";
import { Button } from "antd";
import Logo from "@/assets/logo.png";

export default function HomeHeader() {
    return (
        <div className="home-header">
            <img src={Logo} className="w-28 h-10"/>
            <div>
                <Button className="sbbtn bg-white border-slate-300 text-black  text-base">Log In</Button> 
            </div>
        </div>
    )
}