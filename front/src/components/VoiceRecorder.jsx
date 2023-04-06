import React, { useState, useRef } from 'react';
import axios from 'axios';
import {Button, Divider, message} from 'antd';
import {uploadWav, readText} from '../api/api';

export default function VoiceRecorder() {
  const [isRecording, setIsRecording] = useState(false);

  const [audioBlob, setAudioBlob] = useState(null);
  const [filename, setFilename] = useState();
  const [transcribe, setTranscribe] = useState();
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
  };

  const handleUpload = async () => {
    const resp = await uploadWav(audioBlob);
    if (resp.code === 0){
      console.log(resp.data);
      setFilename(resp.data);
      message.info(resp.data);
    } else{
      message.error(resp.message);
    }
    setAudioBlob(undefined);
  };

  const handleReadText  = async () => {
    const resp = await readText(filename);
    console.log(resp);
    setTranscribe(resp.data)
  }

  return (
    <div style={{
      
    }}>
      <Button 
      onClick={isRecording ? handleStopRecording : handleStartRecording}>
        {isRecording ? '停止录制' : '开始录制'}
      </Button>
      <Button onClick={handleUpload} disabled={!audioBlob}>
        Upload Audio
      </Button>
      <Button onClick={handleReadText} disabled={!filename}>
        Read Text
      </Button>
      {transcribe && (<div>文本:<p>{transcribe}</p></div>)}
    </div>
  );
}