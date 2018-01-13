package iterator

class BookShelf : Aggregate {
    private var books: Array<Book?>
    private var last :Int =0

    constructor(maxsize : Int){
       // this.books = Array(maxsize, )
        books = arrayOfNulls(maxsize);
    }

    fun getBookAt(index : Int): Book?{
        return books[index]
    }

    fun appendBook(book : Book){
        this.books[last] = book
        last++
    }

    fun getLength(): Int{
        return last
    }

    override fun iterator(): Iterator {
        return BookShelfIterator(this)
    }
}