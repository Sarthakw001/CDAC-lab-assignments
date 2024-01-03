let books = [];
let bookId = 0;

exports.createBook = (req,res) => {
    const {name,author,price} = req.body;

    if(!name || !author || !price) {
        res.status(400).send("all fields required");
    }

    const book = {
        id:++bookId,
        name,
        author,
        price
    }

    books.push(book);

    res.status(201).json(book);
}

exports.getBook = (req,res) => {
    res.status(201).json(books);
}

