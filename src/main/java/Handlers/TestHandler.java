package Handlers;

import Configuration.BookObj;
import Configuration.Get;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

import java.util.List;

public class TestHandler implements HttpHandler {
    @Override
    public void handleRequest(HttpServerExchange httpServerExchange) throws Exception {
        httpServerExchange.setStatusCode(200);
        Get get = new Get();
        String bookid = httpServerExchange.getQueryParameters().get("bookid").getFirst();
        List<BookObj> b = get.getData(Integer.parseInt(bookid));
        httpServerExchange.getResponseSender().send(b.toString());
    }
}
