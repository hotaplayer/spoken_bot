import {instance} from './axios_http';


export async function uploadWav(audioBlob) {
    const formData = new FormData();
    formData.append('audio', audioBlob, 'audio.wav');
    return await instance.post('/api/audio', formData);
}

export async function readText(filename) {
    const params = {
        filename:filename
    }
    console.log(params)
    return await instance.post('/api/text', params);
}

export async function getMenuItems() {
  return [{
      key: 'EnglishBot',
      label:'英语外教'
    },
    {
      key: 'TechInterviewBot',
      label:'技术面试'
    },
    {
      key: 'Maintain',
      label:'运营述职'
    }
  ]
}
