package Configuration;

public class BookObj {
   private String title;
   private String author;
   private Integer id;
   private String categories;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getcategories() {
        return categories;
    }

    public void setcategories(String categories) {
        this.categories = categories;
    }

//    @Override
//    public String toString(){
//        return "";
//    }

    @Override
    public String toString() {
        return "BookObj{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", categories='" + categories + '\'' +

                ", id=" + id +
                '}';
    }
}



