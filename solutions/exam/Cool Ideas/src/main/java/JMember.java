import java.util.*;

public class JMember implements ContentObserver {
    private Set<JTopic> topics  = new HashSet<>();

    public void subscribe(JTopic topic) {
        Validator.checkParam(topic);
        topic.addObservers(this);
        this.topics.add(topic);
    }

    public void unsubscribe(JTopic topic) {
        Validator.checkParam(topic);
        topic.removeObserver(this);
        this.topics.remove(topic);
    }

    public Set<JTopic> getSubscribedTopics() {
        return this.topics;
    }

    @Override
    public void update(JTopic content) {
        System.out.println("The topic " + content.getId() + " has been updated!");
    }
}
