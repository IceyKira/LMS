package View.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.R;
import View.base.BaseFragment;

public class PersonFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initViews() {
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.person_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(binding.getRoot().getContext());
        recyclerView.setLayoutManager(linearLayoutManager);



    }
}
