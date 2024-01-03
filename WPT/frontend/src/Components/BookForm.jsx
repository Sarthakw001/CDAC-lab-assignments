import { useState } from "react";
import axios from 'axios';
const BookForm = () => {
    const [formData,setFormData] = useState({
        name:'',
        author:'',
        price:0
    });
    const [res,setRes] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
       await axios.post('http://localhost:8080/createBook',formData)
        .then((response)=>{
            setRes(response.data);
            // console.log(response.data);
            console.log(res);
        });
    }
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
      };
  return (
    <>
      <h1>Book Form</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Book Name:
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Author:
          <input
            type="text"
            name="author"
            value={formData.author}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Price:
          <input
            type="number"
            name="price"
            value={formData.price}
            onChange={handleChange}
          />
        </label>
        <br />
        <button type="submit">ADD</button>
      </form>
    </>
  );
};

export default BookForm;