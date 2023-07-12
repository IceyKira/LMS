package Model.base;

import java.util.HashMap;
import java.util.Map;

public class BaseSkill {
    private static int skillNum = 0;
    Map<String, BaseSkill> skills = new HashMap<String, BaseSkill>();
    private String name;
    private BaseStatus skillLev;
    private BaseSkill parent;

    public BaseSkill(String name, BaseSkill parent) {
        this.name = name;
        this.skillLev = new BaseStatus();
        this.parent = parent;
    }

    public boolean builtSkill(String name, BaseSkill parent) {
        if(skills.containsKey(name)) return false;
        BaseSkill skill = new BaseSkill(name, parent);
        skills.put(name, skill);
        skillNum++;
        return true;
    }

    private String deleteSkill(String name) {
        if(skillNum == 0) return "无任务";
        if(!skills.containsKey(name)) return "无此任务";
        for(BaseSkill skill : skills.values()){

        }
        skills.remove(name);
        return "成功";
    }

}
