import java.util.*;

public class JMember implements Observer {
    private Set<JTopic> topics  = new HashSet<>();

    @Override
    public void update(Observable jTopic, Object o) {
        JTopic topic;
        if (jTopic instanceof JTopic) {
            topic = (JTopic) jTopic;
            System.out.println("The topic " + topic.getId() + " has been updated!");
        }
    }

    public void subscribe(JTopic topic) {
        Objects.requireNonNull(topic);
        topic.addObserver(this);
        this.topics.add(topic);
    }

    public void unsubscribe(JTopic topic) {
        Objects.requireNonNull(topic);
        topic.deleteObserver(this);
        this.topics.remove(topic);
    }

    public Set<JTopic> getSubscribedTopics() {
        return this.topics;
    }
}
