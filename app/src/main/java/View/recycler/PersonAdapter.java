package View.recycler;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.R;

import java.util.ArrayList;

import Model.base.BaseModel;
import Model.base.BaseSkill;
import Model.base.BaseStatus;
import Model.base.EItemType;
import Model.model.PersonalStatus;
import View.base.BaseAdapter;
import View.base.BaseViewHolder;

public class PersonAdapter extends BaseAdapter {
    private String TAG = "PersonAdapter";

    public PersonAdapter(ArrayList data) {
        super(data);
    }

    @Override
    protected void initItemType() {
        addItemType(EItemType.PERSONAL.getId(), R.layout.recyclerview_status);
        addItemType(EItemType.STATUS.getId(), R.layout.item_statusbar);
        addItemType(EItemType.SKILL.getId(), R.layout.item_skill);
    }

    @Override
    protected void convertData(BaseViewHolder holder, BaseModel baseModel, int position) {
        EItemType itemViewType = baseModel.getItemType();
        switch (itemViewType) {
            case PERSONAL:
                convertCase1(holder, (PersonalStatus) baseModel);
                break;
            case STATUS:
                convertCase2(holder, (BaseStatus) baseModel);
                break;
            case SKILL:
                convertCase3(holder, (BaseSkill) baseModel);
                break;

        }
    }

    private void convertCase3(BaseViewHolder holder, BaseSkill baseModel) {
        holder.setText(R.id.skill_name, baseModel.getName());
    }

    private void convertCase2(BaseViewHolder holder, BaseStatus baseModel) {
        holder.setText(R.id.status_name, baseModel.getName());
    }

    private void convertCase1(BaseViewHolder holder, PersonalStatus personalStatus) {
        holder.setText(R.id.user_name, personalStatus.getUser_name());
        holder.setText(R.id.coin, String.valueOf(personalStatus.getCoin()));
    }

}
















