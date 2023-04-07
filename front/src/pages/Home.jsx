import {Layout} from "antd";
import HomeHeader from "@/components/HomeHeader";
const { Header, Content, Footer } = Layout;

export default function Home(){
    return (
        <Layout>
            <HomeHeader />
            <Content className="text-3xl font-bold underline">
                mains content</Content>
            <Footer>footer</Footer>
        </Layout>
    )
}