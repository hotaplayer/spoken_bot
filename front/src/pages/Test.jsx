import { test } from "@/api/api";
import { useEffect, useState } from "react"


export default function Test(){
    const [ans, setAns] = useState('');
    
    const play = async ()=>{
        setAns(await test());
    }

    return (
    <div>
        <button onClick={play}>click</button>
        <p>
            {ans}
        </p>
    </div>)
}