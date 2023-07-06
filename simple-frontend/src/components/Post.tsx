import { useRef } from "react";

export type PostData = {
  id: number;
  title: string;
  author: string;
  text: string;
  pin: number;
};

const Post = ({
  postData,
  deletePost,
}: {
  postData: PostData;
  deletePost: (id: number, pin: number) => void;
}): JSX.Element => {
  const pinToEdit = useRef<HTMLInputElement>(null);
  return (
    <div className="post">
      <p>Id:{postData.id}</p>
      <p>Title:{postData.title}</p>
      <p>Author:{postData.author}</p>
      <p>Text:{postData.text}</p>
      <input ref={pinToEdit} type="number" placeholder="PIN" />
      <button
        onClick={() => {
          if (pinToEdit && pinToEdit.current) {
            deletePost(postData.id, Number(pinToEdit.current.value) || 0);
          }
        }}
      >
        Delete post
      </button>
    </div>
  );
};

export default Post;
