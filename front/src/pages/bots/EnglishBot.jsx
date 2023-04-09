import VoiceRecorder from "@/components/VoiceRecorder";
import React,{useState} from "react";
import CommonHeader from "@/components/AdminHeader";


export default function EnglishBot() {


  return (
    <div className="container">
      <CommonHeader/>
      <div className="content">
        <VoiceRecorder />
        
      </div>
      
    </div>
  );
}


