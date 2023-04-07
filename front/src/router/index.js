import Admin from 'pages/Admin';
import Home from 'pages/Home';
import Login from 'pages/Login';
import Test from 'pages/Test';
import EnglishBot from 'pages/bots/EnglishBot';
import Error from 'pages/Error';
import { createBrowserRouter } from 'react-router-dom';

const routeMap = [
    {
        path:'/',
        indexed: true,
        element: <Home/>
    },
    {
        path:'home',
        element: <Home/>
    },
    {
        path:'/login',
        element: <Login/>
    },
    {
        path:'/admin',
        element: <Admin/>,
        children: [
            {
                path: 'english',
                element: <EnglishBot/>
            }
        ]
    },
    {
        path:'/test',
        element: <Test/>
    },
    {
        path:'/error',
        element: <Error/>
    },
    
]

export const router = createBrowserRouter(routeMap);