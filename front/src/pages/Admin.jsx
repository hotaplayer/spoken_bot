import VoiceRecorder from "@/components/VoiceRecorder";
import React,{useState} from "react";
import { Button } from "antd";
import AdminHeader from "@/components/AdminHeader";
import '@/styles/Admin.css';
import MenuBar from "@/components/MenuBar";


export default function Admin() {
  
  return (
    <div className="admin-container">
        <AdminHeader />
        <div className="admin-operation">
            <Button id='new-chat' className="mt-2 mb-2 w-1/6 text-black">重置对话</Button>
        </div>
        <div className="admin-body">
            <div className="admin-sidebar">
              <MenuBar />
            </div>
            <div className="admin-main">

            </div>
        </div>
      
    </div>
  );
}


