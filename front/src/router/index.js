import Admin from '@/pages/Admin';
import Home from '@/pages/Home';
import Login from '@/pages/Login';
import Test from '@/pages/Test';
import EnglishBot from '@/pages/bots/EnglishBot';
import Error from '@/pages/Error';
import { createBrowserRouter } from 'react-router-dom';
import TechInterviewBot from '@/pages/bots/TechInterviewBot';
import PromoteBot from '@/pages/bots/PromoteBot';
import Register from '@/pages/Register';

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
        path: '/register',
        element: <Register/>
    },
    {
        path:'/admin',
        element: <Admin/>,
        children: [
            {
                index: true,
                element: <EnglishBot/>
            },
            {
                path: 'english',
                element: <EnglishBot/>
            },
            {
                path: 'interview',
                element: <TechInterviewBot/>
            },
            {
                path: 'promote',
                element: <PromoteBot/>
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