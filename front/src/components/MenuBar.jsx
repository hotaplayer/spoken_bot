import React, {useEffect, useState} from 'react';
import {getMenuItems} from '@/api/api';
import { Menu,Button } from 'antd';
import "@/styles/MenuBar.css";

export default function MenuBar(){
    const [menuItems, setMenuItems] = useState([]);

    useEffect(()=>{
        async function loadItems(){
            const items = await getMenuItems();
            setMenuItems(items);
        }
        loadItems();
    }
    ,[]);

    return (
        <Menu id='admin-menu'
        mode="inline" 
        items={menuItems}
        defaultSelectedKeys={'EnglishBot'}
        />
    )
}