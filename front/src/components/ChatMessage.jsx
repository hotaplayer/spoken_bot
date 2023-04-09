import { Avatar } from "antd";

import "@/styles/ChatMessage.css";

export default function ChatMessage({chat}) {
    const component = chat.role === 'user'?(<MyMessage chat={chat}/>):(<div></div>);

    return component;
}

function MyMessage({chat}) {
    return (    
    <div className="chat-box my-message">
        <Avatar src={`https://joesch.moe/api/v1/random?key=1`}>

        </Avatar>
        <div className="ml-20">
        {chat.message}
        </div>
    </div>);
}