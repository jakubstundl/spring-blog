import { useEffect, useState } from "react";
import "./App.css";
import Post, { PostData } from "./components/Post";
import PostCreate from "./components/PostCreate";

const App = (): JSX.Element => {
  const [posts, setPosts] = useState<PostData[]>();
  const backendUrl = "http://localhost:8080/api"

  const fetchData = async () => {
    const data: PostData[] = await (await fetch(backendUrl+"/posts")).json();
    setPosts(data);
  };

  const deletePost = async (id: number, pin: number) => {
     const response = await fetch(backendUrl+"/post", {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ id, pin }),
    });
    console.log(await response.json());
    fetchData();
  };

  const createPost = async (pin: number, title:string, author:string, text:string) => {
    const response = await fetch(backendUrl+"/post", {
     method: "POST",
     headers: {
       "Content-Type": "application/json",
     },
     body: JSON.stringify({pin,title, author, text }),
   });
   console.log(await response.json());
   fetchData();
 };




  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div className="App">
      <PostCreate createPost={createPost}/>
      {posts?.sort( (a,b) => {return b.id-a.id}).map((post) => (
        <Post postData={post} deletePost={deletePost} />
      ))}
    </div>
  );
};

export default App;
