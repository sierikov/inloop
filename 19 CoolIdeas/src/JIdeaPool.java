import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class JIdeaPool {
    private Map<JTopic, Set<JIdea>> pool;

    public JIdeaPool() {
        this.pool = new HashMap<>();
    }

    public void add(JTopic topic) {
        Objects.requireNonNull(topic);
        if (!pool.containsKey(topic)) pool.put(topic, new HashSet<>());
    }

    public void add(JIdea idea, JTopic topic) {
        Objects.requireNonNull(idea);
        Objects.requireNonNull(topic);
        // TODO: Refactor it later (never)
        boolean ideaFound = false;
        if (this.pool.containsKey(topic)) {
            Set<JIdea> setOfIdeas = this.pool.get(topic);
            for (JIdea i : setOfIdeas) {
                if (i.getTitle().equals(idea.getTitle())) {
                    ideaFound = true;
                    break;
                }
            }
            if (!ideaFound) setOfIdeas.add(idea);
        }
        else {
            Collection<Set<JIdea>> ideas = pool.values();
            for (Set<JIdea> set : ideas){
                for (JIdea i : set){
                    if (idea.getTitle().equals(i.getTitle()) && idea != i) {
                        ideaFound = true;
                        break;
                    }
                }
            }
            if (!ideaFound) {
                Set<JIdea> newIdeaSet = new HashSet<>();
                newIdeaSet.add(idea);
                this.pool.put(topic, newIdeaSet);
            }
        }
    }

    public boolean remove(JTopic topic) {
        Objects.requireNonNull(topic);
        return pool.remove(topic) != null;
    }

    public boolean remove(JIdea ideaToRemove) {
        Objects.requireNonNull(ideaToRemove);
        Collection<Set<JIdea>> ideas = pool.values();
        boolean removed = false;
        for (Set<JIdea> setOfIdeas : ideas)
            if (setOfIdeas.remove(ideaToRemove)) removed = true;
        return removed;
    }

    public JIdea getIdea(String title) {
        Validator.checkParam(title);
        Collection<Set<JIdea>> ideas = pool.values();
        for (Set<JIdea> setOfIdeas : ideas)
            for (JIdea idea : setOfIdeas)
                if (idea.getTitle().equals(title)) return idea;
        return null;
    }

    public int numberOfTopics() {
        return pool.size();
    }

    public int numberOfIdeas() {
        Set<String> uniq = new HashSet<>();
        Collection<Set<JIdea>> ideas = pool.values();
        for (Set<JIdea> setOfIdeas : ideas)
            for (JIdea idea : setOfIdeas)
                uniq.add(idea.getTitle());
        return uniq.size();
    }


    public void removeDeclined() {
        this.remove(JIdea::isDeclined);
    }

    public void removeReleased() {
        this.remove(JIdea::isReleased);
    }

    private void remove(Predicate<JIdea> predicate){
        Collection<Set<JIdea>> ideas = pool.values();
        for (Set<JIdea> setOfIdeas : ideas) {
            Iterator<JIdea> iterator = setOfIdeas.iterator();
            while (iterator.hasNext())
                if (predicate.test(iterator.next()))
                    iterator.remove();
        }
    }


}
