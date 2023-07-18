package Model.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BaseSkill extends BaseModel{
    private static int skillNum = 0;

    private static Map<String, BaseSkill> skills = new HashMap<String, BaseSkill>();
    public static Map<String, BaseSkill> getSkills() { return skills; }

    private String name;
    private BaseStatus skillLev;
    private BaseSkill parent;

    private ArrayList<BaseSkill> childs = new ArrayList<>();

    public BaseSkill(String name) {
        this.name = name;
        this.skillLev = new BaseStatus(name);
    }

    private void addChild(BaseSkill skill) {
        childs.add(skill);
    }

    public static boolean builtSkill(String name, String[] parent) {
        if(skills.containsKey(name)) return false;
        BaseSkill skill = new BaseSkill(name);
        skills.put(name, skill);
        skillNum++;

        for(String string : parent) {
            if(!skills.containsKey(string)) continue;
            BaseSkill skill1 = skills.get(string);
            skill1.addChild(skill);
        }
        return true;
    }

    private String deleteSkill() { //会同时删去子技能
        if(skillNum == 0) return "无任务";
        if(!skills.containsKey(name)) return "无此任务";
        for(BaseSkill skill : childs){
            skill.deleteSkill();
        }
        skills.remove(name);
        skillNum--;
        return "成功";
    }

    public String getName() {
        return name;
    }

    public BaseSkill getParent() {
        return parent;
    }

    public void setName(String name) {
        skills.remove(this.name);
        skills.put(name, this);
        this.name = name;
    }

    @Override
    public EItemType getItemType() {
        return EItemType.SKILL;
    }
}
