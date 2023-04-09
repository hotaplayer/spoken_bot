import { Avatar,List } from "antd";
import React, {useState} from 'react';
import ChatMessage from "./ChatMessage";


export default function Conversation({chats}){
    
    return (
    <div className="ml-8 mr-8">
        
        <List
            itemLayout="horizontal"
            dataSource={chats}
            renderItem={(item, index) => (
                <ChatMessage chat={item}/>
            )}
        />
    </div>)
}