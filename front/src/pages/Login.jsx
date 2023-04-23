import "@/styles/Login.css";
import { Form,Input,Button } from "antd";
import { useForm
 } from "antd/es/form/Form";
import { useNavigate } from "react-router-dom";
import Cookies from 'js-cookie';
import HomeHeader from "@/components/HomeHeader";

export default function Login(){

    const navigate = useNavigate();
    const onFinish = async (values)=>{
        //TODO: call backend api and get token.
        Cookies.set('username', values.username, { expires: 7 });
        navigate("/admin");
    }
    return (<div id="login-bg">
        <div id="login-container"
        >   
            <h1>欢迎登入SpokenBot</h1>
            <Form
                onFinish={onFinish}>
                <Form.Item required className="w-full" name="username" > 
                    <Input type="text" placeholder="Username" ></Input>
                </Form.Item>
                <Form.Item required className="w-full" name="password">
                    <Input type="password" placeholder="Password" ></Input>
                </Form.Item>
                <Form.Item className="self-end" >
                    <a className="text-black underline">Forgot Password?</a>
                </Form.Item>
                <Form.Item className="w-full ">
                    <Button type="primary" htmlType="submit" className="w-full bg-black text-white font-fold" >Log In</Button>
                </Form.Item>
                
                <Form.Item  className="self-end ">
                    Not register?  
                        <a className="ml-4 underline text-black" href="/register" >Register Now!</a>
                </Form.Item>

            </Form>
        </div>
    </div>)
}