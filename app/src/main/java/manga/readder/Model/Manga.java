package manga.readder.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class Manga {
    private String linkImage;
    private String mangaName;

    public Manga() {
    }

    public Manga(JSONObject o) throws JSONException{
        mangaName = o.getString("mangaName");
        linkImage = o.getString("linkImage");
    }

    public Manga(String linkImage, String mangaName) {
        this.linkImage = linkImage;
        this.mangaName = mangaName;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getMangaName() {
        return mangaName;
    }

    public void setMangaName(String mangaName) {
        this.mangaName = mangaName;
    }
}
