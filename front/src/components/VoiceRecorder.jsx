import React, { useState, useRef } from 'react';
import axios from 'axios';
import {Button, Divider, message} from 'antd';
import {uploadWav, readText} from '../api/api';
import {PlayCircleFilled, PauseCircleFilled} from '@ant-design/icons';

export default function VoiceRecorder() {
  const [isRecording, setIsRecording] = useState(false);
  const [audioBlob, setAudioBlob] = useState(null);
  const [sceneKey, setSceneKey] = useState();
  
  const mediaRecorder = useRef();

  const handleStartRecording = async () => {
    try {
      const audioStream = await navigator.mediaDevices.getUserMedia({ audio: true });
      mediaRecorder.current = new MediaRecorder(audioStream);
      const audioChunks = [];

      mediaRecorder.current.addEventListener('dataavailable', (event) => {
        audioChunks.push(event.data);
      });

      mediaRecorder.current.addEventListener('stop', () => {
        const audioBlob = new Blob(audioChunks, { type: 'audio/wav' });
        setAudioBlob(audioBlob);
        setIsRecording(false);
      });

      setIsRecording(true);
      mediaRecorder.current.start();
    } catch (error) {
      console.error(error);
    }
  };

  const handleStopRecording = () => {
    setIsRecording(false);
    mediaRecorder.current.stop();
    console.log('录制结束');
    setAudioBlob(undefined);
  };

  // const handleUpload = async () => {
  //   const resp = await uploadWav(audioBlob);
  //   if (resp.code === 0){
  //     console.log(resp.data);
  //     message.info(resp.data);
  //   } else{
  //     message.error(resp.message);
  //   }
  //   setAudioBlob(undefined);
  // };

  return (
      <Button 
      className='mt-2 mb-2 mr-4'
      style={{width: '80px'}}
      icon={isRecording? <PauseCircleFilled style={{color:'red'}}/>:<PlayCircleFilled style={{color:'green'}}/>}
      onClick={isRecording ? handleStopRecording : handleStartRecording}
      >
      </Button>
  );
}