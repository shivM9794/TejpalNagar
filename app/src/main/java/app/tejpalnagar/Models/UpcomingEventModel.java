package app.tejpalnagar.Models;

public class UpcomingEventModel {

    int imageView;
    private String eventTitle;

    public UpcomingEventModel(int imageView, String eventTitle) {
        this.imageView = imageView;
        this.eventTitle = eventTitle;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
}
