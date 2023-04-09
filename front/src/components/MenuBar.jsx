import React, {useEffect, useState} from 'react';
import {getMenuItems} from '@/api/api';
import { Menu,Button } from 'antd';
import "@/styles/MenuBar.css";
import { useNavigate } from 'react-router-dom';

export default function MenuBar(){
    const [menuItems, setMenuItems] = useState([]);
    const navigate = useNavigate();
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
        defaultOpenKeys={'1'}
        defaultSelectedKeys={'2'}
        onSelect={(key)=>{onSelect(key.key, menuItems, navigate)}}
        />
    )
}

async function onSelect(key, menuItems, navigate){
    const menuItem = find(menuItems, key);
    if (menuItem){
        navigate(menuItem.navigate);
    }
}

function find(menuItems, key){
    for (var i=0;i<menuItems.length;i++){
        const item = menuItems[i];
        if (item.key == key){
            return item;
        }
        if (item.children && item.children.length > 0){
            const subResult = find(item.children, key);
            if (subResult){
                return subResult;
            }
        }
    }
    return undefined;
}