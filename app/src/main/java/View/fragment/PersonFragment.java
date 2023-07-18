package View.fragment;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.R;

import java.util.ArrayList;

import Model.base.BaseModel;
import Model.base.BaseSkill;
import Model.model.PersonalStatus;
import View.base.BaseFragment;
import View.recycler.PersonAdapter;

public class PersonFragment extends BaseFragment {
    private String TAG = "PersonFragment";
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initViews() {
        RecyclerView recyclerView = contentView.findViewById(R.id.person_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<BaseModel> baseModels = new ArrayList<>();
        PersonalStatus personalStatus = new PersonalStatus();
        baseModels.add(personalStatus);
        baseModels.addAll(personalStatus.getStatus());
        baseModels.add(new BaseSkill("御剑"));
        baseModels.add(new BaseSkill("炼器"));
        baseModels.add(new BaseSkill("岐黄"));
        PersonAdapter personAdapter = new PersonAdapter(baseModels);
        recyclerView.setAdapter(personAdapter);

    }
}
