package Model.base;

public class BaseStatus {
    private static double BaseExp = 100;
    private int level;
    private int exp;

    private void addExp(int num) {
        if(num <= 0 ) return;
        if(exp + num < computeExp(level)) {
            exp += num;
            return;
        }
        exp -= num;
        level += 1;
    }

    private static int computeExp(int lv) {
        return (int)( BaseExp * Math.log((double)lv) );
    }

}
