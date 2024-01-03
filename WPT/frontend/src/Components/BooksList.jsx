import axios from "axios";
import { useEffect, useState } from "react";

const BookList = () => {
  const [books, setBooks] = useState([]);
  const getBooks = async () => {
    await axios.get("http://localhost:8080/books").then((response) => {
      setBooks(response.data);
    });
  };
  useEffect(() => {
    getBooks();
  },[books]);
  return (
    <>
     <ul>
          {books.map((book) => (
            <li key={book.id}>
              <strong>{book.name}</strong> by {book.author} - ${book.price}
            </li>
          ))}
        </ul>
    </>
  );
};

export default BookList;
