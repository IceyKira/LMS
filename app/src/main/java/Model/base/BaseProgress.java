package Model.base;

public class BaseProgress {
    private int upLimit;
    private int value;
    public BaseProgress(int limit, int val) {
        upLimit = limit;
        value = val;
    }

    private boolean changeProgress(int num) {
        if(value + num > upLimit) return false;
        if(value + num < 0) return false;
        value += num;
        return true;
    }
}
