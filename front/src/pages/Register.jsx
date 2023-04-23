import { Form, Input,Button } from "antd";

import "@/styles/Register.css";
import { register } from "@/api/api";

export default function Register() {

    const onFinish = async (values)=>{
        const result = await register(values.username, values.password)
        
    }

    return (<div>
        <div id="register-container" >
            <h1>欢迎注册SpokenBot</h1>
            <Form 
                className="m-auto"
                onFinish={onFinish}
                size='large'
                >
                <Form.Item required name="username" className="w-full">
                    <Input type="text" placeholder="Username"  ></Input>
                </Form.Item>
                <Form.Item required  name="password" className="w-full">
                    <Input.Password placeholder="Password"/>
                </Form.Item>
                <Form.Item name="confirm" dependencies={['password']}
                        hasFeedback
                        rules={[
                          {
                            required: true,
                            message: 'Please confirm your password!',
                          },
                          ({ getFieldValue }) => ({
                            validator(_, value) {
                              if (!value || getFieldValue('password') === value) {
                                return Promise.resolve();
                              }
                              return Promise.reject(new Error('The two passwords that you entered do not match!'));
                            },
                          }),
                        ]}
                className="w-full">
                    <Input type="password" placeholder="Confirm Password"></Input>
                </Form.Item>
                
                <Form.Item className="w-full">
                    <Button type="primary" htmlType="submit" className="w-full bg-black text-white font-fold" >Register</Button>
                </Form.Item>

                <span>Have account?<a href="/login" className=" text-black underline">Login</a></span>
                
            </Form>
        </div>
    </div>)
}