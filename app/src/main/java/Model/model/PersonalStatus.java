package Model.model;

import Model.base.BaseModel;
import Model.base.BaseProgress;
import Model.base.BaseStatus;

public class PersonalStatus extends BaseModel {
    private String user_name = "IceyKira";

    private BaseStatus life = new BaseStatus();

    private int coin;

    private BaseProgress Life_Length = new BaseProgress(30000, 7300);

    private BaseStatus Con = new BaseStatus();

    private BaseStatus Int = new BaseStatus();

    private BaseStatus App = new BaseStatus();

    private BaseStatus Sta = new BaseStatus();

    private BaseProgress Hel = new BaseProgress(100, 100);

    private BaseProgress Prs = new BaseProgress(100, 0);

    private boolean changeCoin(int num) {
        if(coin + num < 0) return false;
        coin += num;
        return true;
    }

}
