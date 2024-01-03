const express = require("express");
const { createBook, getBook } = require("../controller/BookController");
const router = express.Router();

router.post("/createBook", createBook);
router.get("/books", getBook);

module.exports = router;
