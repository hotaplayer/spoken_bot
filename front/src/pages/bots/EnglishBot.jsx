import Conversation from "@/components/Conversation";
import VoiceRecorder from "@/components/VoiceRecorder";
import React,{useEffect, useState} from "react";
import PubSub from 'pubsub-js';
import { Button } from "antd";
import { loadMyChats } from "@/api/api";
import { useLocation } from "react-router-dom";

const RECEIVE_TOPIC = 'english_bot';

export default function EnglishBot() {

    const [chats, setChats] = useState([]);
    const location = useLocation();
    const sceneName = location.pathname.split('/').pop();
    useEffect(() => {
        async function initChats(){
            const myChats = await loadMyChats(sceneName);
            setChats(myChats);
        }
        
        initChats();
        const subscription = PubSub.subscribe(RECEIVE_TOPIC, (topic, chat)=>{
            setChats(chats=>{
                chats.push(chat);
                return chats;
            });
        });
        PubSub.publish('scene-topic', {sceneName: sceneName, receiveTopic: RECEIVE_TOPIC });

        return ()=>{PubSub.unsubscribe(subscription)};
    }, []);
  
  

    return (
        <div>
            <Conversation chats={chats}/>
        </div>
    )

//   return (
//     <div className="container">
//       <CommonHeader/>
//       <div className="content">
//         <VoiceRecorder />
        
//       </div>
      
//     </div>
//   );
}


