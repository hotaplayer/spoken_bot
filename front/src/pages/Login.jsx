import "@/styles/Login.css";
import { Form,Input,Button } from "antd";
import { useForm
 } from "antd/es/form/Form";
export default function Login(){

    const form = useForm();

    return (<div id="login-bg">
        <div id="login-container"
        >
            <h1>欢迎登入SpokenBot</h1>
            <Form id="login-form" >
                <Form.Item required className="w-full">
                    <Input type="text" placeholder="Username"  size="large"></Input>
                </Form.Item>
                <Form.Item required className="w-full">
                    <Input type="password" placeholder="Password" size="large" ></Input>
                </Form.Item>
                <Form.Item className="self-end" >
                    <a className="text-black underline">Forgot Password?</a>
                </Form.Item>
                <Form.Item className="w-full ">
                    <Button type="primary" className="w-full bg-black text-white font-fold" >Log In</Button>
                </Form.Item>
                
                <Form.Item  className="self-end ">
                    Not register?  
                        <a className="ml-4 underline text-black" >Register Now!</a>
                </Form.Item>

            </Form>
        </div>
    </div>)
}