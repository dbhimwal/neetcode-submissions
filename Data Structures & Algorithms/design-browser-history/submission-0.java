class BrowserHistory {
    int currentIndex;
    int maxIndex;
    List<String> history = new ArrayList<>();

    public BrowserHistory(String homepage) {
        history.add(homepage);
        currentIndex = 0;
        maxIndex = 0;
    }
    
    public void visit(String url) {
        currentIndex++;
        history.add(currentIndex, url);
        maxIndex = currentIndex;
    }
    
    public String back(int steps) {
        currentIndex = Math.max(currentIndex - steps, 0);
        return history.get(currentIndex);
    }
    
    public String forward(int steps) {
        currentIndex = Math.min(currentIndex + steps, maxIndex);
        return history.get(currentIndex);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */