import VoiceRecorder from "@/components/VoiceRecorder";
import React,{useState} from "react";
import { Button } from "antd";
import { Outlet } from "react-router-dom";
import AdminHeader from "@/components/AdminHeader";
import MenuBar from "@/components/MenuBar";
import '@/styles/Admin.css';
import ChatOperation from "@/components/ChatOperation";




export default function Admin() {
  
  return (
    <div className="admin-container">
        <AdminHeader />
        <div className="admin-body">
            <div className="admin-sidebar">
              <MenuBar />
            </div>
            <div className="admin-main">
              <ChatOperation/>
              <Outlet/>
            </div>
        </div>
      
    </div>
  );
}


