import VoiceRecorder from "@/components/VoiceRecorder";
import React,{useState} from "react";
import CommonHeader from "@/components/CommonHeader";


export default function Admin() {


  return (
    <div className="container">
      <CommonHeader/>
      <div className="content">
        <VoiceRecorder />
        
      </div>
      
    </div>
  );
}

