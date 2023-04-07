import {Divider, Layout} from "antd";
import HomeHeader from "@/components/HomeHeader";
const { Header, Content, Footer } = Layout;

export default function Home(){
    return (
        <div>
            <HomeHeader />
            {/* <Content >
                mains content</Content>
            <Footer>footer</Footer> */}
        </div>
    )
}