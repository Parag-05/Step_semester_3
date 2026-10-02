package main.java.week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;

abstract class Notice {
    private String id;
    private String title;
    private String content;

    public Notice(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }

    public abstract String getCategory();
}

class AcademicNotice extends Notice {
    public AcademicNotice(String id, String title, String content) {
        super(id, title, content);
    }

    @Override
    public String getCategory() { return "Academic"; }
}

class EventNotice extends Notice {
    public EventNotice(String id, String title, String content) {
        super(id, title, content);
    }

    @Override
    public String getCategory() { return "Event"; }
}

class EmergencyNotice extends Notice {
    public EmergencyNotice(String id, String title, String content) {
        super(id, title, content);
    }

    @Override
    public String getCategory() { return "Emergency"; }
}

class Subscriber {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void receiveNotice(Notice notice) {
        System.out.printf("[%s] Notice for %s: %s - %s\n",
                notice.getCategory(), name, notice.getTitle(), notice.getContent());
    }
}

class NoticeBroadcaster {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void broadcast(Notice notice) {
        System.out.println("Broadcasting " + notice.getCategory() + " Notice: " + notice.getTitle());
        for (Subscriber sub : subscribers) {
            sub.receiveNotice(notice);
        }
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBroadcaster broadcaster = new NoticeBroadcaster();

        Subscriber s1 = new Subscriber("Aditya");
        Subscriber s2 = new Subscriber("Meera");

        broadcaster.subscribe(s1);
        broadcaster.subscribe(s2);

        Notice academicNotice = new AcademicNotice("N001", "Mid-Term Schedule", "Exams start next Monday.");
        Notice emergencyNotice = new EmergencyNotice("N002", "Power Outage Alert", "Main library closed after 8 PM today.");

        broadcaster.broadcast(academicNotice);
        broadcaster.broadcast(emergencyNotice);
    }
}