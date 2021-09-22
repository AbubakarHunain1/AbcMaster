package Handlers;

import Configuration.BookObj;


import Configuration.GetCategories;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

import java.util.List;

public class Categories implements HttpHandler {
    @Override
    public void handleRequest(HttpServerExchange httpServerExchange) throws Exception {
        httpServerExchange.setStatusCode(200);
        GetCategories get = new GetCategories();
        String categoryid = httpServerExchange.getQueryParameters().get("categoryid").getFirst();
        List<BookObj> b = get.getData(Integer.parseInt(categoryid));
        httpServerExchange.getResponseSender().send(b.toString());
    }
}
;