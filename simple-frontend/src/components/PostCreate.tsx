import { useRef } from "react";

export type PostData = {
  id: number;
  title: string;
  author: string;
  text: string;
  pin: number;
};

const PostCreate = ({
  createPost,
}: {
  createPost: (
    pin: number,
    title: string,
    author: string,
    text: string
  ) => void;
}): JSX.Element => {
  const title = useRef<HTMLInputElement>(null);
  const author = useRef<HTMLInputElement>(null);
  const text = useRef<HTMLInputElement>(null);
  const pin = useRef<HTMLInputElement>(null);
  return (
    <div className="post">
     <h2>Create new post</h2>
      <input ref={title} type="text" placeholder="Title" />
      <br />
      <input ref={author} type="text" placeholder="Author" />
      <br />
      <input ref={text} type="text" placeholder="Text" size={60} />
      <br />

      <input ref={pin} type="number" placeholder="PIN to edit/delete" />
      <br />

      <button
        onClick={() => {
          if (pin.current && title.current && author.current && text.current) {
            createPost(
              Number(pin.current.value) || 0,
              title.current.value || "",
              author.current.value || "",
              text.current.value || ""
            );
          }
        }}
      >
        Create post
      </button>
    </div>
  );
};

export default PostCreate;
