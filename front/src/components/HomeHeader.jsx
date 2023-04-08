import "@/styles/HomeHeader.css";
import { Button } from "antd";
import Logo from "@/assets/logo.png";
import { useNavigate } from "react-router-dom";

export default function HomeHeader() {
    const navigate = useNavigate();
    return (
        <div className="home-header">
            <img src={Logo} className="w-28 h-10"/>
            <div>
                <Button 
                className="sbbtn bg-white border-slate-300 text-black  text-base"
                onClick={()=>{navigate('/login')}}
                >Log In</Button> 
            </div>
        </div>
    )
}