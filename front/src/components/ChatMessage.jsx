import { Avatar ,Button} from "antd";
import Speech from 'react-speech';
import {PlayCircleFilled, PauseCircleFilled} from '@ant-design/icons';
import "@/styles/ChatMessage.css";
import { useState } from "react";

export default function ChatMessage({chat}) {
    const component = chat.role === 'user'?(<MyMessage chat={chat}/>):(<div></div>);

    return component;
}


function MyMessage({chat}) {
    const [isPlay, setIsPlay] = useState(false);
    const clickChat = async ()=>{
        if (isPlay){
            return;
        }
        setIsPlay(true);
        await playBase64Message(chat.message, ()=>{
            setIsPlay(false);
            console.log('finish playing')    
        });
    }
    return (    
    <div className="chat-box my-message">
        <Avatar src={`https://joesch.moe/api/v1/random?key=1`} className="ml-8">

        </Avatar>
        <div className="chat-bubble" onClick={clickChat} >
            {isPlay?<PauseCircleFilled/>:<PlayCircleFilled />}
        </div>
        {/* <Speech 
            style={{
                width: '100px',
                backgroundColor: 'red',
                border: '1px solid red'
            }}
            text={chat.message}
            voice="Google UK English Female"
        /> */}
    </div>);
}


function AIMessage({chat}) {
    const isSpeechSynthesisSupported = 'speechSynthesis' in window;
    console.log('support:'+isSpeechSynthesisSupported);
    console.log()
    const clickChat = ()=>{
        playBase64Message(chat.message)
    }
    return (    
    <div className="chat-box my-message">
        <Avatar src={`https://joesch.moe/api/v1/random?key=1`} className="ml-8">

        </Avatar>
        <div className="chat-bubble" onClick={clickChat}>
            
        </div>
        {/* <Speech 
            style={{
                width: '100px',
                backgroundColor: 'red',
                border: '1px solid red'
            }}
            text={chat.message}
            voice="Google UK English Female"
        /> */}
    </div>);
}

function toByteArray(base64Str){
    const binaryString = atob(base64Str);
    const byteArray = new Uint8Array(binaryString.length);

    for (let i = 0; i < binaryString.length; i++) {
        byteArray[i] = binaryString.charCodeAt(i);
    }
    return byteArray;
}

async function playBase64Message(message, callback){
    const byteArray = toByteArray(message);
    // Create an audio context
    const audioContext = new AudioContext();

    // Decode the audio data
    const audioBuffer = await audioContext.decodeAudioData(byteArray.buffer);
    // Create an audio buffer source
    const source = audioContext.createBufferSource();
    source.buffer = audioBuffer;

    // Connect the audio source to the audio context destination
    source.connect(audioContext.destination);

    // Start playing the audio
    source.start();
    source.onended=callback;
}