import { Button } from "antd";
import VoiceRecorder from "./VoiceRecorder";
import "@/styles/ChatOperation.css";

export default function ChatOperation(){
    return (              
        <div className="chat-operation">
            <VoiceRecorder />
            <Button id='new-chat' className="mt-2 mb-2 w-20 text-black">重置对话</Button>
        </div>
    )
}