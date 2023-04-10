import { Avatar ,Button} from "antd";
import Speech from 'react-speech';
import {PlayCircleFilled, PauseCircleFilled} from '@ant-design/icons';

import { useState, useRef } from "react";
import { useSpeechSynthesis } from 'react-speech-kit';

import "@/styles/ChatMessage.css";

export default function ChatMessage({chat}) {
    const component = chat.role === 'user'?(<MyMessage chat={chat}/>):(<AIMessage chat={chat}/>);
    return component;
}


function MyMessage({chat}) {
    const [isPlay, setIsPlay] = useState(false);
    const audioSource = useRef();
    const clickChat = async ()=>{
        if (isPlay){
            setIsPlay(false);
            audioSource.current.stop();
            return;
        }
        setIsPlay(true);
        audioSource.current = await playBase64Message(chat.message, ()=>{
            setIsPlay(false);
            console.log('finish playing')    
        });
    }
    return (    
    <div className="chat-box my-message">
        <span  className="ml-8 font-bold ">
            You
        </span>
        <div className="chat-bubble" onClick={clickChat} >
            {isPlay?<PauseCircleFilled style={{color:'red'}}/>:<PlayCircleFilled style={{color:'green'}}/>}
        </div>
    </div>);
}


function AIMessage({chat}) {
    const [isPlay, setIsPlay] = useState(false);
    const onEnd = () => {
        setIsPlay(false);
    }
    const { speak, cancel, speaking, supported, voices } = useSpeechSynthesis({onEnd});
    const voice = voices.filter(v=>v.lang==='en-US')[4];

    const clickChat =  ()=>{
        if (isPlay){
            cancel();
            setIsPlay(false);
        } else{
            setIsPlay(true)
            speak({text:chat.message, voice:voice});
        }
    }
    return (    
    <div className="chat-box ai-message">
        <div className="chat-bubble" onClick={clickChat}>
            {isPlay?<PauseCircleFilled style={{color:'red'}}/>:<PlayCircleFilled style={{color:'green'}}/>}
        </div>
        <Avatar src={`https://joesch.moe/api/v1/random?key=1`} className="ml-8">

        </Avatar>
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
    return source;
}