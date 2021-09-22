import io.undertow.Handlers;
import io.undertow.Undertow;
import Handlers.TestHandler;
import Handlers.Test;
import Handlers.Categories;


public class Book {
    public static void main (String []args){
        Undertow server = Undertow.builder()
                .addHttpListener(8080, "0.0.0.0")
                .setHandler(Handlers.pathTemplate()
                        .add("/books/{bookid}",  new TestHandler())
                        .add("/books/author/{authorname}", new Test())
                        .add("/books/category/{categoryid}",  new Categories())


                )
                .build();
        server.start();
    }
}
