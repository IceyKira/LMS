package Model.model;

import android.util.SparseArray;
import android.util.SparseIntArray;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import Model.base.BaseModel;
import Model.base.BaseProgress;
import Model.base.BaseStatus;
import Model.base.EItemType;

public class PersonalStatus extends BaseModel{
    private String user_name = "IceyKira";

    private String Cla = "Saber";

    private int coin;

    private ArrayList<BaseStatus> status = new ArrayList<>();
    private ArrayList<BaseProgress> progress = new ArrayList<>();

    public PersonalStatus() {
        BaseStatus life = new BaseStatus("人生");
        BaseStatus Con = new BaseStatus("体质");
        BaseStatus Int = new BaseStatus("智慧");
        BaseStatus App = new BaseStatus("魅力");
        BaseStatus Sta = new BaseStatus("耐性");
        BaseProgress Life_Length = new BaseProgress(30000, 7300);
        BaseProgress Hel = new BaseProgress(100, 100);
        BaseProgress Ene = new BaseProgress(100, 100);
        status.add(0, life);
        status.add(1, Con);
        status.add(2, Int);
        status.add(3, App);
        status.add(4, Sta);
        progress.add(0, Life_Length);
        progress.add(1, Hel);
        progress.add(2, Ene);
    }

    private boolean changeCoin(int num) {
        if(coin + num < 0) return false;
        coin += num;
        return true;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getCla() {
        return Cla;
    }

    public int getCoin() {
        return coin;
    }

    public ArrayList<BaseStatus> getStatus() {return status;}

    public ArrayList<BaseProgress> getProgress() {
        return progress;
    }

    @Override
    public EItemType getItemType() {
        return EItemType.PERSONAL;
    }
}
