package iterator

class BookShelfIterator : Iterator {

    var bookshelf : BookShelf? = null
    var index : Int = 0

    constructor(bookshelf: BookShelf){
        this.bookshelf = bookshelf
    }

    override fun hasNext(): Boolean {
        if(index < bookshelf!!.getLength()){
            return true
        }
        return false
    }

    override fun next(): Any {
        var book: Book = bookshelf!!.getBookAt(index)!!
        index ++
        return book
    }
}