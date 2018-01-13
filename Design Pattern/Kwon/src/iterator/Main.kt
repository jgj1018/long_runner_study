package iterator

class Main {


}
 fun main(args: Array<String>) {
    var bookShelf : BookShelf = BookShelf(4)
    bookShelf.appendBook(Book("80일간의 세계일주"))
    bookShelf.appendBook(Book("아프니까 청춘이냐"))
    bookShelf.appendBook(Book("성경"))
    bookShelf.appendBook(Book("삼국지"))

    var it: Iterator = bookShelf.iterator()
    while (it.hasNext()){
        var book: Book = it.next() as Book
        println(book.name)
    }
}

