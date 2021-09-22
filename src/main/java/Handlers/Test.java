package Handlers;

import Configuration.BookObj;
import Configuration.Get;
import Configuration.GetAuthor;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

import java.util.List;

public class Test implements HttpHandler {
    @Override
    public void handleRequest(HttpServerExchange httpServerExchange) throws Exception {
        httpServerExchange.setStatusCode(200);
        GetAuthor get = new GetAuthor();
        String authorname = httpServerExchange.getQueryParameters().get("authorname").getFirst();
        List<BookObj> b = get.getData(new String(authorname));
        httpServerExchange.getResponseSender().send(b.toString());
    }
}
