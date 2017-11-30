package facade.additional

import java.io.IOException
import java.io.Writer

class HtmlWriter(val writer:Writer) {


    @Throws(IOException::class)
    fun title(title:String){
        writer.write("<html>")
        writer.write("<head>")
        writer.write("<title> $title </title>")
        writer.write("</head>")
        writer.write("<body>\n")
        writer.write("<h1> $title </h1>\n")

    }


    @Throws(IOException::class)
    fun paragraph(msg: String){
        writer.write("<p>$msg</p>\n")
    }


    @Throws(IOException::class)
    fun link(href:String, caption:String){
        paragraph("<a href=\"$href\">$caption</a>")
    }


    @Throws(IOException::class)
    fun mailto(mailaddr:String, username:String){
        link("mailto$mailaddr", username)
    }

    @Throws(IOException::class)
    fun close(){
        writer.write("</body>")
        writer.write("</html>\n")
        writer.close()

    }
}