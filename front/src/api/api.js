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
  return [
    {
      key:'1',
      label: '情景选择',
      children: [
        {
          key: '2',
          label:'英语外教',
          navigate: 'english',
        },
        {
          key: '3',
          label:'面试求职',
          navigate: 'interview',
        },
        {
          key: '4',
          label:'晋升答辩',
          navigate: 'promote'
        }
      ]
    }
  ]
}

export async function loadMyChats(sceneName) {
  return [
    {
      "role" : "assistant",
      "message": "this is response",
      "format" : "text"
    },
    {
      "role" : "user",
      "message": "0xaabb",
      "format" : "audio"
    },

  ]
}
