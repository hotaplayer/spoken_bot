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