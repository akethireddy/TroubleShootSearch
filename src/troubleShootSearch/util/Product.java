package troubleShootSearch.util;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private List<String> contentList = null;

    public Product() {
        contentList = new ArrayList<>();
    }

    public List<String> getContentList() {
        return contentList;
    }

    public void setContentList(List<String> contentList) {
        this.contentList = contentList;
    }
}
