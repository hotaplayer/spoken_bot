import { useEffect } from "react"
import { useSpeechSynthesis } from "react-speech-kit";

export default function Test(){
    const onEnd = () => {
        console.log('read complete')
    }

    const { speak, cancel, speaking, supported, voices } = useSpeechSynthesis({onEnd});

    const play = ()=>{
        if ('speechSynthesis' in window) {
            const voice = voices.filter(v=>v.lang==='en-US')[1];
            console.log(voice);
            speak({text: 'hello world, this is my first time', voice: voice})
          }
        else{
            alert('您的浏览器不支持')
        }
    }

    return (<div>
        <button onClick={play}>click</button>

    </div>)
}