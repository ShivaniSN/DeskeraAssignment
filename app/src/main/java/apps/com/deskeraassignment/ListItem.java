package apps.com.deskeraassignment;

public class ListItem {

    String stringName,stringDescription,stringCategory;
    boolean isFavourite = false;

    public ListItem(){

    }

    public String getStringName() {
        return stringName;
    }

    public void setStringName(String stringName) {
        this.stringName = stringName;
    }

    public String getStringDescription() {
        return stringDescription;
    }

    public void setStringDescription(String stringDescription) {
        this.stringDescription = stringDescription;
    }

    public String getStringCategory() {
        return stringCategory;
    }

    public void setStringCategory(String stringCategory) {
        this.stringCategory = stringCategory;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public boolean getFavourite() {
        return isFavourite;
    }
}
