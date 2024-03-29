import axios from 'axios';
import { message } from "antd";

export const instance = axios.create({
  baseURL: process.env.REACT_APP_API,
  timeout: 50000, // Set timeout to 5 seconds
});

instance.interceptors.request.use(
  (config) => {
    // 获取 JWT 令牌
    const token = localStorage.getItem("token");
    // 如果存在令牌，则在请求头中添加 Authorization 字段
    if (token) {
      config.headers["Authorization"] = `${token}`;
    }
    return config;
  },
  (error) => {
    console.log('遇到错误')
    return Promise.reject(error);
  }
);



instance.interceptors.response.use(
  (response) => {
    const responseData = response.data;
    if (responseData.code !== 0){
      message.error(`${responseData.msg}`);
      return Promise.reject(new Error(responseData.msg));
    } else{
      return responseData.data;
    }

  },
  (error) => {
    // 处理 HTTP 错误
    if (error.response) {
      message.error(
        `请求失败: ${error.response.status} ${error.response.statusText}`
      );
    } else {
      message.error(error.message);
    }
    return Promise.reject(error);
  }
);
export default instance;
